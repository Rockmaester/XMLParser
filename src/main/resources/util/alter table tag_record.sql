ALTER TABLE tag_record
    ADD CONSTRAINT FK_TAG_RECORD_ON_FILE_FILE FOREIGN KEY (parsed_file_id) REFERENCES parsed_file (file_id);