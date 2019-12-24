package Controllers;

import DB.BookDB;
import Model.Books;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

import static DB.BookDB.bookList;
import static java.lang.Integer.parseInt;


public class TwoPanesController extends Methods {

    @FXML
    private Pane main;
    @FXML
    private ImageView backIcon;
    @FXML
    private ImageView searchicon;
    @FXML
    private TextField title;
    @FXML
    private TextField subject;
    @FXML
    private TextField author;
    @FXML
    private Pane editBookPane;
    @FXML
    private TextField titleEditText;
    @FXML
    private TextField authorEditText;
    @FXML
    private TextField editionEditText;
    @FXML
    private TextField numEditText;
    @FXML
    private TextField subjectEditText;
    @FXML
    private Button updateBtn;
    @FXML
    private Pane newBookPane;
    @FXML
    private TextField titleText;
    @FXML
    private TextField authorText;
    @FXML
    private TextField editionText;
    @FXML
    private TextField numText;
    @FXML
    private TextField subjectText;
    @FXML
    private Button addNewBtn;
    @FXML
    private TableView<Books> TableView;
    @FXML
    private TableColumn<Books, String> titleColumn;
    @FXML
    private TableColumn<Books, String> authorColumn;
    @FXML
    private TableColumn<Books, String> publisherColumn;
    @FXML
    private TableColumn<Books, String> subjectColumn;
    @FXML
    private TableColumn<Books, Integer> numColumn;


    @FXML
    void initialize(){
        main.toFront();
        showBooks();


        updateBtn.setOnAction(event ->{
            BookDB bookDB = new BookDB();

            String t=titleEditText.getText();
            String a=authorEditText.getText();
            String e=editionEditText.getText();
            String s=subjectEditText.getText();
            Integer n = parseInt(numEditText.getText());
            Books book = new Books(t,a,e,n, s);
            try {
                bookDB.editBook(book);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }
    public void showBooks(){
        TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        BookDB bookDB = new BookDB();
        try {
            bookList = bookDB.getBooks();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        titleColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("edition"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("subject"));
        numColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("numOfBook"));

        TableView.setItems(bookList);
    }

    private void addNewBook() throws SQLException, ClassNotFoundException {
        String title = titleText.getText();
        String author = authorText.getText();
        String edition = editionText.getText();
        int numOfBook = parseInt(numText.getText());
        String subject = subjectText.getText();

        Books book = new Books(title, author, edition, numOfBook, subject);
        BookDB bookDB = new BookDB();
        bookDB.addBook(book);
    }


    @FXML
    void addBook(MouseEvent event) {
        newBookPane.toFront();
    }

    @FXML
    void addBtnPressed(MouseEvent event) throws SQLException, ClassNotFoundException {
        if(!titleText.getText().equals("") && !authorText.getText().equals("")  &&
                !editionText.getText().equals("")  && !numText.getText().equals("") &&
                !subjectText.getText().equals("")
        ){
            addNewBook();
        } else{
            animation(titleText,authorText);
            animation(editionText, numText);
        }
    }
    @FXML
    void backEditPressed(MouseEvent event) {
        main.toFront();
    }

    @FXML
    void backIconPressed(MouseEvent event) {
        openWindow(addNewBtn, "/fxml/loginPage.fxml");
    }

    @FXML
    void backNewPressed(MouseEvent event) {
        main.toFront();
    }

    @FXML
    void editBook(MouseEvent event) throws SQLException, ClassNotFoundException {
        Books book = TableView.getSelectionModel().getSelectedItem();
        BookDB bookDB = new BookDB();
        editBookPane.toFront();
        titleEditText.setText(book.getTitle());
        authorEditText.setText(book.getAuthor());
        editionEditText.setText(book.getEdition());
        subjectEditText.setText(book.getSubject());
        numEditText.setText(String.valueOf(book.getNumOfBook()));
    }

    @FXML
    void removeBook(MouseEvent event) throws SQLException, ClassNotFoundException {
      TableView.getItems().removeAll(TableView.getSelectionModel().getSelectedItem());
        String t= TableView.getSelectionModel().getSelectedItem().getTitle();
        String a = TableView.getSelectionModel().getSelectedItem().getAuthor();
        String e = TableView.getSelectionModel().getSelectedItem().getEdition();
        String s = TableView.getSelectionModel().getSelectedItem().getSubject();
        Integer n = TableView.getSelectionModel().getSelectedItem().getNumOfBook();
        Books book = new Books(t,a,e,n, s);
        BookDB.remove(book);
        bookList.removeAll(book);
    }

    @FXML
    void searchBook(MouseEvent event) {
    }

}