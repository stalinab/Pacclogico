/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 20 - 02 - 2024
Script: DTO de Personal
*/
package DataAccessComponent.DTO;

public class PersonalDTO {
    
    private Integer IdPersonal;
    private Integer IdPersonal_Padre;
    private String  Nombre;
    
    private String  Estado;
    private String  Observacion;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public PersonalDTO() {}
    
    public PersonalDTO( Integer IdPersonal,
    Integer IdPersonal_Padre,
    String  Nombre,
    String  Estado,
    String  Observacion,
    String  FechaCrea,
    String  FechaModifica) {
        this.IdPersonal        = IdPersonal;
        this.IdPersonal_Padre  = IdPersonal_Padre;
        this.Nombre            = Nombre;
        this.Estado            = Estado;
        this.Observacion       = Observacion;
        this.FechaCrea         = FechaCrea; 
        this.FechaModifica     = FechaModifica;               
    }
    
    public Integer getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        IdPersonal = idPersonal;
    }

    public Integer getIdPersonal_Padre() {
        return IdPersonal_Padre;
    }

    public void setIdPersonal_Padre(Integer idPersonal_Padre) {
        IdPersonal_Padre = idPersonal_Padre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
    public String getEstado() {
        return Estado;
    }
    
    public void setEstado(String estado) {
        Estado = estado;
    }
    
    public String getObservacion() {
        return Observacion;
    }
    
    public void setObservacion(String observacion) {
        Observacion = observacion;
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
    
    @Override
    public String toString(){
        return "\n" + getClass().getName()
             + "\n IdPersonal:       " + getIdPersonal()
             + "\n IdPersonal_Padre: " + getIdPersonal_Padre()
             + "\n Nombre:           " + getNombre()
             + "\n Estado:           " + getEstado()
             + "\n Observación:      " + getObservacion()
             + "\n FechaCrea:        " + getFechaCrea()
             + "\n FechaModifica:    " + getFechaModifica();
    }
    
}