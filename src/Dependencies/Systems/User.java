package Dependencies.Systems;

/**
 * Defines a User within the Application.
 * @Author Afaq Anwar
 * @Version 01/29/19
 */
public class User {
    private String firstName;
    private String lastName;
    // Every User has a unique ID.
    private int userID;
    // Every User has a balance.
    private int balance;

    /**
     * Main Constructor
     * @param firstName String that represents the firstName of the User.
     * @param lastName String that represents the lastName of the User.
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters & Setters.
    public String getFirstName() { return firstName; }
    protected void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    protected void setLastName(String lastName) { this.lastName = lastName; }

    public int getUserID() { return userID; }
    protected void setUserID(int userID) { this.userID = userID; }

    public int getBalance() { return balance; }
    protected void setBalance(int balance) { this.balance = balance; }
}
