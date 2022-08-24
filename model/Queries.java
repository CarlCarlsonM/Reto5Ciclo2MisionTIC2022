package model;

import java.sql.*;

public class Queries {
    private static Connection dbConnection = null;
    private static Statement statement = null;
    private static String query = null;
    private static ResultSet queryResult = null;

    public static ResultSet executeQuery(int queryOption) {
        try {
            dbConnection = JDBCUtilities.getConnection();
            statement = dbConnection.createStatement();

            if (queryOption == 1) {
                query = "SELECT ID_Lider, Nombre, Primer_Apellido, "
                    + "Ciudad_Residencia FROM Lider "
                    + "ORDER BY Ciudad_Residencia";                
            }
            if (queryOption == 2) {
                query = "SELECT ID_Proyecto, Constructora, "
                    + "Numero_Habitaciones, Ciudad "
                    + "FROM Proyecto WHERE "
                    + "Clasificacion = 'Casa Campestre' "
                    + "AND Ciudad IN"
                    + "('Santa Marta','Cartagena','Barranquilla')";
            }
            if (queryOption == 3) {
                query = "SELECT C.ID_Compra, P.Constructora, "
                        + "P.Banco_Vinculado FROM Compra C "
                        + "JOIN Proyecto P ON "
                        + "(C.ID_Proyecto = P.ID_Proyecto) "
                        + "WHERE C.Proveedor = 'Homecenter' "
                        + "AND P.Ciudad = 'Salento'";
            }
            if (queryOption < 1 || queryOption > 3) {
                return null;
            }
            
            queryResult = statement.executeQuery(query);
            return queryResult;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}