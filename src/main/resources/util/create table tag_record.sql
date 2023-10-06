CREATE TABLE tag_record
(
    record_id    BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    tag_name     VARCHAR(255), -- имя тега в файле
    frequency    INT, -- частота появления тега в файле
    parsed_file_id BIGINT, -- ссылка на файл
    CONSTRAINT pk_tag_record PRIMARY KEY (record_id)
);