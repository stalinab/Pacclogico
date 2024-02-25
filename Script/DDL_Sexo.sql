-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Creación de la tabla Sexo
*/
DROP TABLE If EXISTS Sexo;
--Catalogo
CREATE TABLE Sexo(
        IdSexo                  INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre                 TEXT  NOT NULL UNIQUE
        ,Observacion            VARCHAR(255)
        ,Estado                 CHAR NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);