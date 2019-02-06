package Dependencies.Games;

import java.util.ArrayList;
import java.util.Random;

/**
 * Jack Hoang and Kent Li
 */
public class Jackpot extends GamblingGame
{
    // The total of every single bet

    private int betTotal = 0;

    private ArrayList<String> playerPool = new ArrayList<String>();

    private ArrayList<String> playerNames = new ArrayList<String>();


    public Jackpot()
    {
        this.betTotal = betTotal;
        this.playerPool = playerPool;
        this.playerNames = playerNames;
    }

    public ArrayList<String> fillArray()
    {
        Random rand = new Random();
        for(int i = 0; i < 5; i++)
        {
            playerPool.add(Integer.toString((rand.nextInt(100) + 5)));
        }
        playerNames.add(0,"Bot1");
        playerNames.add(1,"Bot2");
        playerNames.add(2,"Bot3");
        playerNames.add(3,"Bot4");
        playerNames.add(4,"Bot5");
        ArrayList<String> array3 = new ArrayList<String>();
        array3.add(playerNames.get(0) + ", " + playerPool.get(0));
        array3.add(playerNames.get(1) + ", " + playerPool.get(1));
        array3.add(playerNames.get(2) + ", " + playerPool.get(2));
        array3.add(playerNames.get(3) + ", " + playerPool.get(3));
        array3.add(playerNames.get(4) + ", " + playerPool.get(4));
        for(String item: array3)
        {
            System.out.println(item);
        }
        return array3;
    }




}
