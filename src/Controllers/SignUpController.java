package Controllers;

import DB.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private ChoiceBox<?> gradeChoiceBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button signInBtn;

    @FXML
    void initialize(){
        DataBaseHandler dbHandler = new DataBaseHandler();

        signUpBtn.setOnAction(event ->{
            dbHandler.signUpUser(firstnameTextField.getText(), lastnameTextField.getText(),
                    usernameTextField.getText(), passwordField.getText(), "Male", "1");
        });
    }

}
