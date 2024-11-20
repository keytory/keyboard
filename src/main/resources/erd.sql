CREATE TABLE `switches` (
    `switch_id` int NOT NULL AUTO_INCREMENT,
    `company_id` BIGINT NOT NULL,
    `switch_type_key` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NULL,
    `sound` VARCHAR(255) NULL,
    `actuation_force` VARCHAR(255) NULL,
    PRIMARY KEY (`switch_id`)
);

CREATE TABLE `company` (
    `company_id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`company_id`)
);

CREATE TABLE `switch_type` (
    `switch_type_key` VARCHAR(255) NOT NULL,
    `field` VARCHAR(255) NULL,
    PRIMARY KEY (`switch_type_key`)
);

CREATE TABLE `keytory` (
    `keytory_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'auto-increment',
    `user_id` BIGINT NOT NULL COMMENT 'FK',
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(20) NOT NULL,
    `background_color` VARCHAR(7) NOT NULL COMMENT 'RGB',
    `layout` VARCHAR(10) NOT NULL,
    `housing_color` VARCHAR(7) NOT NULL COMMENT 'RGB',
    `housing_style_id` TINYINT NOT NULL,
    `housing_material_id` TINYINT NOT NULL,
    `legend_color` VARCHAR(7) NOT NULL COMMENT 'RGB',
    `switch_id` INT NOT NULL,
    `keycap_style_id` TINYINT NOT NULL,
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '공개, 비공개',
    `view_count` BIGINT NOT NULL DEFAULT 0,
    `is_deleted` TINYINT NOT NULL DEFAULT 0,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NULL,
    PRIMARY KEY (`keytory_id`)
);

CREATE TABLE `housing_style` (
    `housing_style_id` TINYINT NOT NULL,
    `name` VARCHAR(10) NOT NULL CHECK (`name` IN ('각진', '둥근')),
    PRIMARY KEY (`housing_style_id`)
);

CREATE TABLE `housing_material` (
    `housing_material_id` TINYINT NOT NULL,
    `name` VARCHAR(10) NOT NULL CHECK (`name` IN ('매트', '브러쉬', '광택')),
    PRIMARY KEY (`housing_material_id`)
);

CREATE TABLE `keycap_style` (
    `keycap_style_id` TINYINT NOT NULL,
    `name` VARCHAR(10) NOT NULL CHECK (`name` IN ('체리식', 'OEM', 'MG')),
    PRIMARY KEY (`keycap_style_id`)
);

CREATE TABLE `custom_attributes` (
    `custom_attribute_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'auto-increment',
    `keytory_id` BIGINT NOT NULL COMMENT 'FK',
    `background_color` VARCHAR(7) NOT NULL,
    `legend_color` VARCHAR(7) NOT NULL,
    PRIMARY KEY (`custom_attribute_id`)
);

ALTER TABLE `switches`
    ADD CONSTRAINT `FK_company_TO_switches` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

ALTER TABLE `switches`
    ADD CONSTRAINT `FK_switch_type_TO_switches` FOREIGN KEY (`switch_type_key`) REFERENCES `switch_type` (`switch_type_key`);

ALTER TABLE `keytory`
    ADD CONSTRAINT `FK_housing_style_TO_keytory` FOREIGN KEY (`housing_style_id`) REFERENCES `housing_style` (`housing_style_id`);

ALTER TABLE `keytory`
    ADD CONSTRAINT `FK_housing_material_TO_keytory` FOREIGN KEY (`housing_material_id`) REFERENCES `housing_material` (`housing_material_id`);

ALTER TABLE `keytory`
    ADD CONSTRAINT `FK_switches_TO_keytory` FOREIGN KEY (`switch_id`) REFERENCES `switches` (`switch_id`);

ALTER TABLE `keytory`
    ADD CONSTRAINT `FK_keycap_style_TO_keytory` FOREIGN KEY (`keycap_style_id`) REFERENCES `keycap_style` (`keycap_style_id`);

ALTER TABLE `custom_attributes`
    ADD CONSTRAINT `FK_keytory_TO_custom_attributes` FOREIGN KEY (`keytory_id`) REFERENCES `keytory` (`keytory_id`);
