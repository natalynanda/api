-- -----------------------------------------------------
-- Table "CATEGORY"
-- -----------------------------------------------------
CREATE TABLE  CATEGORY (
  "category_id" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "active" BOOLEAN NOT NULL,
  PRIMARY KEY ("category_id"));


-- -----------------------------------------------------
-- Table "PRODUCT"
-- -----------------------------------------------------
CREATE TABLE  PRODUCT (
  "product_id" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "category_id" INT NOT NULL,
  "barcode" VARCHAR(150) NULL,
  "sale_price" DECIMAL(16,2) NULL,
  "stock_quantity" INT NOT NULL,
  "active" BOOLEAN NULL,
  PRIMARY KEY ("product_id"),
  CONSTRAINT "fk_PRODUCT_CATEGORY"
    FOREIGN KEY ("category_id")
    REFERENCES CATEGORY ("category_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "CLIENT"
-- -----------------------------------------------------
CREATE TABLE  CLIENT (
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "last_name" VARCHAR(100) NULL,
  "cellphone" NUMERIC NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "SALE"
-- -----------------------------------------------------
CREATE TABLE  SALE (
  "sale_id" SERIAL NOT NULL,
  "client_id" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "pay_method" CHAR(1) NULL,
  "comments" VARCHAR(300) NULL,
  "state" CHAR(1) NULL,
  PRIMARY KEY ("sale_id"),
  CONSTRAINT "fk_SALE_CLIENT1"
    FOREIGN KEY ("client_id")
    REFERENCES CLIENT ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "SALE_PRODUCT"
-- -----------------------------------------------------
CREATE TABLE  SALE_PRODUCT (
  "sale_id" INT NOT NULL,
  "product_id" INT NOT NULL,
  "quantity" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "state" BOOLEAN NULL,
  PRIMARY KEY ("sale_id", "product_id"),
  CONSTRAINT "fk_SALE_PRODUCT_PRODUCT1"
    FOREIGN KEY ("product_id")
    REFERENCES PRODUCT ("product_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_SALE_PRODUCT_SALE1"
    FOREIGN KEY ("sale_id")
    REFERENCES SALE ("sale_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);