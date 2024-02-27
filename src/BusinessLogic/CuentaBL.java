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
        return cuentaDao.read(IdCuenta);
    }

    public boolean add(CuentaDTO cuentaDTO) throws Exception{
        return cuentaDao.create(cuentaDTO);
    }

    public boolean update(CuentaDTO cuentaDTO) throws Exception{
        return cuentaDao.update(cuentaDTO);
    }

    public boolean delete(int IdCuenta) throws Exception{
        return cuentaDao.delete(IdCuenta);
    }

    public int getMaxId() throws Exception {
        return cuentaDao.getMaxId();
    }
}
