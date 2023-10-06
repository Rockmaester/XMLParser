package parser.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "parsed_file")
public class ParsedFileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "parsed_at")
    private Date date;

    @Column(name = "file_status")
    private String fileStatus;

    @Column(name = "error_message")
    private String errorMessage;

    public ParsedFileInfo() {
    }

    public ParsedFileInfo(String fileUrl, Date date) {
        this.fileUrl = fileUrl;
        this.date = date;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ParsedFile{" +
                "fileId=" + fileId +
                ", fileUrl='" + fileUrl + '\'' +
                ", date=" + date +
                ", fileStatus='" + fileStatus + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
