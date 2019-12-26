package Model;

public class Librarian {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String ph_no;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Librarian(String username, String firstname, String lastname, String password, String ph_no) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.ph_no = ph_no;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPh_no() {
        return ph_no;
    }
}