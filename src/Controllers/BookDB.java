package Controllers;

import Model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BookDB extends DBConnection{
    public static ObservableList<Books> bookList = FXCollections.observableArrayList();

    public void addBook(Books book){
        String insert = "INSERT INTO "  + Constant.BOOK_TABLE +
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

    public static ObservableList<Books> getBooks() throws SQLException, ClassNotFoundException {
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

    public static ObservableList<Books> search(String n, String m) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Constant.BOOK_TABLE + " WHERE "+n+" LIKE  '%"+m+"%'";
        PreparedStatement st = getDbConnection().prepareStatement(select);
        ResultSet resset = st.executeQuery(select);

        ObservableList<Books> allBooks= FXCollections.observableArrayList();

        while(resset.next()){
            String title = resset.getString(Constant.TITLE);
            String author = resset.getString(Constant.AUTHOR);
            String edition = resset.getString(Constant.EDITION);
            String subject = resset.getString(Constant.SUBJECT);
            int num = resset.getInt(Constant.NUM);

            Books book = new Books(title,author,edition,num,subject);
            allBooks.add(book);

        }return allBooks;
    }
    public static ObservableList<Books> searchTwo(String n, String m, String n1, String m1) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Constant.BOOK_TABLE + " WHERE "+n+" LIKE  '% "+m+" %' OR "+n1+" LIKE  '% "+m1+" %'";
        PreparedStatement st = getDbConnection().prepareStatement(select);
        ResultSet resset = st.executeQuery(select);

        ObservableList<Books> allBooks= FXCollections.observableArrayList();

        while(resset.next()){
            String title = resset.getString(Constant.TITLE);
            String author = resset.getString(Constant.AUTHOR);
            String edition = resset.getString(Constant.EDITION);
            String subject = resset.getString(Constant.SUBJECT);
            int num = resset.getInt(Constant.NUM);

            Books book = new Books(title,author,edition,num,subject);
            allBooks.add(book);

        }return allBooks;
    }

    public static ObservableList<Books> searchThree(String n, String m, String n1, String m1, String n2, String m2) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Constant.BOOK_TABLE + " WHERE "+n+" LIKE  '% "+ m+" %' OR "+n1+" LIKE  '% "+m1+" %' OR "+n2+" LIKE "+m2;
        PreparedStatement st = getDbConnection().prepareStatement(select);
        ResultSet resset = st.executeQuery(select);

        ObservableList<Books> allBooks= FXCollections.observableArrayList();

        while(resset.next()){
            String title = resset.getString(Constant.TITLE);
            String author = resset.getString(Constant.AUTHOR);
            String edition = resset.getString(Constant.EDITION);
            String subject = resset.getString(Constant.SUBJECT);
            int num = resset.getInt(Constant.NUM);

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
