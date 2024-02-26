package BusinessLogic;

import java.util.List;

import DataAccessComponent.HabitatDAO;
import DataAccessComponent.DTO.HabitatDTO;

public class HabitatBL {
    private HabitatDTO h;
    private HabitatDAO habitatDao = new HabitatDAO();

    public HabitatBL(){}

    public List<HabitatDTO> getAll() throws Exception{
        return habitatDao.readAll();
    }

    public HabitatDTO getBy(int IdHabitat) throws Exception{
        h = habitatDao.read(IdHabitat);
        return h;
    }

    public boolean add(String Nombre) throws Exception{
        h = new HabitatDTO();
        h.setNombre(Nombre);
        return habitatDao.create(h);
    }

    public boolean update(int IdHabitat, String Nombre) throws Exception{
        h = new HabitatDTO();
        h.setIdHabitat(IdHabitat);
        h.setNombre(Nombre);
        return habitatDao.update(h);
    }

    public boolean delete(int IdHabitat) throws Exception{
        return habitatDao.delete(IdHabitat);
    }
}
