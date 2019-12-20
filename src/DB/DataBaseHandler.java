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
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
    }
//    n("jdbc:mysql://localhost/test?user=minty&password=greatsqldb")

    public void signUpUser(String firstname, String lastname, String username, String password, String gender, String grade){
        String insert = "INSERT INTO"  + Constant.USER_TABLE +
                "(" + Constant.USER_FIRSTNAME + "," + Constant.USER_LASTNAME +
                "," + Constant.USER_USERNAME + "," + Constant.USER_PASSWORD +
                "," + Constant.USER_GENDER + "," + Constant.USER_GRADE + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, firstname);
            prSt.setString(2, lastname);
            prSt.setString(3, username);
            prSt.setString(4, password);
            prSt.setString(5, gender);
            prSt.setString(6, grade);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
