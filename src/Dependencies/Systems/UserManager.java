package Dependencies.Systems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * User Manager.
 * @Author Afaq Anwar
 * @Version 01/31/2019
 */
public class UserManager {
    // ArrayList containing all active Users.
    private ArrayList<User> currentActiveUsers;
    // HashMap that maps each User ID with the status of the User.
    private HashMap<Integer, String> statusOfUsers;

    /**
     * Main Constructor.
     */
    private void UserManager() {
        currentActiveUsers = new ArrayList<>();
        statusOfUsers = new HashMap<>();
    }

    // Getters for each Private Field.
    public ArrayList getCurrentActiveUsers() { return this.currentActiveUsers; }
    public HashMap getStatusOfUsers() { return this.statusOfUsers; }


    /**
     * Add a User to the current ArrayList of active Users.
     * @param user Any User.
     */
    public void addActiveUser(User user) { currentActiveUsers.add(user); }

    /**
     * Remove any User from the ArrayList of Active Users.
     * @param user Any User.
     */
    public void removeActiveUser(User user) { currentActiveUsers.remove(user); }

    /**
     * Get the status of a user.
     * @param user User that needs to be queried.
     * @return String that represents the status of the User if the User exists, "NULL" otherwise.
     */
    public String getStatusOfUser(User user) {
        if (statusOfUsers.containsKey(user.getUserID())) {
            return statusOfUsers.get(user.getUserID());
        } else {
            return "NULL";
        }
    }

    /**
     * Updates the HashMap with status of User.
     * @param user Any User.
     * @param status String that represents the current User status.
     */
    public void setStatusOfUser(User user, String status) {
        if (!statusOfUsers.containsKey(user.getUserID())) {
            statusOfUsers.put(user.getUserID(), status);
        } else {
            statusOfUsers.replace(user.getUserID(), status);
        }
    }
}
