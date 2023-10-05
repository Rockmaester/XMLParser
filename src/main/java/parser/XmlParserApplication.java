package parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class XmlParserApplication implements CommandLineRunner {

    @Autowired
    XMLParser xmlParser;

    public static void main(String[] args) {
        SpringApplication.run(XmlParserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Заглушка
        String stringUrl = "http://integration.modeus-pages.custis.ru/docs/in/employees/groups.ru.files/groups.xsd";
        args = new String[1];
        args[0] = stringUrl;

        if(args.length > 0){

            try {
                System.out.println(xmlParser);
                xmlParser.parseFile(FileDownloader.downloadFile(stringUrl));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
}
