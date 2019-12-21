package Model;

public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int noBooksIssued;
    private final int  MaxLimitBooks = 20;
    private String address;
    private String phoneNumber;

    public Member(String firstName, String lastName,
                  String username, String password,
                  String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Member() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPh_no(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxLimitBooks() {
        return MaxLimitBooks;
    }

    public String getAddress() {
        return address;
    }

    public String getPh_no() {
        return phoneNumber;
    }
}
