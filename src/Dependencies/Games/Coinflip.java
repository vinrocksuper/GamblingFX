package Dependencies.Games;

import java.awt.event.ActionEvent;

public class Coinflip extends GamblingGame{

    public boolean heads = false;


    public void bet(int b)
    {
        if(roll(heads))
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
