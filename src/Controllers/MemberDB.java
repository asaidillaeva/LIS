package Controllers;

import Model.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public ResultSet getMember(Member user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Constant.USER_TABLE+" WHERE username =? AND password =?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
