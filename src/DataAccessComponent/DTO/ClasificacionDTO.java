package DataAccessComponent.DTO;

public class ClasificacionDTO {
    private int IdClasificacion ;
    private String Nombre       ;
    private String Observacion  ;
    private String Estado       ;
    private String FechaCrea    ;
    private String FechaModifica;
    public ClasificacionDTO(int idClasificacion
                            , String nombre
                            , String observacion
                            , String estado
                            , String fechaCrea,
                              String fechaModifica) {
        IdClasificacion = idClasificacion;
        Nombre = nombre;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public ClasificacionDTO() {
        //TODO Auto-generated constructor stub
    }
    public int getIdClasificacion() {
        return IdClasificacion;
    }
    public void setIdClasificacion(int idClasificacion) {
        IdClasificacion = idClasificacion;
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
