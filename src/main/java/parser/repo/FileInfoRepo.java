package parser.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import parser.entity.ParsedFileInfo;

public interface FileInfoRepo extends JpaRepository<ParsedFileInfo, Long> {
}
