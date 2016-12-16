CREATE SEQUENCE contacts_seq START WITH 1 CACHE 100;
CREATE TABLE contacts (id BIGINT NOT NULL, address VARCHAR(255), birthdate TIMESTAMP, contact_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, email VARCHAR(255), identity_id VARCHAR(255), lastname VARCHAR(255), locality VARCHAR(255), mobile_phone VARCHAR(255), name VARCHAR(255), notes VARCHAR(255), phone VARCHAR(255), postal_code VARCHAR(255), region BIGINT, PRIMARY KEY (id));
CREATE TABLE regions (id BIGINT NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE INDEX I_CONTCTS_REGION ON contacts (region);