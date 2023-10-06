package parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlParserApplication implements CommandLineRunner {

    @Autowired
    XMLParser xmlParser;

    public static void main(String[] args) {
        SpringApplication.run(XmlParserApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Заглушка
        String stringUrl = "http://integration.modeus-pages.custis.ru/docs/in/employees/groups.ru.files/groups.xsd";
        args = new String[1];
        args[0] = stringUrl;

        if(args.length > 0){
            xmlParser.parseFile(args[0]);
        }
        System.exit(0);
    }
}
