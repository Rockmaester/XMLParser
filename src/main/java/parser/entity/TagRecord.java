package parser.entity;

import javax.persistence.*;

@Entity
@Table(name = "tag_record")
public class TagRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;
    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "frequency")
    private int tagFrequency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parsed_file_id")
    private ParsedFileInfo parsedFileInfo;

    public TagRecord() {
    }

    public TagRecord(ParsedFileInfo parsedFileInfo) {
        this.parsedFileInfo = parsedFileInfo;
    }

    public TagRecord(String tagName, int tagFrequency, ParsedFileInfo parsedFileInfo) {
        this.tagName = tagName;
        this.tagFrequency = tagFrequency;
        this.parsedFileInfo = parsedFileInfo;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagFrequency() {
        return tagFrequency;
    }

    public void setTagFrequency(int tagFrequency) {
        this.tagFrequency = tagFrequency;
    }

    public ParsedFileInfo getParsedFileInfo() {
        return parsedFileInfo;
    }

    public void setParsedFileInfo(ParsedFileInfo parsedFileInfo) {
        this.parsedFileInfo = parsedFileInfo;
    }
}
