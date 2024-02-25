-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Creación de la tabla Personal
*/
DROP TABLE If EXISTS Personal;
--Catalogo
CREATE TABLE Personal(
        IdPersonal              INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersonal_Padre        INTEGER  REFERENCES Personal (IdPersonal)
        ,Nombre                 TEXT  NOT NULL UNIQUE
        ,Estado                 VARCHAR(1) NOT NULL DEFAULT 'A'
        ,Observacion            TEXT
        ,FechaCrea              DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
        ,FechaModifica          DATE
);