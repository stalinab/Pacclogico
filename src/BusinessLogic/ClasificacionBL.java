package BusinessLogic;

import java.util.List;

import DataAccessComponent.ClasificacionDAO;
import DataAccessComponent.DTO.ClasificacionDTO;

public class ClasificacionBL {
    private ClasificacionDTO c;
    private ClasificacionDAO clasificacionDao = new ClasificacionDAO();

    public ClasificacionBL(){}

    public List<ClasificacionDTO> getAll() throws Exception{
        return clasificacionDao.readAll();
    }

    public ClasificacionDTO getBy(int IdClasificacion) throws Exception{
        c = clasificacionDao.read(IdClasificacion);
        return c;
    }

    public boolean add(String Nombre) throws Exception{
        c = new ClasificacionDTO();
        c.setNombre(Nombre);
        return clasificacionDao.create(c);
    }

    public boolean update(int IdClasificacion, String Nombre) throws Exception{
        c = new ClasificacionDTO();
        c.setIdClasificacion(IdClasificacion);
        c.setNombre(Nombre);
        return clasificacionDao.update(c);
    }

    public boolean delete(int IdClasificacion) throws Exception{
        return clasificacionDao.delete(IdClasificacion);
    }
}
