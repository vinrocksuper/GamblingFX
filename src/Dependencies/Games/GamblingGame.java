package Dependencies.Games;

import Dependencies.Systems.User;
import Dependencies.Systems.UserManager;

import java.util.ArrayList;

/**
 * Gambling Game Class that sets up the base for each specific Game.
 * @Author Afaq Anwar
 * @Version 02/07/2019
 */
public class GamblingGame {
    // The UserManager being used for the current Game.
    public UserManager userManager;
    // The String that represents the generated Hash.
    protected String generatedHash;
    // The ArrayList of Strings that represents all the Hashes that have already been generated.
    private ArrayList<String> generatedHashes;

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase();
    private static final String digits = "0123456789";
    private static final String alphaNum = upper + lower + digits;

    /**
     * Main Constructor.
     */
    public GamblingGame() {
        userManager = new UserManager();
        generatedHashes = new ArrayList<>();
        generatedHash = this.generateRandomHash();
    }

    public void addCurrentPlayer(User user) { this.userManager.addActiveUser(user); }

    /**
     * Add a Hash to the ArrayList that contains all generated Hashes.
     * @param hash Any String that represents the current Hash.
     */
    private void addHashToList(String hash) { generatedHashes.add(hash); }

    /**
     * Generates a random Hash that is not already generated.
     * @return String that represents the generated Hash.
     */
    public String generateRandomHash() {
        String hash = "";
        int length = (int)((Math.random() * 976) + 25);
        boolean hashIsRandom = false;
        while (!hashIsRandom) {
            for (int i = 0; i < length; i++) {
                int randomChoice = (int) (Math.random() * alphaNum.length() - 1);
                hash += alphaNum.charAt(randomChoice);
            }
            if (!generatedHashes.contains(hash)) { hashIsRandom = true; }
        }
        this.addHashToList(hash);
        return hash;
    }
}