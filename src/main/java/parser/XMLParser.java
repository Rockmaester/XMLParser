package parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parser.entity.ParsedFileInfo;
import parser.entity.TagRecord;
import parser.service.FileInfoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class XMLParser {

    @Autowired
    private FileInfoService fileInfoService;

    void parseFile(String stringUrl) {
        ParsedFileInfo parsedFileInfo = new ParsedFileInfo(stringUrl, new Date());
        Path storageFilePath;

        try {
            storageFilePath = FileDownloader.downloadFile(stringUrl);
        } catch (IOException e) {
            parsedFileInfo.setFileStatus("FAILURE");
            parsedFileInfo.setErrorMessage("Error reading file from web by url");
            fileInfoService.save(parsedFileInfo);
            return;
        }

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(storageFilePath.toString()))) {
            while (fileReader.ready()) {
                fileContent.append(fileReader.readLine());
            }
        } catch (IOException e) {
            parsedFileInfo.setFileStatus("FAILURE");
            parsedFileInfo.setErrorMessage("Incoming file reading error");
            fileInfoService.save(parsedFileInfo);
            return;
        }

        String fileContentLikeString = fileContent.toString().replaceAll("[\\r\\n]+", "");
        Map<String, Integer> map = new HashMap<>();

        Pattern pattern = Pattern.compile("<\\w+:?\\w+");
        Matcher matcher = pattern.matcher(fileContentLikeString);
        while (matcher.find()) {
            String s = matcher.group();
            s = s.replace("<", "");
            map.merge(s, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            parsedFileInfo.addTagRecordToList(new TagRecord(pair.getKey(), pair.getValue(), parsedFileInfo));
        }

        parsedFileInfo.setFileStatus("SUCCESS");
        fileInfoService.save(parsedFileInfo);

        try {
            Files.delete(storageFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
