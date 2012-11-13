INSERT INTO `student` (`id`,`creationDate`,`address`,`cedula`,`cellphone`,`email`,`lastname`,`name`,`phone`,`fechaInscripcionFac`,`studentNum`) VALUES (1,'2012-11-13 18:45:33',NULL,'someCedula',NULL,'chupame@eltobonia.net',NULL,'Chupito',NULL,'2012-11-13 18:45:33','cb4d30ab-a8fe-4644-9c02-ef19eb07722a');

INSERT INTO `curso` (`id`,`creationDate`,`name`,`uuid`,`descripcion`,`fechaFin`,`fechaInicio`,`horario`,`nota`,`salon`,`semestre`,`turno`) VALUES (1,'2012-11-13 18:45:35','Plastilina 101 vesp.','70d2ff46-7f3d-42c7-aa23-aaf1f6d7f818',NULL,'2012-11-13 18:45:35','2012-11-13 18:45:35','Los jueves de 9 a 10:30',NULL,NULL,'Par',1);

INSERT INTO `carreer` (`id`,`creationDate`,`name`,`uuid`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (1,'2012-11-13 18:45:34','Ingenieria Mecanica','8cc47aba-6005-4145-82ab-1cc3b7285216',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`name`,`uuid`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (2,'2012-11-13 18:45:34','Ingenieria Civil','89813a51-4dcd-4f80-8987-4771e7b8ca85',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`name`,`uuid`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (3,'2012-11-13 18:45:34','Ingenieria Quimica','bcff6f17-0693-40c7-9a77-3a7b55e777e0',NULL,NULL,NULL);
INSERT INTO `carreer` (`id`,`creationDate`,`name`,`uuid`,`intermediateCredits`,`intermediateTitle`,`totalCredits`) VALUES (4,'2012-11-13 18:45:34','Ingenieria Computacion','e1265580-747e-4809-bfe4-ecc53481e1f7',NULL,NULL,NULL);

INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (1,'2012-11-13 18:45:34',NULL,NULL,0,0,1,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (2,'2012-11-13 18:45:34',NULL,NULL,0,0,2,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (3,'2012-11-13 18:45:35',NULL,NULL,0,0,3,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (4,'2012-11-13 18:45:35',NULL,NULL,0,0,4,NULL,1);
INSERT INTO `inscripcion` (`id`,`creationDate`,`fechaDesistir`,`fechaInscripcion`,`isValid`,`tipo`,`carrera`,`curso`,`estudiante`) VALUES (5,'2012-11-13 18:45:35',NULL,NULL,0,1,NULL,1,1);
