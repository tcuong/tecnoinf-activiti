INSERT INTO `Student` VALUES (1,'2012-11-25 15:37:57',NULL,'47720720',NULL,'carlosactiviti@gmail.com',NULL,'Ramon Dominguez',NULL,'2012-11-25 15:37:57', null, null, 'password', '249e543a-99e8-48eb-8a0d-f9d3f5dab090'), (2,'2012-11-25 15:37:57',NULL,'47720734',NULL,'paploperez@gmail.com',NULL,'Pablo Perez',NULL,'2012-11-25 15:37:57', null, null, 'password', '249f543a-99e8-48eb-8a0d-f9d3f5dab090');

INSERT INTO `Carreer` VALUES (1,'2012-11-25 15:37:57','Ingenieria Mecanica','2431c36c-7533-4254-8f55-6f8a39934989',NULL,NULL,NULL),(2,'2012-11-25 15:37:57','Ingenieria Civil','1e11c85a-3215-473e-9e32-5e7f79532bd2',NULL,NULL,NULL),(3,'2012-11-25 15:37:57','Ingenieria Quimica','fc99c656-6527-403a-acef-370fe2e09f42',NULL,NULL,NULL),(4,'2012-11-25 15:37:57','Ingenieria Computacion','d45b0cc7-2c71-4095-a73f-e4a5db1b603b',NULL,NULL,NULL),(5,'2012-11-25 15:37:57','Ing. Alimentos','97cb7cda-702d-4b80-8901-80c8f7942c74',NULL,NULL,NULL);

INSERT INTO `Materia` VALUES (1,'2012-11-25 15:37:58','Matematica','mat01',NULL);

INSERT INTO `CarreraMateria` VALUES (5,1);

INSERT INTO `Asignatura` VALUES (1,'2012-11-25 15:37:57','Calculo 1','calc01',NULL,NULL,NULL),(2,'2012-11-25 15:37:57','Fisica 1','soyPrevia',NULL,NULL,NULL), (3,'2012-11-25 15:37:57','Algebra','al001',NULL,NULL,NULL), (4,'2012-11-25 15:37:57','Asign 2','Asignatura dos',NULL,NULL,NULL);

INSERT INTO `AsigMaterias` VALUES (1,1),(1,2),(1,3),(1,4);

INSERT INTO `Previas` VALUES (1,2);

INSERT INTO `PeriodoInscripcion` VALUES (1,'2012-11-30 20:38:00','Periodo de Carrera',NULL,NULL,NULL,1,0),(2,'2012-11-30 20:38:00','Periodo de curso',NULL,NULL,NULL,1,1),(3,'2012-11-30 20:38:00','Periodo de curso',NULL,NULL,NULL,1,2);

INSERT INTO `Curso` VALUES (1,'2012-12-02 19:28:20','Calculo 1 vesp.','codigoCurso',NULL,'2012-12-02 19:28:20','2012-12-02 19:28:20','Los jueves de 9 a 10:30',NULL,'Par',1,1), (2,'2012-12-02 19:28:20','Prog. 3 1 vesp.','codigoCursoDos',NULL,'2012-12-02 19:28:20','2012-12-02 19:28:20','Los viernes de 9 a 10:30',NULL,'Impar',1,1);

INSERT INTO `Examen` VALUES (1,'2012-12-04 22:52:21','codigo','2012-12-04 22:52:21',NULL,1);

INSERT INTO `Inscripcion` VALUES (1,'2012-11-30 20:38:00',NULL,NULL,1,0,5,NULL,1,NULL,1),(2,'2012-11-30 20:38:00',NULL,NULL,1,1,NULL,1,1,NULL,2),(3,'2012-11-30 20:38:00',NULL,NULL,1,2,NULL,NULL,1,1,3);

INSERT INTO `Evaluacion` VALUES (1,'2012-12-04 22:10:26',NULL,NULL,0,8,2,1,1);
