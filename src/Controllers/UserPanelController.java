package Controllers;

import DB.BookDB;
import Model.Books;
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
    @FXML
    void backIconPressed(MouseEvent event) {
        homePane.toFront();
    }

    @FXML
    void backPressed(MouseEvent event) {
        openWindow(noneBtn,"/fxml/loginPage.fxml");
    }

    @FXML
    void bookPressed(MouseEvent event) {
        bookPane.toFront();
        showBooks();
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
    void searchBook(MouseEvent event) {

    }

}
