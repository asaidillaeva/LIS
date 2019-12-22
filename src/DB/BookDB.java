package DB;

import Model.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDB extends DBConnection {

    public void addBook(Books book){
        String insert = "INSERT "  + Constant.BOOK_TABLE +
                "(" + Constant.TITLE + "," + Constant.AUTHOR +
                 "," + Constant.EDITION + "," +Constant.NumOfBook +
                "," + Constant.PRICE + "," + Constant.SUBJECT+ ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getTitle());
            prSt.setString(2, book.getAuthor());
            prSt.setString(3, book.getEdition());
            prSt.setInt(4, book.getNumOfBook());
            prSt.setInt(5, book.getPrice());
            prSt.setString(6, book.getSubject());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getBook(String title){
        ResultSet resset = null;

        String select = "SELECT * FROM " + Constant.BOOK_TABLE + " WHERE " +
                Constant.TITLE+ " =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, title);

            resset = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resset;
    }

    public void editBook(){

    }

    public void removeBook(){

    }
}
