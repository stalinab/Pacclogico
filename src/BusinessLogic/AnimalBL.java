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
        a = animalDao.read(IdAnimal);
        return a;
    }

    public boolean add(AnimalDTO animalDTO) throws Exception{
        return animalDao.create(animalDTO);
    }

    public boolean update(AnimalDTO animalDTO) throws Exception{
        return animalDao.update(animalDTO);
    }

    public boolean delete(int IdAnimal) throws Exception{
        return animalDao.delete(IdAnimal);
    }

    public int getMaxId() throws Exception {
        return animalDao.getMaxId();
    }
}
