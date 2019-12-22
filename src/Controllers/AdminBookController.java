package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminBookController extends Methods {

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView searchicon;

    @FXML
    private TextField title;

    @FXML
    private TextField subject;

    @FXML
    private ImageView addIcon;

    @FXML
    private TextField author;

    @FXML
    private AnchorPane dbPane;

    @FXML
    private Button noneBtn;

    @FXML
    void addBook(MouseEvent event) {
        openWindow(noneBtn, "/fxml/addBook.fxml");
    }

    @FXML
    void editBook(MouseEvent event) {

    }

    @FXML
    void iconPressed(MouseEvent event) {
        openWindow(noneBtn,"/fxml/loginPage.fxml");
    }

    @FXML
    void removeBook(MouseEvent event) {

    }

    @FXML
    void searchBook(MouseEvent event) {

    }

}
