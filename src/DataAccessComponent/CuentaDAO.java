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
import DataAccessComponent.DTO.CuentaDTO;
import Framework.PatException;


public class CuentaDAO extends SQLiteDataHelper implements IDAO<CuentaDTO> {

    @Override
    public boolean create(CuentaDTO entity) throws Exception {
        String query = " INSERT INTO Cuenta (IdPersonal, Correo, Password) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonal());
            pstmt.setString(2, entity.getCorreo());
            pstmt.setString(3, entity.getPassword());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CuentaDTO> readAll() throws Exception {
        List<CuentaDTO> lst = new ArrayList<>() ;//VACIA
        String query = "SELECT  IdCuenta"
                  +",IdPersonal   " 
                  +",Correo       " 
                  +",Password     " 
                  +",Observacion  " 
                  +",Estado       " 
                  +",FechaCrea    " 
                  +",FechaModifica "
                  +" FROM     Cuenta ";
                  //LEEMOS LA TABLA
     try{
         Connection conn = openConnection();  
         Statement stmt = conn.createStatement(); 
         ResultSet rs = stmt.executeQuery(query);
         //return stmt.executeQuery(query);  // RESULTADO DE LO QUE VIENE DE LA CLASE, ENTONCES USAREMOS:
         
         while (rs.next()) {
             CuentaDTO oDTOCuenta = new CuentaDTO (rs.getInt(1), 
                                                        rs.getInt(2), 
                                                        rs.getString(3), 
                                                        rs.getString(4), 
                                                        rs.getString(5),
                                                        rs.getString(6),
                                                        rs.getString(7),
                                                        rs.getString(8));
             lst.add(oDTOCuenta);//cada vez que traemos una fila agregamos a una lista.
         }
     }catch(SQLException e){
        throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
     }
     return lst;
    }

@Override
    public CuentaDTO read(Integer id) throws Exception {
        CuentaDTO oDTOCuenta = new CuentaDTO();
        String query ="SELECT  IdCuenta"
                    +",IdPersonal   " 
                    +",Correo       " 
                    +",Password     " 
                    +",Observacion  " 
                    +",Estado       " 
                    +",FechaCrea    " 
                    +",FechaModifica "
                    +"FROM     Cuenta "  
                    +"WHERE   Estado ='A' AND IdCuenta =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                CuentaDTO oDTOCuenta1 = new CuentaDTO (rs.getInt(1), 
                rs.getInt(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8));
                oDTOCuenta=oDTOCuenta1;    }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "read()");
        }
        return oDTOCuenta;
    }

    @Override
    public boolean update(CuentaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Cuenta SET Password = ?, FechaModifica = ? WHERE IdCuenta = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCorreo());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdCuenta());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Cuenta SET Estado = ? WHERE IdCuenta = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public int getMaxId() throws Exception{
        int maxId = 0;
        String query = "SELECT MAX(IdCuenta) FROM Cuenta WHERE Estado = 'A'";
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
