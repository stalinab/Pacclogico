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
    (IdSexo, IdHabitat, IdClasificacion, Nombre, Qr)
VALUES 
    (1,1,1,"Leon","https://drive.google.com/uc?export=download&id=12G8CJLcXHteBO_cggIa-aJscFD5z__OO")
    ,(1,2,4,"Sapo","https://drive.google.com/uc?export=download&id=1B763oHmGxgx4xqkxxVsW7cjXtmG4UCPt")
    ,(2,1,1,"Tigre","https://drive.google.com/uc?export=download&id=1e4eCAxNZAECKvPHmmFGKd2kgRe2gUAeM")
    ,(1,2,1,"Gorila","https://drive.google.com/uc?export=download&id=1ITUrV5kXKLrAfEOatFFv0z8TKwrUlPhG")
    ,(1,3,1,"Hipopotamo","https://drive.google.com/uc?export=download&id=1UEPHCuQP_lOBmBDii0jn9tW5hcJkSXwz")
    ,(1,1,2,"Serpiente","https://drive.google.com/uc?export=download&id=1cErDIrPwMeqEhF1NaGuBoq9BZ_unWyQJ")
    ,(1,2,3,"Condor","https://drive.google.com/uc?export=download&id=1sE591DIao39e3QKFKTOFLrn1sHjq1kL7")
    ,(1,3,3,"PatoAmericano","https://drive.google.com/uc?export=download&id=1ZypyResV6P4V-Vjtxg6OMC8Pru2NeVQK")
    ,(1,1,1,"Capibara","https://drive.google.com/uc?export=download&id=1LhFSnXIZO7s-vNR6eC3LWPMoLsxobC0S")
    ,(2,3,4,"Tortuga","https://drive.google.com/uc?export=download&id=1x1hg2c0HOVQuXX2JyNyzWIJDGj0jxQrR");
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
SELECT   An.IdAnimal IdAnimal,Ha.Nombre Habitat,Cla.Nombre Clasificacion,An.Nombre NombreAnimal, An.Qr As Qr
FROM Animal      An
JOIN Habitat     Ha ON An.IdHabitat = Ha.IdHabitat
JOIN Clasificacion     Cla ON An.IdClasificacion = Cla.IdClasificacion
WHERE   An.Estado = 'A'
AND     Ha.Estado = 'A'
AND     Cla.Estado = 'A';