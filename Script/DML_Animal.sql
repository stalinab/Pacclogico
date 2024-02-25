-- database: ../database/Pacclogico.sqlite
/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
Script: Ingreso de datos Animal
*/
INSERT INTO Animal 
    (IdSexo, IdHabitat, IdClasificacion, Nombre, Informacion)
VALUES 
    (1,2,3,"Leon","google.com");
SELECT   An.IdAnimal IdAnimal
    ,Ha.Nombre Habitat
    ,Cla.Nombre Clasificacion
    ,An.Nombre NombreAnimal
FROM Animal      An
JOIN Habitat     Ha ON An.IdHabitat = Ha.IdHabitat
JOIN Clasificacion     Cla ON An.IdClasificacion = Cla.IdClasificacion
WHERE   An.Estado = "A"
AND     Ha.Estado = "A"
AND     Cla.Estado = "A";
SELECT   An.IdAnimal IdAnimal,Ha.Nombre Habitat,Cla.Nombre Clasificacion,An.Nombre NombreAnimal
FROM Animal      An
JOIN Habitat     Ha ON An.IdHabitat = Ha.IdHabitat
JOIN Clasificacion     Cla ON An.IdClasificacion = Cla.IdClasificacion
WHERE   An.Estado = 'A'
AND     Ha.Estado = 'A'
AND     Cla.Estado = 'A';