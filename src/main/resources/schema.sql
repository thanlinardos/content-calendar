-- CREATE DATABASE IF NOT EXISTS appDb
CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    content_desc text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

-- INSERT INTO Content(title,content_desc,status,content_type,date_created)
-- VALUES ('My Data Plog Post','A post about spring data','IDEA','ARTICLE',CURRENT_TIMESTAMP)