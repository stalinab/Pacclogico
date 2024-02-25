package DataAccessComponent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DataAccessComponent.DTO.AnimalDTO;
public class AnimalDAO extends SQLiteDataHelper {
    public AnimalDTO readBy(Integer id) throws Exception {
        AnimalDTO oS = new AnimalDTO();
        String query ="SELECT An.IdAnimal AS IdAnimal, Se.Nombre AS Sexo, Ha.Nombre AS Habitat, Cla.Nombre AS Clasificacion, An.Nombre AS NombreAnimal, An.Qr AS Qr "
                    + "FROM Animal An "
                    + "JOIN Habitat Ha ON An.IdHabitat = Ha.IdHabitat "
                    + "JOIN Clasificacion Cla ON An.IdClasificacion = Cla.IdClasificacion "
                    + "JOIN Sexo Se ON An.IdSexo = Se.IdSexo "
                    + "WHERE An.Estado = 'A' "
                    + "AND Se.Estado = 'A'"
                    + "AND Ha.Estado = 'A' "
                    + "AND Cla.Estado = 'A' "
                    + "AND An.IdAnimal = " + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new AnimalDTO(rs.getInt(1)              
                                    ,rs.getString(2)         
                                    ,rs.getString(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5)
                                    ,rs.getString(6));     
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return oS;
    }

    public List<AnimalDTO> readAll() throws Exception {
        List <AnimalDTO> lst = new ArrayList<>();
        String query ="SELECT An.IdAnimal AS IdAnimal, Se.Nombre AS Sexo, Ha.Nombre AS Habitat, Cla.Nombre AS Clasificacion, An.Nombre AS NombreAnimal, An.Qr AS Qr "
                        + "FROM Animal An "
                        + "JOIN Habitat Ha ON An.IdHabitat = Ha.IdHabitat "
                        + "JOIN Clasificacion Cla ON An.IdClasificacion = Cla.IdClasificacion "
                        + "JOIN Sexo Se ON An.IdSexo = Se.IdSexo "
                        + "WHERE An.Estado = 'A' "
                        + "AND Se.Estado = 'A'"
                        + "AND Ha.Estado = 'A' "
                        + "AND Cla.Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                AnimalDTO s = new AnimalDTO(rs.getInt(1)              
                                                ,rs.getString(2)         
                                                ,rs.getString(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                ,rs.getString(6));        // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

    public List<AnimalDTO> readAllEstructura(String tipo)  throws Exception {
        List <AnimalDTO> lst = new ArrayList<>();
        String query = "SELECT An.IdAnimal AS IdAnimal, Se.Nombre AS Sexo, Ha.Nombre AS Habitat, Cla.Nombre AS Clasificacion, An.Nombre AS NombreAnimal, An.Qr AS Qr "
                    + "FROM Animal An "
                    + "JOIN Habitat Ha ON An.IdHabitat = Ha.IdHabitat "
                    + "JOIN Clasificacion Cla ON An.IdClasificacion = Cla.IdClasificacion "
                    + "JOIN Sexo Se ON An.IdSexo = Se.IdSexo "
                    + "WHERE An.Estado = 'A' "
                    + "AND Se.Estado = 'A' "
                    + "AND Ha.Estado = 'A' "
                    + "AND Cla.Estado = 'A' "
                    + "AND lower(Ha.Nombre) = " + (tipo.equals("Selva") ? "'Arboles'" : "'" + tipo + "'").toLowerCase();                               
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                AnimalDTO s = new AnimalDTO(rs.getInt(1)              
                                            ,rs.getString(2)         
                                            ,rs.getString(3)
                                            ,rs.getString(4)
                                            ,rs.getString(5)
                                            ,rs.getString(6));          // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

}
