package Dependencies.Games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Jack Hoang and Kent Li
 */
public class Jackpot extends GamblingGame
{
    private int betTotal = 0;

    private ArrayList<String> playerPool = new ArrayList<>();

    private ArrayList<String> playerNames = new ArrayList<>();

    private ArrayList<String> array3 = new ArrayList<>();

    private ArrayList<String> bettingArray = new ArrayList<>();

    private ArrayList<String> winPercent = new ArrayList<>();

    private String win = "";

    private int sum = 0;

    public Jackpot()
    {
        this.betTotal = betTotal;
        this.playerPool = playerPool;
        this.playerNames = playerNames;
        this.array3 = array3;
        this.winPercent = winPercent;
        this.sum = sum;
        this.win = win;
    }

    public ArrayList<String> fillArray()
    {
        Random rand = new Random();
        for(int i = 0; i < 5; i++)
        {
            playerPool.add(Integer.toString((rand.nextInt(50) + 20)));
        }
        playerNames.add(0,"Bot1");
        playerNames.add(1,"Bot2");
        playerNames.add(2,"Bot3");
        playerNames.add(3,"Bot4");
        playerNames.add(4,"Bot5");
        array3.add(playerNames.get(0) + ", " + playerPool.get(0));
        array3.add(playerNames.get(1) + ", " + playerPool.get(1));
        array3.add(playerNames.get(2) + ", " + playerPool.get(2));
        array3.add(playerNames.get(3) + ", " + playerPool.get(3));
        array3.add(playerNames.get(4) + ", " + playerPool.get(4));
        for(int i = 0; i < playerPool.size(); i++)
        {
            sum+=Integer.parseInt(playerPool.get(i));
        }
        double win0 = (Double.valueOf(playerPool.get(0))/sum) * 100;
        double win1 = (Double.valueOf(playerPool.get(1))/sum) * 100;
        double win2 = (Double.valueOf(playerPool.get(2))/sum) * 100;
        double win3 = (Double.valueOf(playerPool.get(3))/sum) * 100;
        double win4 = (Double.valueOf(playerPool.get(4))/sum) * 100;
        winPercent.add(array3.get(0) + ", " + win0);
        winPercent.add(array3.get(1) + ", " + win1);
        winPercent.add(array3.get(2) + ", " + win2);
        winPercent.add(array3.get(3) + ", " + win3);
        winPercent.add(array3.get(4) + ", " + win4);
        for(String item: winPercent)
        {
            System.out.println(item);
        }
        return winPercent;
    }

    public ArrayList<String> bettingArr()
    {
        for(int i = 0; i < Integer.parseInt(playerPool.get(0)); i++)
        {
            bettingArray.add(playerNames.get(0));
        }
        for(int i = 0; i < Integer.parseInt(playerPool.get(1)); i++)
        {
            bettingArray.add(playerNames.get(1));
        }
        for(int i = 0; i < Integer.parseInt(playerPool.get(2)); i++)
        {
            bettingArray.add(playerNames.get(2));
        }
        for(int i = 0; i < Integer.parseInt(playerPool.get(3)); i++)
        {
            bettingArray.add(playerNames.get(3));
        }
        for(int i = 0; i < Integer.parseInt(playerPool.get(4)); i++)
        {
            bettingArray.add(playerNames.get(4));
        }
        Collections.shuffle(bettingArray);
        return bettingArray;
    }

    public String pickWinner()
    {
        Random k = new Random();
        int winningIndex = k.nextInt(bettingArray.size());
        win = bettingArray.get(winningIndex);
        System.out.println("The Winner Is: " + win + ".");
        return win;
    }
}
