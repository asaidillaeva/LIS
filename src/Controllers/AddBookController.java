package Controllers;

import DB.BookDB;
import Model.Books;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static java.lang.Integer.parseInt;

public class AddBookController extends Methods {

    @FXML
    private TextField titleText;

    @FXML
    private TextField authorText;

    @FXML
    private TextField editionText;

    @FXML
    private TextField numText;

    @FXML
    private TextField priceText;

    @FXML
    private TextField subjectText;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private TextField titleLine;

    @FXML
    private TextField authorLine;

    @FXML
    private TextField priceLine;

    @FXML
    private TextField editionLine;

    @FXML
    private TextField subjectLine;

    @FXML
    private TextField numLine;

    @FXML
    private TextField statusLine;

    @FXML
    void backPressed(MouseEvent event) {
        openWindow(addBtn, "/fxml/adminBook.fxml");
    }
    @FXML
    void initialize(){
        addBtn.setOnAction(event ->{
            if(!titleText.equals("") && !authorText.equals("") &&
                    !editionText.equals("") && !numText.equals("") &&
                    !priceText.equals("") && !subjectText.equals("")
            ){
                addNewBook();
            } else{
                animation(titleText,authorText);
                animation(editionText, numText);
                animation(priceText, subjectText);
            }
        });
    }

    public void addNewBook(){
        BookDB dbHandler = new BookDB();

        String title = titleText.getText();
        String author = authorText.getText();
        String edtion = editionText.getText();
        int numOfBook = parseInt(numText.getText());
        int price = parseInt(priceText.getText());
        String subject = subjectText.getText();
        Books book = new Books(title, author, edtion, numOfBook, price, subject);
        dbHandler.addBook(book);

    }

}
