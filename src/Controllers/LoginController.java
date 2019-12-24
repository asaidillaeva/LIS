package Controllers;

import DB.MemberDB;
import Model.Member;
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
            openWindow(signInBtn, "/fxml/signUpPage.fxml");
        });
    }



    private void loginUser(String loginUser, String loginPassword) {
        MemberDB dbHandler = new MemberDB();
        Member member = new Member();
        member.setUsername(loginUser);
        member.setPassword(loginPassword);
        dbHandler.getMember(member);
        ResultSet result = dbHandler.getMember(member);

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
            if(username.getText().trim().equals("aliiaAdmin12345")){
                openWindow(signInBtn, "/fxml/AdminPanel.fxml");
            }else {
                openWindow(signInBtn, "/fxml/UserPanes.fxml");
            }
        }else{
            animation(username, password);
        }

    }

}
