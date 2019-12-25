package DB;
import Model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
public class BookDB extends DBConnection{
    public static ObservableList<Books> bookList = FXCollections.observableArrayList();


    public void addBook(Books book){
        String insert = "INSERT "  + Constant.BOOK_TABLE +
                "(" + Constant.TITLE + "," + Constant.AUTHOR +
                "," + Constant.EDITION + "," +Constant.NUM +
                "," + Constant.SUBJECT+ ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getTitle());
            prSt.setString(2, book.getAuthor());
            prSt.setString(3, book.getEdition());
            prSt.setInt(4, book.getNumOfBook());
            prSt.setString(5, book.getSubject());
            prSt.executeUpdate();
            bookList.add(book);
        } catch (SQLException | ClassNotFoundException e) {
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
            Integer num = resset.getInt(Constant.NUM);

            Books book = new Books(title,author,edition,num,subject);
            allBooks.add(book);

        }return allBooks;
    }

    public static void remove(Books book) throws SQLException, ClassNotFoundException {
        String query="DELETE FROM "+Constant.BOOK_TABLE+" WHERE "+Constant.TITLE+" = '"+book.getTitle()+"'";
        PreparedStatement statement= getDbConnection().prepareStatement(query);
        statement.executeUpdate(query);
        bookList.removeAll(book);
    }
}
