package parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileDownloader {
    final static String OUTPUT_DIR = "src/main/java/parser/storage";

    static Path downloadFile(String stringUrl) throws IOException {
        URL url;
        URLConnection connection;
        InputStream inputStream;
        Path outputFilePath;


        url = new URL(stringUrl);
        connection = url.openConnection();
        inputStream = connection.getInputStream();
        String outputFileAbsoluteName = OUTPUT_DIR + "/" + UUID.randomUUID() + ".xml";
        outputFilePath = new File(outputFileAbsoluteName).toPath();
        Files.copy(inputStream, outputFilePath);
        return outputFilePath;
    }
}
