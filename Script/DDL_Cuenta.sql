-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Creación de la tabla Cuenta
*/
DROP TABLE If EXISTS Cuenta;
CREATE TABLE Cuenta(
        IdCuenta                INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersonal             INTEGER  REFERENCES Personal (IdPersonal)
        ,Correo                 VARCHAR(50)  NOT NULL UNIQUE
        ,Password               VARCHAR(16)  NOT NULL
        ,Observacion            TEXT
        ,Estado                 CHAR NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);