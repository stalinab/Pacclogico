/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 20 - 02 - 2024
Script: DAO de Personal
*/

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

import DataAccessComponent.DTO.PersonalDTO;
import Framework.PatException;

public class PersonalDAO extends SQLiteDataHelper implements IDAO<PersonalDTO> {
    @Override
    public boolean create(PersonalDTO entity) throws Exception{
        String query = "INSERT INTO Personal(IdPersonal_Padre, Nombre)"
                     + "VALUES(?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonal_Padre());
            pstmt.setString(2, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }
    @Override
    public List<PersonalDTO> readAll() throws Exception{
        List<PersonalDTO> lst = new ArrayList<>();
        String query = "SELECT IdPersonal,        "
                     + "        IdPersonal_Padre, "
                     + "        Nombre,           "
                     + "        Estado,           "
                     + "        Observacion,      "
                     + "        FechaCrea,        "
                     + "        FechaModifica     "
                     + " FROM   Personal          "
                     + " WHERE  Estado = 'A'      ";

        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet    rs =  stmt.executeQuery(query);
            while (rs.next()) {
                PersonalDTO oPersonalDTO = new PersonalDTO(rs.getInt(1),
                                                           rs.getInt(2),
                                                           rs.getString(3),
                                                           rs.getString(4),
                                                           rs.getString(5),
                                                           rs.getString(6),
                                                           rs.getString(7));
                lst.add(oPersonalDTO);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }
    @Override
    public PersonalDTO read(Integer id) throws Exception{
        PersonalDTO oPersonalDTO = new PersonalDTO();
        String query = "SELECT IdPersonal,        "
                     + "        IdPersonal_Padre, "
                     + "        Nombre,           "
                     + "        Estado,           "
                     + "        Observacion,      "
                     + "        FechaCrea,        "
                     + "        FechaModifica     "
                     + " FROM   Personal          "
                     + " WHERE  Estado = 'A'      "
                     + " AND    IdPersonal =      "+ id.toString();
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                oPersonalDTO = new PersonalDTO(rs.getInt(1),
                                               rs.getInt(2),
                                               rs.getString(3),
                                               rs.getString(4),
                                               rs.getString(5),
                                               rs.getString(6),
                                               rs.getString(7));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "read()");
        }
        return oPersonalDTO;
    }
    @Override
    public boolean update(PersonalDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Personal SET IdPersonal_Padre = ?, " 
                     + " Nombre = ?,                               "
                     + " FechaModifica = ?                         "
                     + " WHERE IdPersonal = ?                      ";
        try {
            Connection         conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonal_Padre());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdPersonal());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }
    @Override
    public boolean delete(Integer id)throws Exception{
        String query = "UPDATE Personal SET Estado = ?"
                     + "WHERE IdPersonal = ?          ";
        try {
            Connection         conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public int getMaxId() throws Exception {
        int maxId = 0;
        String query = "SELECT MAX(IdPersonal) FROM Personal WHERE Estado = 'A'";
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