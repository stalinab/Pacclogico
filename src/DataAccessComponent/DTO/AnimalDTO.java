package DataAccessComponent.DTO;

public class AnimalDTO {
    private int IdAnimal          ;
    private String Sexo            ;
    private String Habitat         ;
    private String Clasificacion   ;
    private String Nombre         ;
    private String Qr            ;
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
    
}
