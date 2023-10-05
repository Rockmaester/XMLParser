package parser.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import parser.entity.ParsedFile;

public interface FileInfoRepo extends JpaRepository<ParsedFile, Long> {
}
