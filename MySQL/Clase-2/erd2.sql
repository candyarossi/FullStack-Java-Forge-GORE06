-- MySQL Script generated by MySQL Workbench
-- Wed Oct 23 17:49:45 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bootcamps_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bootcamps_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bootcamps_db` DEFAULT CHARACTER SET utf8 ;
USE `bootcamps_db` ;

-- -----------------------------------------------------
-- Table `bootcamps_db`.`idiomas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`idiomas` (
  `id_idioma` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_idioma`),
  UNIQUE INDEX `id_idioma_UNIQUE` (`id_idioma` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`regiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`regiones` (
  `id_region` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_region`),
  UNIQUE INDEX `id_region_UNIQUE` (`id_region` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`autores` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `idiomas_id_idioma` INT NOT NULL,
  `regiones_id_region` INT NOT NULL,
  PRIMARY KEY (`id_autor`, `idiomas_id_idioma`, `regiones_id_region`),
  UNIQUE INDEX `id_autor_UNIQUE` (`id_autor` ASC) VISIBLE,
  INDEX `fk_autores_idiomas1_idx` (`idiomas_id_idioma` ASC) VISIBLE,
  INDEX `fk_autores_regiones1_idx` (`regiones_id_region` ASC) VISIBLE,
  CONSTRAINT `fk_autores_idiomas1`
    FOREIGN KEY (`idiomas_id_idioma`)
    REFERENCES `bootcamps_db`.`idiomas` (`id_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autores_regiones1`
    FOREIGN KEY (`regiones_id_region`)
    REFERENCES `bootcamps_db`.`regiones` (`id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`formatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`formatos` (
  `id_formato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_formato`),
  UNIQUE INDEX `id_formato_UNIQUE` (`id_formato` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`bootcamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`bootcamps` (
  `id_bootcamp` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `autores_id_autor` INT NOT NULL,
  `formatos_id_formato` INT NOT NULL,
  PRIMARY KEY (`id_bootcamp`, `autores_id_autor`, `formatos_id_formato`),
  UNIQUE INDEX `id_bootcamp_UNIQUE` (`id_bootcamp` ASC) VISIBLE,
  INDEX `fk_bootcamps_autores_idx` (`autores_id_autor` ASC) VISIBLE,
  INDEX `fk_bootcamps_formatos1_idx` (`formatos_id_formato` ASC) VISIBLE,
  CONSTRAINT `fk_bootcamps_autores`
    FOREIGN KEY (`autores_id_autor`)
    REFERENCES `bootcamps_db`.`autores` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bootcamps_formatos1`
    FOREIGN KEY (`formatos_id_formato`)
    REFERENCES `bootcamps_db`.`formatos` (`id_formato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`temas` (
  `id_tema` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tema`),
  UNIQUE INDEX `id_tema_UNIQUE` (`id_tema` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bootcamps_db`.`bootcamps_x_temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamps_db`.`bootcamps_x_temas` (
  `bootcamps_id_bootcamp` INT NOT NULL,
  `temas_id_tema` INT NOT NULL,
  PRIMARY KEY (`bootcamps_id_bootcamp`, `temas_id_tema`),
  INDEX `fk_bootcamps_has_temas_temas1_idx` (`temas_id_tema` ASC) VISIBLE,
  INDEX `fk_bootcamps_has_temas_bootcamps1_idx` (`bootcamps_id_bootcamp` ASC) VISIBLE,
  CONSTRAINT `fk_bootcamps_has_temas_bootcamps1`
    FOREIGN KEY (`bootcamps_id_bootcamp`)
    REFERENCES `bootcamps_db`.`bootcamps` (`id_bootcamp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bootcamps_has_temas_temas1`
    FOREIGN KEY (`temas_id_tema`)
    REFERENCES `bootcamps_db`.`temas` (`id_tema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;