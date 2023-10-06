CREATE TABLE parsed_file
(
    file_id       BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    file_url      VARCHAR(255),
    parsed_at     TIMESTAMP, -- дата и время обработки файла
    file_status   VARCHAR(255), -- статус обработки файла – SUCCESS или FAILURE
    error_message VARCHAR(255), -- сообщение об ошибке (для статуса = FAILURE)
    CONSTRAINT pk_parsed_file PRIMARY KEY (file_id)
);