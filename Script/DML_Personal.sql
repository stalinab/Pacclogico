-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Ingreso de datos Personal
*/
INSERT INTO Personal 
    (IdPersonal_Padre, Nombre, Observacion)
VALUES 
    (NULL, "ADMINISTRADOR APP", "ADMINISTRADOR APP")
    ,(1, "TRABAJADOR", "TRABAJADOR") 
    ,(2, "USUARIO VIP", "USUARIO VIP");
