CREATE TABLE ASIGNATURA (CODIGO VARCHAR(255) NOT NULL, CREDITOS SMALLINT, INTENSIDAD SMALLINT, NOMBRE VARCHAR(80) NOT NULL, PRIMARY KEY (CODIGO))
CREATE TABLE CUPO (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, CANTIDAD INTEGER, DISPONIBLES INTEGER, PROGRAMA_CODIGO VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CURSO (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ESTADO INTEGER, GRUPO SMALLINT, TOTALCUPOS INTEGER, ASIGNATURA_CODIGO VARCHAR(255), DOCENTE_IDENTIFICACION BIGINT, PRIMARY KEY (ID))
CREATE TABLE DEUDA (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, PERIODO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE DOCENTE (IDENTIFICACION BIGINT NOT NULL, APELLIDO VARCHAR(50) NOT NULL, NOMBRE VARCHAR(50) NOT NULL, PROFESION VARCHAR(80) NOT NULL, PRIMARY KEY (IDENTIFICACION))
CREATE TABLE ESTUDIANTE (IDENTIFICACION BIGINT NOT NULL, APELLIDO VARCHAR(50) NOT NULL, CODIGO VARCHAR(15) NOT NULL, NOMBRE VARCHAR(50) NOT NULL, TABULADOACTUAL_ID BIGINT, PRIMARY KEY (IDENTIFICACION))
CREATE TABLE HORARIO (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, DIA INTEGER, HORAFINALIZACION DATE, HORAINCIO DATE, PRIMARY KEY (ID))
CREATE TABLE MATRICULA (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, CANCELADA DATE, MATRICULADA DATE, CURSO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE PERIODO (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ACTUAL SMALLINT DEFAULT 0 NOT NULL, FIN DATE, INICIA DATE, YEAR1 INTEGER NOT NULL, PRIMARY KEY (ID))
CREATE TABLE PROGRAMA (CODIGO VARCHAR(255) NOT NULL, JORNADA INTEGER, NOMBRE VARCHAR(80) NOT NULL, PRIMARY KEY (CODIGO))
CREATE TABLE SEMESTRE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, NUMERO SMALLINT, PRIMARY KEY (ID))
CREATE TABLE TABULADO (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, PERIODO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE CURSO_CUPO (Curso_ID BIGINT NOT NULL, cupos_ID BIGINT NOT NULL, PRIMARY KEY (Curso_ID, cupos_ID))
CREATE TABLE CURSO_HORARIO (Curso_ID BIGINT NOT NULL, horarios_ID BIGINT NOT NULL, PRIMARY KEY (Curso_ID, horarios_ID))
CREATE TABLE ESTUDIANTE_DEUDA (Estudiante_IDENTIFICACION BIGINT NOT NULL, deudas_ID BIGINT NOT NULL, PRIMARY KEY (Estudiante_IDENTIFICACION, deudas_ID))
CREATE TABLE ESTUDIANTE_TABULADO (Estudiante_IDENTIFICACION BIGINT NOT NULL, tabulados_ID BIGINT NOT NULL, PRIMARY KEY (Estudiante_IDENTIFICACION, tabulados_ID))
CREATE TABLE PERIODO_CURSO (Periodo_ID BIGINT NOT NULL, cursos_ID BIGINT NOT NULL, PRIMARY KEY (Periodo_ID, cursos_ID))
CREATE TABLE PROGRAMA_SEMESTRE (Programa_CODIGO VARCHAR(255) NOT NULL, semestres_ID BIGINT NOT NULL, PRIMARY KEY (Programa_CODIGO, semestres_ID))
CREATE TABLE SEMESTRE_ASIGNATURA (Semestre_ID BIGINT NOT NULL, asignaturas_CODIGO VARCHAR(255) NOT NULL, PRIMARY KEY (Semestre_ID, asignaturas_CODIGO))
CREATE TABLE TABULADO_MATRICULA (Tabulado_ID BIGINT NOT NULL, matriculas_ID BIGINT NOT NULL, PRIMARY KEY (Tabulado_ID, matriculas_ID))
ALTER TABLE CUPO ADD CONSTRAINT CUPOPROGRAMACODIGO FOREIGN KEY (PROGRAMA_CODIGO) REFERENCES PROGRAMA (CODIGO)
ALTER TABLE CURSO ADD CONSTRAINT CRSOSGNATURACODIGO FOREIGN KEY (ASIGNATURA_CODIGO) REFERENCES ASIGNATURA (CODIGO)
ALTER TABLE CURSO ADD CONSTRAINT CRSDCNTDNTFICACION FOREIGN KEY (DOCENTE_IDENTIFICACION) REFERENCES DOCENTE (IDENTIFICACION)
ALTER TABLE DEUDA ADD CONSTRAINT DEUDA_PERIODO_ID FOREIGN KEY (PERIODO_ID) REFERENCES PERIODO (ID)
ALTER TABLE ESTUDIANTE ADD CONSTRAINT STDNTETBLDACTUALID FOREIGN KEY (TABULADOACTUAL_ID) REFERENCES TABULADO (ID)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_CURSO_ID FOREIGN KEY (CURSO_ID) REFERENCES CURSO (ID)
ALTER TABLE TABULADO ADD CONSTRAINT TABULADOPERIODO_ID FOREIGN KEY (PERIODO_ID) REFERENCES PERIODO (ID)
ALTER TABLE CURSO_CUPO ADD CONSTRAINT CURSO_CUPOcupos_ID FOREIGN KEY (cupos_ID) REFERENCES CUPO (ID)
ALTER TABLE CURSO_CUPO ADD CONSTRAINT CURSO_CUPOCurso_ID FOREIGN KEY (Curso_ID) REFERENCES CURSO (ID)
ALTER TABLE CURSO_HORARIO ADD CONSTRAINT CRSOHORARIOCursoID FOREIGN KEY (Curso_ID) REFERENCES CURSO (ID)
ALTER TABLE CURSO_HORARIO ADD CONSTRAINT CRSHORARIOhrriosID FOREIGN KEY (horarios_ID) REFERENCES HORARIO (ID)
ALTER TABLE ESTUDIANTE_DEUDA ADD CONSTRAINT STDNTDstdntDNTFCCN FOREIGN KEY (Estudiante_IDENTIFICACION) REFERENCES ESTUDIANTE (IDENTIFICACION)
ALTER TABLE ESTUDIANTE_DEUDA ADD CONSTRAINT STDIANTEDEUDAddsID FOREIGN KEY (deudas_ID) REFERENCES DEUDA (ID)
ALTER TABLE ESTUDIANTE_TABULADO ADD CONSTRAINT STDNTTstdntDNTFCCN FOREIGN KEY (Estudiante_IDENTIFICACION) REFERENCES ESTUDIANTE (IDENTIFICACION)
ALTER TABLE ESTUDIANTE_TABULADO ADD CONSTRAINT STDNTTBULADOtbldsD FOREIGN KEY (tabulados_ID) REFERENCES TABULADO (ID)
ALTER TABLE PERIODO_CURSO ADD CONSTRAINT PRIODOCURSOcrsosID FOREIGN KEY (cursos_ID) REFERENCES CURSO (ID)
ALTER TABLE PERIODO_CURSO ADD CONSTRAINT PRODOCURSOPriodoID FOREIGN KEY (Periodo_ID) REFERENCES PERIODO (ID)
ALTER TABLE PROGRAMA_SEMESTRE ADD CONSTRAINT PRGRMSMSTREsmstrsD FOREIGN KEY (semestres_ID) REFERENCES SEMESTRE (ID)
ALTER TABLE PROGRAMA_SEMESTRE ADD CONSTRAINT PRGRMSMSTRPrgrmCDG FOREIGN KEY (Programa_CODIGO) REFERENCES PROGRAMA (CODIGO)
ALTER TABLE SEMESTRE_ASIGNATURA ADD CONSTRAINT SMSTRSGNTURASmstrD FOREIGN KEY (Semestre_ID) REFERENCES SEMESTRE (ID)
ALTER TABLE SEMESTRE_ASIGNATURA ADD CONSTRAINT SMSTRSGNTsgntrsCDG FOREIGN KEY (asignaturas_CODIGO) REFERENCES ASIGNATURA (CODIGO)
ALTER TABLE TABULADO_MATRICULA ADD CONSTRAINT TBLDMATRICULATbldD FOREIGN KEY (Tabulado_ID) REFERENCES TABULADO (ID)
ALTER TABLE TABULADO_MATRICULA ADD CONSTRAINT TBLDMTRCULAmtrclsD FOREIGN KEY (matriculas_ID) REFERENCES MATRICULA (ID)
