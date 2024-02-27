package DataAccessComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|erick.caicedo@epn.edu.ec ErickCaiced2 |
|______________________________________|
Autor: ErickCaiced2
Fecha: 24/02/1014
src: Creación del SQLiteJavaHelper
*/

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database/Pacclogico.sqlite";
    private static Connection connection = null;

    protected SQLiteDataHelper(){}

    protected static synchronized Connection openConnection() throws Exception{
        try {
            if (connection == null) {
            connection = DriverManager.getConnection(DBPathConnection);
            }
        } catch (SQLException e) {
            throw e;
        }
        return connection;
    }

    protected static void closeConnection() throws Exception {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
