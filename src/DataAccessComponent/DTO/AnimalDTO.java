package DataAccessComponent.DTO;

public class AnimalDTO {
    private int IdAnimal          ;
    private int IdSexo            ;
    private int IdHabitat         ;
    private int IdClasificacion   ;
    private String Sexo           ;
    private String Habitat        ;
    private String Clasificacion  ;
    private String Nombre         ;
    private String Qr             ;
    private String Observacion    ;
    private String Estado         ;
    private String FechaCrea      ;
    private String FechaModifica  ;
    public AnimalDTO(int idAnimal, int idSexo, int idHabitat, int idClasificacion, String nombre, String qr,
            String observacion, String estado, String fechaCrea, String fechaModifica) {
        IdAnimal = idAnimal;
        IdSexo = idSexo;
        IdHabitat = idHabitat;
        IdClasificacion = idClasificacion;
        Nombre = nombre;
        Qr = qr;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public AnimalDTO(int idAnimal, String sexo, String habitat, String clasificacion, String nombre, String qr) {
        IdAnimal = idAnimal;
        Sexo = sexo;
        Habitat = habitat;
        Clasificacion = clasificacion;
        Nombre = nombre;
        Qr = qr;
    }
    public AnimalDTO() {
        //TODO Auto-generated constructor stub
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
    public int getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(int idSexo) {
        IdSexo = idSexo;
    }
    public int getIdHabitat() {
        return IdHabitat;
    }
    public void setIdHabitat(int idHabitat) {
        IdHabitat = idHabitat;
    }
    public int getIdClasificacion() {
        return IdClasificacion;
    }
    public void setIdClasificacion(int idClasificacion) {
        IdClasificacion = idClasificacion;
    }
    
}
