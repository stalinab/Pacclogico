package DataAccessComponent.DTO;

public class CuentaDTO {
    private int IdCuenta ;
    private int IdPersonal;
    private String Nombre       ;
    private String Observacion  ;
    private String Estado       ;
    private String FechaCrea    ;
    private String FechaModifica;
    public CuentaDTO(int idCuenta
                    , int idPersonal
                    , String nombre
                    , String observacion
                    , String estado
                    , String fechaCrea,
                      String fechaModifica) {
        IdCuenta = idCuenta;
        IdPersonal = idPersonal;
        Nombre = nombre;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public int getIdCuenta() {
        return IdCuenta;
    }
    public void setIdCuenta(int idCuenta) {
        IdCuenta = idCuenta;
    }
    public int getIdPersonal() {
        return IdPersonal;
    }
    public void setIdPersonal(int idPersonal) {
        IdPersonal = idPersonal;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getObservacion() {
        return Observacion;
    }
    public void setObservacion(String observacion) {
        Observacion = observacion;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
}
