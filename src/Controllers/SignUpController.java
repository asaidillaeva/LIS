package Controllers;

import DB.DataBaseHandler;
import Model.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private RadioButton MaleRadioButton;

    @FXML
    private ToggleGroup genderToggle;

    @FXML
    private RadioButton femaleRadioButton;

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
            signUpNewMember();
        });

    }

    private void signUpNewMember(){
        DataBaseHandler dbHandler = new DataBaseHandler();

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
