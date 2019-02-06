package Dependencies.Games;

import java.awt.event.ActionEvent;

public class Coinflip extends GamblingGame{

    public boolean heads = false;
    private double greenPos = 180;

    public void bet(int b, double rotateAmnt)
    {
        greenPos += rotateAmnt;
        if(greenPos >360)
        {
            greenPos -=360;
        }
        if(heads && greenPos>=180)
        {

        }
        if(!heads && greenPos<180)
        {

        }
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
