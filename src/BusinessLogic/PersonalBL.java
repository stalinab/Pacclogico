/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: Business Logic de Personal
*/

package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonalDAO;
import DataAccessComponent.DTO.PersonalDTO;

public class PersonalBL {
    private PersonalDTO personaRol;
    private PersonalDAO personalDAO = new PersonalDAO();

    public PersonalBL() {}

    public boolean add(PersonalDTO personaRolDTO) throws Exception {
        return personalDAO.create(personaRolDTO);
    }

    public List<PersonalDTO> getAll() throws Exception {
        return personalDAO.readAll();
    }

    public PersonalDTO getBy(int idPersonaRol) throws Exception {
        personaRol = personalDAO.read(idPersonaRol);
        return personaRol;
    }

    public boolean update(PersonalDTO personaRolDTO) throws Exception {
        return personalDAO.update(personaRolDTO);
    }

    public boolean delete(int idPersonaRol) throws Exception {
        return personalDAO.delete(idPersonaRol);
    }

    public int getMaxId() throws Exception {
        return personalDAO.getMaxId();
    }
}