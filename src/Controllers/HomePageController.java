package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController extends Methods {

    @FXML
    private Button backBtn;

    @FXML
    private Button infoBtn;

    @FXML
    private Button booksBtn;

    @FXML
    void initialize(){
        backBtn.setOnAction(event ->{
            backPressed();
        });
        booksBtn.setOnAction(event ->{
            bookPressed();
        });
        infoBtn.setOnAction(event -> {
            infoPressed();
        });
    }

    public void bookPressed() {
        openWindow(booksBtn, "/fxml/userBookFxml.fxml");
    }


    public void backPressed() {
        openWindow(backBtn,"/fxml/loginPage.fxml");
    }

    public void infoPressed() { openWindow(infoBtn, "/fxml/infoPage.fxml");

    }
}
