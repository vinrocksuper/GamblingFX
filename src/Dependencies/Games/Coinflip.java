package Dependencies.Games;

import Dependencies.Systems.User;

import java.awt.event.ActionEvent;

public class Coinflip extends GamblingGame{

    public boolean heads = false;
    private double greenPos = 180;
    private User u;

    public void bet(int b, double rotateAmnt)
    {
        greenPos += rotateAmnt;
        if(greenPos >360)
        {
            greenPos -=360;
        }
        if(heads && greenPos>=180)
        {
            userManager.updatePlayerBalance(u,2*b);
            System.out.println("You won " + 2*b);
        }
        if(!heads && greenPos<180)
        {
            userManager.updatePlayerBalance(u,2*b);
            System.out.println("You won " + 2*b);
        }
        else{
            userManager.updatePlayerBalance(u,-b);
            System.out.println("You lose " + -b);
        }
    }
}
