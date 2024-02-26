package DataAccessComponent.DTO;

public class AnimalDTO {
    private Integer IdAnimal          ;
    private String Sexo           ;
    private String Habitat        ;
    private String Clasificacion  ;
    private String Nombre         ;
    private String Qr             ;
    private String Observacion    ;
    private String Estado         ;
    private String FechaCrea      ;
    private String FechaModifica  ;
    public AnimalDTO() {}
    
    public AnimalDTO(Integer idAnimal, String sexo, String habitat, String clasificacion, String nombre, String qr, String estado) {
              this.IdAnimal = idAnimal;
              this.Sexo = sexo;
              this.Habitat = habitat;
              this.Clasificacion = clasificacion;
              this.Nombre= nombre;
              this.Qr= qr;
              this.Estado = estado;

    }
    public int getIdAnimal() {
        return IdAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        IdAnimal = idAnimal;
    }
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        Sexo = sexo;
    }
    public String getHabitat() {
        return Habitat;
    }
    public void setHabitat(String habitat) {
        Habitat = habitat;
    }
    public String getClasificacion() {
        return Clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        Clasificacion = clasificacion;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getQr() {
        return Qr;
    }
    public void setQr(String qr) {
        Qr = qr;
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
