-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Creación de la tabla Animal
*/
DROP TABLE If EXISTS Animal;
CREATE TABLE Animal(
        IdAnimal                INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdSexo                 INTEGER  REFERENCES Sexo (IdSexo)
        ,IdHabitat              INTEGER  REFERENCES Habitat (IdHabitat)
        ,IdClasificacion        INTEGER  REFERENCES Clasificacion (IdClasificacion)
        ,Nombre                 VARCHAR(50)  NOT NULL UNIQUE
        ,Qr                    VARCHAR(256)  NOT NULL UNIQUE
        ,Observacion            TEXT
        ,Estado                 CHAR NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);