package Dependencies.Games;

import java.util.ArrayList;

/**
 * Jack Hoang and Kent Li
 */
public class Jackpot extends GamblingGame
{
    // The total of every single bet
    private int betTotal;
    private  ArrayList<String> playerPool = new ArrayList<String>();

    public Jackpot()
    {
        this.betTotal = 0;
    }

}
