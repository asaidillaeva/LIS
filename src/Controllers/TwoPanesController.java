package Controllers;

import DB.BookDB;
import DB.Constant;
import Model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

import static DB.BookDB.bookList;
import static DB.BookDB.remove;
import static java.lang.Integer.parseInt;
public class TwoPanesController extends Methods {
    @FXML
    private Pane main;

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
        BookDB bookDB = new BookDB();
        try {
            bookList = bookDB.getBooks();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        showBooks(bookList);

        updateBtn.setOnAction(event ->{
            String t=titleEditText.getText();
            String a=authorEditText.getText();
            String e=editionEditText.getText();
            String s=subjectEditText.getText();
            int n = parseInt(numEditText.getText());
            Books book = new Books(t,a,e,n, s);
            bookDB.addBook(book);
        });
    }
    public void showBooks(ObservableList<Books> books){
        TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        numColumn.setCellValueFactory(new PropertyValueFactory<>("numOfBook"));

        TableView.setItems(books);
    }
    private void addNewBook(){
        String title = titleText.getText();
        String author = authorText.getText();
        String edition = editionText.getText();
        int numOfBook = parseInt(numText.getText());
        String subject = subjectText.getText();

        Books book = new Books(title, author, edition, numOfBook, subject);
        BookDB bookDB = new BookDB();
        bookDB.addBook(book);
        titleText.clear();
        authorText.clear();
        editionText.clear();
        subjectText.clear();
        numText.clear();

    }

    @FXML
    void addBook(MouseEvent event) {
        newBookPane.toFront();
    }
    @FXML
    void addBtnPressed(MouseEvent event) {
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
        remove(book);
        titleEditText.setText(book.getTitle());
        authorEditText.setText(book.getAuthor());
        editionEditText.setText(book.getEdition());
        subjectEditText.setText(book.getSubject());
        numEditText.setText(String.valueOf(book.getNumOfBook()));
    }
    @FXML
    void removeBook(MouseEvent event) throws SQLException, ClassNotFoundException {
        String t= TableView.getSelectionModel().getSelectedItem().getTitle();
        String a = TableView.getSelectionModel().getSelectedItem().getAuthor();
        String e = TableView.getSelectionModel().getSelectedItem().getEdition();
        String s = TableView.getSelectionModel().getSelectedItem().getSubject();
        int n = TableView.getSelectionModel().getSelectedItem().getNumOfBook();
      TableView.getItems().removeAll(TableView.getSelectionModel().getSelectedItem());
        Books book = new Books(t,a,e,n,s);
        remove(book);
    }
    @FXML
    void searchBook(MouseEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Books> books = FXCollections.observableArrayList();
        if(title.getText().isEmpty() && author.getText().isEmpty() && subject.getText().isEmpty()){
            animation(title,author);
            showBooks(bookList);
        }else if(!title.getText().isEmpty() && author.getText().isEmpty() && subject.getText().isEmpty()) {
            books = BookDB.search(Constant.TITLE, title.getText().trim());
        }else if(title.getText().isEmpty() && !author.getText().isEmpty() && subject.getText().isEmpty()){
            books = BookDB.search(Constant.AUTHOR, author.getText().trim());
        }else if(title.getText().isEmpty() && author.getText().isEmpty() && !subject.getText().isEmpty()){
            books = BookDB.search(Constant.SUBJECT, subject.getText().trim());
        }else if(title.getText().isEmpty() && author.getText().isEmpty() && !subject.getText().isEmpty()){
        }
        showBooks(books);
    }
}