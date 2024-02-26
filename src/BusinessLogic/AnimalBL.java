package BusinessLogic;

import java.util.List;

import DataAccessComponent.AnimalDAO;
import DataAccessComponent.DTO.AnimalDTO;

public class AnimalBL {
    private AnimalDTO a;
    private AnimalDAO animalDao = new AnimalDAO();

    public AnimalBL(){}

    public List<AnimalDTO> getAll() throws Exception{
        return animalDao.readAll();
    }

    public AnimalDTO getBy(int IdAnimal) throws Exception{
        a = animalDao.readBy(IdAnimal);
        return a;
    }

    // public boolean add(String Sexo,String Habitat, String Clasificacion, String Nombre, String Qr) throws Exception{
    //     a = new AnimalDTO();
    //     a.setSexo(Sexo);
    //     a.setHabitat(Habitat);
    //     a.setClasificacion(Clasificacion);
    //     a.setNombre(Nombre);
    //     a.setQr(Qr);
    //     return animalDao.create(a);
    // }

    // public boolean update(int IdAnimal, String Sexo,String Habitat, String Clasificacion, String Nombre, String Qr) throws Exception{
    //     a = new AnimalDTO();
    //     a.setIdAnimal(IdAnimal);
    //     a.setSexo(Sexo);
    //     a.setHabitat(Habitat);
    //     a.setClasificacion(Clasificacion);
    //     return animalDao.update(a);
    // }

    // public boolean delete(int IdAnimal) throws Exception{
    //     return animalDao.delete(IdAnimal);
    // }
}
