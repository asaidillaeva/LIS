package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    void initialize(){
        signInBtn .setOnAction(event ->{
            String loginText = username.getText().trim();
            String loginPassword = password.getText().trim();

            if(!loginPassword.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }
            else{
                animation();
            }

        });
        signUpBtn.setOnAction(event ->{
            signUpBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/signUpPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void animation() {
        Shake userLoginAnim = new Shake(username);
        Shake userPassAnim = new Shake(password);
        userLoginAnim.playAnim();
        userPassAnim.playAnim();
    }

    private void loginUser(String loginText, String loginPassword) {

    }

}
