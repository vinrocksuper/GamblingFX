package Dependencies.Systems;

public class User {
    private String firstName;
    private String lastName;
    private int userID;
    private int balance;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    protected void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    protected void setLastName(String lastName) { this.lastName = lastName; }

    public int getUserID() { return userID; }
    protected void setUserID(int userID) { this.userID = userID; }

    public int getBalance() { return balance; }
    protected void setBalance(int balance) { this.balance = balance; }
}
