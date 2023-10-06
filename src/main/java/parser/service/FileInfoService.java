package parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parser.entity.ParsedFileInfo;
import parser.repo.FileInfoRepo;


@Service
public class FileInfoService {
    @Autowired
    private FileInfoRepo fileInfoRepo;

    public void save(ParsedFileInfo parsedFileInfo){
        fileInfoRepo.save(parsedFileInfo);
    }
}
