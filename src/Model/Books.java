package Model;

import DB.MemberDB;

public class Books {
    private String bookId;
    private String title;
    private String author;
    private String edition;
    private int price;
    private String subject;
    private int numOfBook;

    public Books(String title, String author, String edition, int price, int numOfBook, String subject) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.subject = subject;
        this.numOfBook = numOfBook;
    }

    public Books() {

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public int getPrice() {
        return price;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void removeFromCatalogue(){

    }

    public void addToCatalogue(){

    }

    public void displayBookDetails(){

    }

    public void updateStatus(){

    }

    public void addNewBooks(){

    }

    public void deleteBook(){

    }

    public void searchBook(){

    }


}
