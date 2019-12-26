package Model;

public class Books {
    private Integer bookId;
    private String title;
    private String author;
    private String edition;
    private String subject;
    private int numOfBook;

    public Books(String title, String author, String edition, int numOfBook, String subject) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.subject = subject;
        this.numOfBook = numOfBook;


    }

    public Books() {

    }


    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }

    public int getBookId() {
        return bookId ;
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

    public String getSubject() {
        return subject;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
