package Controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class BooksTest {

    Books book = new Books("Miracle", "John Green","litress", 2,"Fantasy");
    @Test
    public void setNumOfBook() {
        book.setNumOfBook(9);
        assertEquals(9,book.getNumOfBook(),0.0);

    }

    @Test
    public void getTitle() {
        assertEquals("Miracle",book.getTitle());
    }

    @Test
    public void getAuthor() {
        assertEquals("John Green",book.getAuthor());
    }

    @Test
    public void getEdition() {
        assertEquals("litress",book.getEdition());
    }

    @Test
    public void getSubject() {
        assertEquals("Fantasy", book.getSubject());
    }

    @Test
    public void getNumOfBook() {
        assertEquals(2,book.getNumOfBook(),0.0);
    }

    @Test
    public void setTitle(){
        book.setTitle("easy");
        assertEquals("easy", book.getTitle());
    }
    @Test
    public void setAuthor(){
        book.setAuthor("Davincci");
        assertEquals("Davincci", book.getAuthor());
    }

    @Test
    public void setEdition(){
        book.setEdition("test");
        assertEquals("test", book.getEdition());
    }
    @Test
    public void setSubject(){
        book.setSubject("story");
        assertEquals("story",book.getSubject());
    }
}