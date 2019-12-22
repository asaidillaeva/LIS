package Controllers;

import DB.MemberDB;
import Model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignUpController extends Methods {

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField addressTextField;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button signInBtn;


    @FXML
    void initialize(){
        signUpBtn.setOnAction(event ->{
            if(!firstnameTextField.equals("") && !lastnameTextField.equals("") &&
                    !usernameTextField.equals("") && !passwordField.equals("") &&
                    !phoneNumberTextField.equals("") && !addressTextField.equals("")
            ){
                signUpNewMember();
            } else{
                animation(firstnameTextField,lastnameTextField);
                animation(usernameTextField, passwordField);
                animation(phoneNumberTextField, addressTextField);
            }
        });
        signInBtn.setOnAction(event -> {
            openWindow(signInBtn,"/fxml/loginPage.fxml");
        });
    }

    private void signUpNewMember(){
        MemberDB dbHandler = new MemberDB();

        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        Member member = new Member(firstName, lastName, username, password, address, phoneNumber);
        dbHandler.signUpUser(member);
    }


}
