package DB;

import Model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BookDB extends DBConnection{

    public void addBook(Books book){
        String insert = "INSERT "  + Constant.BOOK_TABLE +
                "(" + Constant.TITLE + "," + Constant.AUTHOR +
                 "," + Constant.EDITION + "," +Constant.NUM +
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
    public ObservableList<Books> getBooks() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Constant.BOOK_TABLE;
        PreparedStatement st = getDbConnection().prepareStatement(select);
        ResultSet resset = st.executeQuery(select);

        ObservableList<Books> allBooks= FXCollections.observableArrayList();

        while(resset.next()){
            String title = resset.getString(Constant.TITLE);
            String author = resset.getString(Constant.AUTHOR);
            String edition = resset.getString(Constant.EDITION);
            String subject = resset.getString(Constant.SUBJECT);
            Integer price = resset.getInt(Constant.PRICE);
            Integer num = resset.getInt(Constant.NUM);

            Books book = new Books(title,author,edition,price,num,subject);
            allBooks.add(book);

        }return allBooks;
    }

    public void editBook(){

    }

    public void removeBook(){

    }
}
