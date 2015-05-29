--------------------------------------------------------
-- Archivo creado  - sábado-mayo-23-2015   
--------------------------------------------------------
  DROP TABLE "ASIGNATURA" cascade constraints;
  DROP TABLE "AULA" cascade constraints;
  DROP TABLE "DOCENTE" cascade constraints;
  DROP TABLE "FALTAS" cascade constraints;
  DROP TABLE "GRUPO" cascade constraints;
  DROP TABLE "HORA_CLASE" cascade constraints;
  DROP TABLE "HORA_GUARDIA" cascade constraints;
  DROP PROCEDURE "P_FORMATEAR_FIRMADO";
--------------------------------------------------------
--  DDL for Table ASIGNATURA
--------------------------------------------------------

  CREATE TABLE "ASIGNATURA" 
   (	"COD_ASIGNATURA" VARCHAR2(50 BYTE), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table AULA
--------------------------------------------------------

  CREATE TABLE "AULA" 
   (	"COD_AULA" VARCHAR2(50 BYTE), 
	"LUGAR" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table DOCENTE
--------------------------------------------------------

  CREATE TABLE "DOCENTE" 
   (	"COD_PROFE" VARCHAR2(50 BYTE), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"APELLIDOS" VARCHAR2(50 BYTE), 
	"TIPO" VARCHAR2(50 BYTE), 
	"USUARIO" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table FALTAS
--------------------------------------------------------

  CREATE TABLE "FALTAS" 
   (	"COD_PROFE_FALTA" VARCHAR2(50 BYTE), 
	"DIA_SEMANA_FALTA" VARCHAR2(10 BYTE), 
	"HORA_FALTA" VARCHAR2(10 BYTE), 
	"FECHA" DATE, 
	"COD_PROFE_CUBRE_GUARDIA" VARCHAR2(50 BYTE), 
	"DIA_SEMANA_GUARDIA" VARCHAR2(10 BYTE), 
	"HORA_GUARDIA" VARCHAR2(10 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table GRUPO
--------------------------------------------------------

  CREATE TABLE "GRUPO" 
   (	"COD_GRUPO" VARCHAR2(50 BYTE), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table HORA_CLASE
--------------------------------------------------------

  CREATE TABLE "HORA_CLASE" 
   (	"COD_PROFE_CLASE" VARCHAR2(50 BYTE), 
	"DIA_SEMANA" VARCHAR2(10 BYTE), 
	"HORA" VARCHAR2(10 BYTE), 
	"COD_AULA" VARCHAR2(50 BYTE), 
	"COD_ASIGNATURA" VARCHAR2(50 BYTE), 
	"COD_GRUPO" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table HORA_GUARDIA
--------------------------------------------------------

  CREATE TABLE "HORA_GUARDIA" 
   (	"COD_PROFE_GUARDIA" VARCHAR2(50 BYTE), 
	"DIA_SEMANA" VARCHAR2(10 BYTE), 
	"HORA" VARCHAR2(10 BYTE), 
	"FIRMADO" VARCHAR2(2 BYTE)
   ) ;
REM INSERTING into ASIGNATURA
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('PRG','Programacion');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('SISIN','Sistemas Informaticos');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('ENDES','Entornos De Desarrollo');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('FOL','Formación y Orientación Laboral');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('ING','Inglés');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('LMSGI','Lenguajes de Marcas y Sistemas de Gestión');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('BDD','Bases de Datos');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('LOG','Logica');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('MAT','Matematicas');
Insert into ASIGNATURA (COD_ASIGNATURA,NOMBRE) values ('TLL','Taller');
REM INSERTING into AULA
Insert into AULA (COD_AULA,LUGAR) values ('B-302','Primera planta. Edificio 2');
Insert into AULA (COD_AULA,LUGAR) values ('B-301','Primera planta. Edificio 2.');
REM INSERTING into DOCENTE
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe001','Maite','Perez','profesor','profe001','profe001');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe002','Raquel','Rivera','profesor','profe002','profe002');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe003','Jose','Rodriguez','profesor','profe003','profe003');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe004','Antonio','Castro','profesor','profe004','profe004');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe005','Raul','Marqueta','profesor','profe005','profe005');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe006','Rosa','Diaz','profesor','profe006','profe006');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe007','Carmen','Galan','profesor','profe007','profe007');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe008','Roberto','Sanchez','profesor','profe008','profe008');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe009','Ulises','Gonzalez','profesor','profe009','profe009');
Insert into DOCENTE (COD_PROFE,NOMBRE,APELLIDOS,TIPO,USUARIO,PASSWORD) values ('profe010','Javier','Klein','jefe estudios','profe010je','profe010je');
REM INSERTING into FALTAS
Insert into FALTAS (COD_PROFE_FALTA,DIA_SEMANA_FALTA,HORA_FALTA,FECHA,COD_PROFE_CUBRE_GUARDIA,DIA_SEMANA_GUARDIA,HORA_GUARDIA) values ('profe001','lunes','hora2',to_date('22/05/15','DD/MM/RR'),'profe002','lunes','hora2');
Insert into FALTAS (COD_PROFE_FALTA,DIA_SEMANA_FALTA,HORA_FALTA,FECHA,COD_PROFE_CUBRE_GUARDIA,DIA_SEMANA_GUARDIA,HORA_GUARDIA) values ('profe001','lunes','hora1',to_date('22/05/15','DD/MM/RR'),null,null,null);
REM INSERTING into GRUPO
Insert into GRUPO (COD_GRUPO,NOMBRE) values ('VS1DAW','1 de Daw. Vespertino');
Insert into GRUPO (COD_GRUPO,NOMBRE) values ('VS1DAM','1 de Desarrollo de Aplicaciones Web. Vespertino');
REM INSERTING into HORA_CLASE
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','lunes','hora1','B-301','PRG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','lunes','hora2','B-301','PRG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','lunes','hora3','B-301','SISIN','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','lunes','hora4','B-301','SISIN','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','jueves','hora5','B-301','PRG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','jueves','hora6','B-301','PRG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','martes','hora3','B-302','PRG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe001','martes','hora4','B-302','PRG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','martes','hora5','B-302','SISIN','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','martes','hora6','B-302','SISIN','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','jueves','hora1','B-302','SISIN','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe002','jueves','hora2','B-302','SISIN','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','lunes','hora5','B-301','ING','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','lunes','hora6','B-301','ING','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','miercoles','hora1','B-301','ING','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','miercoles','hora2','B-301','ING','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','jueves','hora3','B-302','ING','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe003','jueves','hora4','B-302','ING','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','lunes','hora1','B-302','TLL','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','lunes','hora2','B-302','TLL','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','miercoles','hora3','B-301','TLL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','miercoles','hora4','B-301','TLL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','jueves','hora5','B-301','TLL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe004','jueves','hora6','B-301','TLL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','lunes','hora3','B-302','MAT','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','lunes','hora4','B-302','MAT','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','miercoles','hora5','B-301','MAT','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','miercoles','hora6','B-301','MAT','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','viernes','hora1','B-301','MAT','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe005','viernes','hora2','B-301','MAT','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','lunes','hora5','B-302','LOG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','lunes','hora6','B-302','LOG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','miercoles','hora1','B-302','LOG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','miercoles','hora2','B-302','LOG','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','viernes','hora3','B-301','LOG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe006','viernes','hora4','B-301','LOG','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','martes','hora1','B-301','BDD','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','martes','hora2','B-301','BDD','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','miercoles','hora3','B-302','BDD','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','miercoles','hora4','B-302','BDD','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','viernes','hora5','B-301','BDD','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe007','viernes','hora6','B-301','BDD','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','martes','hora3','B-301','LMSGI','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','martes','hora4','B-301','LMSGI','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','miercoles','hora5','B-302','LMSGI','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','miercoles','hora6','B-302','LMSGI','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','viernes','hora1','B-302','LMSGI','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe008','viernes','hora2','B-302','LMSGI','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','martes','hora5','B-301','ENDES','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','martes','hora6','B-301','ENDES','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','jueves','hora1','B-301','ENDES','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','jueves','hora2','B-301','ENDES','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','viernes','hora3','B-302','ENDES','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe009','viernes','hora4','B-302','ENDES','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','martes','hora1','B-302','FOL','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','martes','hora2','B-302','FOL','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','jueves','hora3','B-301','FOL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','jueves','hora4','B-301','FOL','VS1DAW');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','viernes','hora5','B-302','FOL','VS1DAM');
Insert into HORA_CLASE (COD_PROFE_CLASE,DIA_SEMANA,HORA,COD_AULA,COD_ASIGNATURA,COD_GRUPO) values ('profe010','viernes','hora6','B-302','FOL','VS1DAM');
REM INSERTING into HORA_GUARDIA
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','lunes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','lunes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','lunes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','lunes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','lunes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','lunes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','lunes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','lunes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','lunes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','lunes','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','lunes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','lunes','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','martes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','martes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','martes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','martes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','martes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','martes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','martes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','martes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','martes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','martes','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','martes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','martes','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','miercoles','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','miercoles','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','miercoles','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','miercoles','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','miercoles','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','miercoles','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','miercoles','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','miercoles','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','miercoles','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','miercoles','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','miercoles','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','miercoles','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','jueves','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','jueves','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','jueves','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe007','jueves','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','jueves','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','jueves','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','jueves','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe001','jueves','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','jueves','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe002','jueves','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','jueves','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','jueves','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','viernes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe006','viernes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','viernes','hora1','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe003','viernes','hora2','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','viernes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe008','viernes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','viernes','hora3','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe004','viernes','hora4','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','viernes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe009','viernes','hora6','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','viernes','hora5','NO');
Insert into HORA_GUARDIA (COD_PROFE_GUARDIA,DIA_SEMANA,HORA,FIRMADO) values ('profe005','viernes','hora6','NO');
--------------------------------------------------------
--  DDL for Index PK_ASIGNATURA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ASIGNATURA" ON "ASIGNATURA" ("COD_ASIGNATURA") 
  ;
--------------------------------------------------------
--  DDL for Index PK_AULA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_AULA" ON "AULA" ("COD_AULA") 
  ;
--------------------------------------------------------
--  DDL for Index PK_DOCENTES
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_DOCENTES" ON "DOCENTE" ("COD_PROFE") 
  ;
--------------------------------------------------------
--  DDL for Index PK_FALTAS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_FALTAS" ON "FALTAS" ("COD_PROFE_FALTA", "DIA_SEMANA_FALTA", "HORA_FALTA", "FECHA") 
  ;
--------------------------------------------------------
--  DDL for Index PK_GRUPO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_GRUPO" ON "GRUPO" ("COD_GRUPO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_HORA_CLASE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_HORA_CLASE" ON "HORA_CLASE" ("COD_PROFE_CLASE", "DIA_SEMANA", "HORA") 
  ;
--------------------------------------------------------
--  DDL for Index PK_HORA_GUARDIA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_HORA_GUARDIA" ON "HORA_GUARDIA" ("COD_PROFE_GUARDIA", "DIA_SEMANA", "HORA") 
  ;
--------------------------------------------------------
--  Constraints for Table ASIGNATURA
--------------------------------------------------------

  ALTER TABLE "ASIGNATURA" ADD CONSTRAINT "PK_ASIGNATURA" PRIMARY KEY ("COD_ASIGNATURA") ENABLE;
 
  ALTER TABLE "ASIGNATURA" MODIFY ("COD_ASIGNATURA" NOT NULL ENABLE);
 
  ALTER TABLE "ASIGNATURA" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AULA
--------------------------------------------------------

  ALTER TABLE "AULA" ADD CONSTRAINT "PK_AULA" PRIMARY KEY ("COD_AULA") ENABLE;
 
  ALTER TABLE "AULA" MODIFY ("COD_AULA" NOT NULL ENABLE);
 
  ALTER TABLE "AULA" MODIFY ("LUGAR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DOCENTE
--------------------------------------------------------

  ALTER TABLE "DOCENTE" ADD CONSTRAINT "CK_TIPO_DOCENTES" CHECK (TIPO LIKE 'profesor' OR TIPO LIKE 'jefe estudios') ENABLE;
 
  ALTER TABLE "DOCENTE" ADD CONSTRAINT "PK_DOCENTES" PRIMARY KEY ("COD_PROFE") ENABLE;
 
  ALTER TABLE "DOCENTE" MODIFY ("COD_PROFE" NOT NULL ENABLE);
 
  ALTER TABLE "DOCENTE" MODIFY ("NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "DOCENTE" MODIFY ("APELLIDOS" NOT NULL ENABLE);
 
  ALTER TABLE "DOCENTE" MODIFY ("TIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FALTAS
--------------------------------------------------------

  ALTER TABLE "FALTAS" ADD CONSTRAINT "PK_FALTAS" PRIMARY KEY ("COD_PROFE_FALTA", "DIA_SEMANA_FALTA", "HORA_FALTA", "FECHA") ENABLE;
 
  ALTER TABLE "FALTAS" MODIFY ("COD_PROFE_FALTA" NOT NULL ENABLE);
 
  ALTER TABLE "FALTAS" MODIFY ("DIA_SEMANA_FALTA" NOT NULL ENABLE);
 
  ALTER TABLE "FALTAS" MODIFY ("HORA_FALTA" NOT NULL ENABLE);
 
  ALTER TABLE "FALTAS" MODIFY ("FECHA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPO
--------------------------------------------------------

  ALTER TABLE "GRUPO" ADD CONSTRAINT "PK_GRUPO" PRIMARY KEY ("COD_GRUPO") ENABLE;
 
  ALTER TABLE "GRUPO" MODIFY ("COD_GRUPO" NOT NULL ENABLE);
 
  ALTER TABLE "GRUPO" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HORA_CLASE
--------------------------------------------------------

  ALTER TABLE "HORA_CLASE" ADD CONSTRAINT "PK_HORA_CLASE" PRIMARY KEY ("COD_PROFE_CLASE", "DIA_SEMANA", "HORA") ENABLE;
 
  ALTER TABLE "HORA_CLASE" MODIFY ("COD_PROFE_CLASE" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_CLASE" MODIFY ("DIA_SEMANA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_CLASE" MODIFY ("HORA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_CLASE" MODIFY ("COD_AULA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_CLASE" MODIFY ("COD_ASIGNATURA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_CLASE" MODIFY ("COD_GRUPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HORA_GUARDIA
--------------------------------------------------------

  ALTER TABLE "HORA_GUARDIA" ADD CONSTRAINT "CK_FIRMADO_OPCIONES" CHECK ((firmado like 'SI') OR (firmado like'NO')) ENABLE;
 
  ALTER TABLE "HORA_GUARDIA" ADD CONSTRAINT "PK_HORA_GUARDIA" PRIMARY KEY ("COD_PROFE_GUARDIA", "DIA_SEMANA", "HORA") ENABLE;
 
  ALTER TABLE "HORA_GUARDIA" MODIFY ("COD_PROFE_GUARDIA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_GUARDIA" MODIFY ("DIA_SEMANA" NOT NULL ENABLE);
 
  ALTER TABLE "HORA_GUARDIA" MODIFY ("HORA" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table FALTAS
--------------------------------------------------------

  ALTER TABLE "FALTAS" ADD CONSTRAINT "FK_FALTA_HORA_CLASE" FOREIGN KEY ("COD_PROFE_FALTA", "DIA_SEMANA_FALTA", "HORA_FALTA")
	  REFERENCES "HORA_CLASE" ("COD_PROFE_CLASE", "DIA_SEMANA", "HORA") ENABLE;
 
  ALTER TABLE "FALTAS" ADD CONSTRAINT "FK_FALTA_HORA_GUARDIA" FOREIGN KEY ("COD_PROFE_CUBRE_GUARDIA", "DIA_SEMANA_GUARDIA", "HORA_GUARDIA")
	  REFERENCES "HORA_GUARDIA" ("COD_PROFE_GUARDIA", "DIA_SEMANA", "HORA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HORA_CLASE
--------------------------------------------------------

  ALTER TABLE "HORA_CLASE" ADD CONSTRAINT "FK_HORA_CLASE_ASIGNATURA" FOREIGN KEY ("COD_ASIGNATURA")
	  REFERENCES "ASIGNATURA" ("COD_ASIGNATURA") ENABLE;
 
  ALTER TABLE "HORA_CLASE" ADD CONSTRAINT "FK_HORA_CLASE_AULA" FOREIGN KEY ("COD_AULA")
	  REFERENCES "AULA" ("COD_AULA") ENABLE;
 
  ALTER TABLE "HORA_CLASE" ADD CONSTRAINT "FK_HORA_CLASE_DOCENTES" FOREIGN KEY ("COD_PROFE_CLASE")
	  REFERENCES "DOCENTE" ("COD_PROFE") ENABLE;
 
  ALTER TABLE "HORA_CLASE" ADD CONSTRAINT "FK_HORA_CLASE_GRUPO" FOREIGN KEY ("COD_GRUPO")
	  REFERENCES "GRUPO" ("COD_GRUPO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HORA_GUARDIA
--------------------------------------------------------

  ALTER TABLE "HORA_GUARDIA" ADD CONSTRAINT "FK_HORA_GUARDIA_DOCENTES" FOREIGN KEY ("COD_PROFE_GUARDIA")
	  REFERENCES "DOCENTE" ("COD_PROFE") ENABLE;
--------------------------------------------------------
--  DDL for Trigger FORMATEAR_GUARDIAS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "FORMATEAR_GUARDIAS" 
BEFORE UPDATE ON HORA_GUARDIA
FOR EACH ROW
DECLARE
  fecha_para_formatear DATE := SYSDATE-1;
  borrar_firmado hora_guardia.firmado%type;
BEGIN
  IF(TO_CHAR(fecha_para_formatear,'D')='4')THEN
  borrar_firmado:=null;
  END IF;
END;
/
ALTER TRIGGER "FORMATEAR_GUARDIAS" ENABLE;
--------------------------------------------------------
--  DDL for Procedure P_FORMATEAR_FIRMADO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "P_FORMATEAR_FIRMADO" IS
BEGIN
 UPDATE HORA_GUARDIA 
    SET FIRMADO ='NO';
COMMIT;
END;

/

