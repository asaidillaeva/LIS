package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibrarianTest {

    Librarian admin = new Librarian("aliiaAdmin","aliia","Saidillaeva","123456","0777777777");
    @Test
    public void testClassName(){
        assertEquals("Librarian",admin.getClass().getSimpleName());
    }
    @Test
    public void testPackageName(){
        assertEquals("Model",admin.getClass().getPackageName());
    }
    @Test
    public void setUsername() {
        admin.setUsername("rapkatt");
        assertEquals("rapkatt",admin.getUsername());
    }

    @Test
    public void setFirstname() {
        admin.setFirstname("rapkat");
        assertEquals("rapkat",admin.getFirstname());
    }

    @Test
    public void setLastname() {
        admin.setLastname("baudunov");
        assertEquals("baudunov", admin.getLastname());
    }

    @Test
    public void setPh_no() {
        admin.setPh_no("0888888888");
        assertEquals("0888888888",admin.getPh_no());
    }

    @Test
    public void setPassword(){
        admin.setPassword("098765");
        assertEquals("098765", admin.getPassword());
    }

    @Test
    public void getUsername() {
        assertEquals("aliiaAdmin",admin.getUsername());
    }

    @Test
    public void getFirstname() {
        assertEquals("aliia",admin.getFirstname());
    }

    @Test
    public void getLastname() {
        assertEquals("Saidillaeva",admin.getLastname());
    }

    @Test
    public void getPh_no() {
        assertEquals("0777777777",admin.getPh_no());
    }
    @Test
    public void getPassword(){
        assertEquals("123456",admin.getPassword());
    }
}