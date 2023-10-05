package parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parser.entity.ParsedFile;
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

    void parseFile(Path filePath) {

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath.toString()))) {
            while (fileReader.ready()){
                fileContent.append(fileReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileContentLikeString = fileContent.toString().replaceAll("[\\r\\n]+", "");

        Map<String, Integer> map = new HashMap<>();

        Pattern pattern = Pattern.compile("<\\w+:?\\w+");
        Matcher matcher = pattern.matcher(fileContentLikeString);
        while (matcher.find()){
            String s = matcher.group();
            s = s.replace("<", "");
            map.merge(s,1, (oldVal, newVal) -> oldVal + newVal);
        }

        System.out.println(map); // todo

        ParsedFile parsedFile = new ParsedFile(filePath.toString(), new Date(), "successful", "no errors");
        System.out.println(parsedFile);
        fileInfoService.save(parsedFile);

        try {
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
