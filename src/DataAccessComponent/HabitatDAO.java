package DataAccessComponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccessComponent.DTO.HabitatDTO;
import Framework.PatException;


public class HabitatDAO extends SQLiteDataHelper implements IDAO<HabitatDTO> {

    @Override
    public boolean create(HabitatDTO entity) throws Exception {
        String query = " INSERT INTO Habitat (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdHabitat",e);
        }
    }

    @Override
    public List<HabitatDTO> readAll() throws Exception {
        List<HabitatDTO> lst = new ArrayList<>() ;//VACIA
        String query = "SELECT  IdHabitat"
                  +", Nombre        "
                  +", Observacion   "
                  +", Estado        "
                  +", FechaCrea     "
                  +", FechaModifica " //DTO
                  +" FROM     Habitat ";
                  //LEEMOS LA TABLA
     try{
         Connection conn = openConnection();  
         Statement stmt = conn.createStatement(); 
         ResultSet rs = stmt.executeQuery(query);
         //return stmt.executeQuery(query);  // RESULTADO DE LO QUE VIENE DE LA CLASE, ENTONCES USAREMOS:
         
         while (rs.next()) {
             HabitatDTO oDTOClasificacion = new HabitatDTO (rs.getInt(1), 
                                                        rs.getString(2), 
                                                        rs.getString(3), 
                                                        rs.getString(4), 
                                                        rs.getString(5),
                                                        rs.getString(5));
             lst.add(oDTOClasificacion);//cada vez que traemos una fila agregamos a una lista.
         }
     }catch(SQLException e){
        throw new Exception(getClass()+"getMaxIdHabitat",e);
     }
     return lst;
    }

@Override
    public HabitatDTO read(Integer id) throws Exception {
        HabitatDTO oDTOClasificacion = new HabitatDTO();
        String query =" SELECT IdHabitat  " 
                     +",Nombre            "    
                     +",Observacion"
                     +",Estado            "    
                     +",FechaCrea         "    
                     +",FechaModifica     "   
                     +"FROM    Habitat       "   
                     +"WHERE   Estado ='A' AND IdHabitat =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                HabitatDTO oDTOClasificacion1 = new HabitatDTO (rs.getInt(1), 
                                                                rs.getString(2), 
                                                                rs.getString(3), 
                                                                rs.getString(4), 
                                                                rs.getString(5),
                                                                rs.getString(5));    // FechaModifica
                oDTOClasificacion=oDTOClasificacion1;    }
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdHabitat",e);
        }
        return oDTOClasificacion;
    }

    @Override
    public boolean update(HabitatDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Habitat SET Nombre = ?, FechaModifica = ? WHERE IdHabitat = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdHabitat());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdHabitat",e);
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Habitat SET Estado = ? WHERE IdHabitat = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdHabitat",e);
        }
    }

    @Override
    public int getMaxId() throws Exception {
        int maxId = 0;
        String query = "SELECT MAX(IdHabitat) FROM Habitat WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next())
                maxId = rs.getInt(1);
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxId()");
        }
        return maxId;
    }
}