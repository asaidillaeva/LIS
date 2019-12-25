package Controllers;

import DB.BookDB;
import DB.Constant;
import Model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

import static DB.BookDB.bookList;

public class UserPanelController extends Methods {

    @FXML
    private Pane infoPane;
    @FXML
    private Pane homePane;
    @FXML
    private Button backBtn;
    @FXML
    private Button infoBtn;
    @FXML
    private Button booksBtn;
    @FXML
    private Pane bookPane;
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
    private AnchorPane dbPane;
    @FXML
    private TableView<Books> TableView;
    @FXML
    private TableColumn<Books,String> titleColumn;
    @FXML
    private TableColumn<Books, String> authorColumn;
    @FXML
    private TableColumn<Books, String> publisherColumn;
    @FXML
    private TableColumn<Books, String> subjectColumn;
    @FXML
    private TableColumn<Books, Integer> numColumn;
    @FXML
    private Button noneBtn;
    @FXML
    void initialize(){
        homePane.toFront();

    }

    public void showBooks(ObservableList<Books> books){
        TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        numColumn.setCellValueFactory(new PropertyValueFactory<>("numOfBook"));

        TableView.setItems(bookList);
    }
    @FXML
    void backIconPressed(MouseEvent event) {
        homePane.toFront();
    }

    @FXML
    void backPressed(MouseEvent event) {
        openWindow(noneBtn,"/fxml/loginPage.fxml");
    }

    @FXML
    void bookPressed(MouseEvent event) throws SQLException, ClassNotFoundException {
        bookPane.toFront();
        BookDB bookDB = new BookDB();
        bookList = bookDB.getBooks();
        showBooks(bookList);
    }

    @FXML
    void infoIconPressed(MouseEvent event) {
        infoPane.toFront();
    }

    @FXML
    void infoPressed(MouseEvent event) {
        infoPane.toFront();
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
