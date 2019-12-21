package Controllers;

import DB.DataBaseHandler;
import Model.Member;
import com.sun.net.httpserver.Authenticator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends Methods {

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

            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }
            else{
                animation(username,password);
            }

        });
        signUpBtn.setOnAction(event ->{
            signUpBtn.getScene().getWindow().hide();
            openWindow("/fxml/signUpPage.fxml");
        });
    }



    private void loginUser(String loginUser, String loginPassword) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Member member = new Member();
        member.setUsername(loginUser);
        member.setPassword(loginPassword);
        dbHandler.getUser(member);
        ResultSet result = dbHandler.getUser(member);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter>=1){
            signUpBtn.getScene().getWindow().hide();
            openWindow("/fxml/homePage.fxml");
        }else{
            animation(username, password);
        }

    }

}
