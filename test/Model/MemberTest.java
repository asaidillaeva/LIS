package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberTest {

    Member user = new Member("Aliia", "Saidillaeva","aliia","12345","Bishkek","077777777");
    @Test
    public void testClassName(){
        assertEquals("Member",user.getClass().getSimpleName());
    }
    @Test
    public void testPackageName(){
        assertEquals("Model",user.getClass().getPackageName());
    }
    @Test
    public void setFirstName() {
        user.setFirstName("Timur");
        assertEquals("Timur",user.getFirstName());
    }

    @Test
    public void setLastName() {
        user.setLastName("Kasenov");
        assertEquals("Kasenov",user.getLastName());
    }

    @Test
    public void setUsername() {
        user.setUsername("Weskas");
        assertEquals("Weskas",user.getUsername());
    }

    @Test
    public void setPassword() {
        user.setPassword("09876");
        assertEquals("09876",user.getPassword());
    }

    @Test
    public void setAddress() {
        user.setAddress("Tunguch");
        assertEquals("Tunguch", user.getAddress());
    }

    @Test
    public void setPh_no() {
        user.setPh_no("0787878787");
        assertEquals("0787878787",user.getPh_no());
    }

    @Test
    public void getFirstName() {
        assertEquals("Aliia",user.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Saidillaeva",user.getLastName());
    }

    @Test
    public void getUsername() {
        assertEquals("aliia",user.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("12345", user.getPassword());
    }

    @Test
    public void getNoBooksIssued() {
        assertEquals(10,user.getNoBooksIssued());
    }

    @Test
    public void getMaxLimitBooks() {
        assertEquals(20,user.getMaxLimitBooks());
    }

    @Test
    public void getAddress() {
        assertEquals("Bishkek", user.getAddress());
    }

    @Test
    public void getPh_no() {
        assertEquals("077777777",user.getPh_no());
    }
}