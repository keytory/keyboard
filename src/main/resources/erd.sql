CREATE TABLE company (
                         company_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(25) UNIQUE
);

CREATE TABLE switch_type (
                             switch_type_id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(25) UNIQUE
);

CREATE TABLE switches (
                          switch_id INT AUTO_INCREMENT PRIMARY KEY,
                          company_id BIGINT,
                          switch_type_id INT,
                          name VARCHAR(25) NOT NULL,
                          sound VARCHAR(25),
                          CONSTRAINT fk_switches_company FOREIGN KEY (company_id) REFERENCES company(company_id),
                          CONSTRAINT fk_switches_switch_type FOREIGN KEY (switch_type_id) REFERENCES switch_type(switch_type_id)
);

CREATE TABLE keytory (
                         keytory_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT,
                         name VARCHAR(25) NOT NULL,
                         description VARCHAR(255),
                         background_color VARCHAR(7),
                         layout ENUM('75%', '80%', '100%') NOT NULL,
                         housing_color VARCHAR(7),
                         housing_style ENUM('둥근', '각진') NOT NULL,
                         housing_material ENUM('매트', '브러쉬', '광택') NOT NULL,
                         legend_color VARCHAR(7),
                         switch_id INT,
                         keycap_style ENUM('체리', 'OEM', 'MG') NOT NULL,
                         status INT,
                         view_count BIGINT DEFAULT 0,
                         is_deleted INT DEFAULT 0,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         CONSTRAINT fk_keytory_switch FOREIGN KEY (switch_id) REFERENCES switches(switch_id)
);

CREATE TABLE custom_attributes (
                                   custom_attributes_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   keytory_id BIGINT NOT NULL,
                                   background_color VARCHAR(7) NOT NULL,
                                   legend_color VARCHAR(7) NOT NULL,
                                   CONSTRAINT fk_custom_attributes_keytory FOREIGN KEY (keytory_id) REFERENCES keytory(keytory_id)
);
