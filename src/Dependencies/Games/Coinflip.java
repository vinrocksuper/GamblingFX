package Dependencies.Games;

import java.awt.event.ActionEvent;

public class Coinflip {

/**
 * To be coded later.
    public boolean bet(int b, ActionEvent choice)
    {
        return true;
    }
 **/
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
