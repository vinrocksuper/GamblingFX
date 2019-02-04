package Dependencies.Games;

import Dependencies.Systems.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Jack Hoang and Kent Li
 */
public class Jackpot extends GamblingGame
{
    // The total of every single bet
    private int betTotal;

    private HashMap<User,Integer> currentPlayerBet;

    public Jackpot()
    {
        this.betTotal = 0;
        currentPlayerBet = generateInitialPlayerMap(userManager.getCurrentActiveUsers());
    }
}
