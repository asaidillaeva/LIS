package DB;

import Model.Member;
import Model.Books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MemberDB extends DBConnection {

    public void signUpUser(Member member){
        String insert = "INSERT "  + Constant.USER_TABLE +
                "(" + Constant.USER_FIRSTNAME + "," + Constant.USER_LASTNAME +
                "," + Constant.USER_USERNAME + "," + Constant.USER_PASSWORD +
                "," + Constant.USER_ADDRESS + "," + Constant.USER_NUMBER + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, member.getFirstName());
            prSt.setString(2, member.getLastName());
            prSt.setString(3, member.getUsername());
            prSt.setString(4, member.getPassword());
            prSt.setString(5, member.getAddress());
            prSt.setString(6, member.getPh_no());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(Member member){
        ResultSet resset = null;

        String select = "SELECT * FROM " + Constant.USER_TABLE + " WHERE " +
                Constant.USER_USERNAME+ " =? AND " + Constant.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, member.getUsername());
            prSt.setString(2, member.getPassword());

            resset = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resset;

    }
}
