package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Methods {

    protected void animation(Node username, Node password) {
        Shake userLoginAnim = new Shake(username);
        Shake userPassAnim = new Shake(password);
        userLoginAnim.playAnim();
        userPassAnim.playAnim();
    }


    public void openWindow(Button thatButton, String window){
        thatButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource( window ));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
