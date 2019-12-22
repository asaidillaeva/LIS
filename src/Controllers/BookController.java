package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BookController extends Methods {

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
    private Button infoBtn;

    @FXML
    void initialize(){
        infoBtn.setOnAction(event ->{
            openWindow(infoBtn, "/fxml/infoPage.fxml");
        });
    }

    @FXML
    void iconPressed(MouseEvent event) {
        openWindow(infoBtn, "/fxml/homePage.fxml");
    }

    @FXML
    void addBook(MouseEvent event) {

    }

    @FXML
    void searchBook(MouseEvent event) {

    }

}
