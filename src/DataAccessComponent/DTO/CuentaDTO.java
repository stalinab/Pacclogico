package DataAccessComponent.DTO;

public class CuentaDTO {
    private int IdCuenta ;
    private int IdPersonal;
    private String Correo       ;
    private String Password     ;
    private String Observacion  ;
    private String Estado       ;
    private String FechaCrea    ;
    private String FechaModifica;
    public CuentaDTO() {}
    public CuentaDTO(int idCuenta
                    , int idPersonal
                    , String correo
                    , String password
                    , String observacion
                    , String estado
                    , String fechaCrea,
                      String fechaModifica) {
        this.IdCuenta = idCuenta;
        this.IdPersonal = idPersonal;
        this.Correo = correo;
        this.Password = password;
        this.Observacion = observacion;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
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
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
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
