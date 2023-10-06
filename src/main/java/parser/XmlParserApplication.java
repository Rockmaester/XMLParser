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
        if (args.length > 0) {
            xmlParser.parseFile(args[0]);
        }
        System.exit(0);
    }
}
