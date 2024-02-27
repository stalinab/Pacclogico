package BusinessLogic;

import java.util.List;

import DataAccessComponent.CuentaDAO;
import DataAccessComponent.DTO.CuentaDTO;

public class CuentaBL {
    private CuentaDTO c;
    private CuentaDAO cuentaDao = new CuentaDAO();

    public CuentaBL(){}

    public List<CuentaDTO> getAll() throws Exception{
        return cuentaDao.readAll();
    }

    public CuentaDTO getBy(int IdCuenta) throws Exception{
        c = cuentaDao.read(IdCuenta);
        return c;
    }

    public boolean add(int IdPersonal, String Correo) throws Exception{
        c = new CuentaDTO();
        c.setIdPersonal(IdPersonal);
        c.setCorreo(Correo);
        return cuentaDao.create(c);
    }

    public boolean update(int IdCuenta, int IdPersonal, String Correo) throws Exception{
        c = new CuentaDTO();
        c.setIdCuenta(IdCuenta);
        c.setIdPersonal(IdPersonal);
        c.setCorreo(Correo);
        return cuentaDao.update(c);
    }

    public boolean delete(int IdCuenta) throws Exception{
        return cuentaDao.delete(IdCuenta);
    }
}
