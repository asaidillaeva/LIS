package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser( String firstName, String lastName, String username, String password, String gender, String ph_number){
        String insert = "INSERT "  + Constant.USER_TABLE +
                "(" + Constant.USER_FIRSTNAME + "," + Constant.USER_LASTNAME +
                "," + Constant.USER_USERNAME + "," + Constant.USER_PASSWORD +
                "," + Constant.USER_GENDER + "," + Constant.USER_NUMBER + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, firstName);
            prSt.setString(2, lastName);
            prSt.setString(3, username);
            prSt.setString(4, password);
            prSt.setString(5, gender);
            prSt.setString(6, ph_number);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
