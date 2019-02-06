package Dependencies.Games;

import java.awt.event.ActionEvent;

public class Coinflip extends GamblingGame{

    public boolean heads = false;
    private double greenPos = 180;

    public void bet(int b, double rotateAmnt)
    {
        System.out.println("I got this far");
    }

    public boolean roll(boolean head)
    {
        double roll = Math.random();
        if(head && roll>.5)
        {
            return true;
        }
        if(!head && roll<.5)
        {
            return true;
        }
        return false;
    }

}
