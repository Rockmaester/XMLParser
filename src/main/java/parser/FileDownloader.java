package parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileDownloader {
    final static String OUTPUT_DIR = "src/main/java/parser/storage";

    static Path downloadFile(String stringUrl) throws IOException {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStream inputStream = connection.getInputStream();
        String fullName = OUTPUT_DIR + "/" + UUID.randomUUID().toString() + ".xml";
        Path path = new File(fullName).toPath();
        Files.copy(inputStream, path);
        return path;
    }
}
