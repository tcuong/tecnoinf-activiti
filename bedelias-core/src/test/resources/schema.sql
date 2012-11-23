INSERT INTO `student` (`id`,`creationDate`,`address`,`cedula`,`cellphone`,`email`,`lastname`,`name`,`phone`,`fechaInscripcionFac`,`studentNum`) VALUES (1,'2012-11-12 22:33:12',NULL,'someCedula',NULL,'chupame@eltobonia.net',NULL,'Chupito',NULL,'2012-11-12 22:33:12',?);

INSERT INTO `carreer` (`id`,`creationDate`,`code`,`name`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (1,'2012-11-12 22:33:13',?,'Ingenieria Mecanica',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`code`,`name`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (2,'2012-11-12 22:33:13',?,'Ingenieria Civil',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`code`,`name`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (3,'2012-11-12 22:33:13',?,'Ingenieria Quimica',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`code`,`name`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (4,'2012-11-12 22:33:13',?,'Ingenieria Computacion',NULL,NULL,NULL);

INSERT INTO `curso` (`id`,`creationDate`,`code`,`name`,`descripcion`,`fechaFin`,`fechaInicio`,`horario`,`nota`,`salon`,`semestre`,`turno`) VALUES (1,'2012-11-12 22:33:13',?,'Plastilina 101 vesp.',NULL,'2012-11-12 22:33:13','2012-11-12 22:33:13','Los jueves de 9 a 10:30',NULL,NULL,'Par',1);

INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (1,'2012-11-12 22:33:13',NULL,NULL,0,0,1,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (2,'2012-11-12 22:33:13',NULL,NULL,0,0,2,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (3,'2012-11-12 22:33:13',NULL,NULL,0,0,3,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (4,'2012-11-12 22:33:13',NULL,NULL,0,0,4,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (5,'2012-11-12 22:33:13',NULL,NULL,0,1,NULL,1,1);
