package Dependencies.Games;

import Controllers.LoginController;
import Dependencies.Systems.User;

import java.awt.event.ActionEvent;

public class Coinflip extends GamblingGame{

    public boolean heads = false;
    //red = head = true
    //black = tails =false
    private double greenPos = 0;

    public double bet(int b,User u)
    {
        double rotateAmnt = 360*Math.random();
        userManager.updatePlayerBalance(u,u.getBalance() + -b);
        greenPos += rotateAmnt;
        if(greenPos >360)
        {
            greenPos -=360;
        }
        if(heads && greenPos>180)
        {
            userManager.updatePlayerBalance(u,u.getBalance() + 2*b);
            System.out.println("You won " + 2*b);
        }
        else if(!heads && greenPos<=180)
        {
            userManager.updatePlayerBalance(u,u.getBalance() + 2*b);
            System.out.println("You won " + 2*b);
        }
        else{
            System.out.println("You lose " + b);
        }
        return rotateAmnt;
    }

    public double getGreenPos()
    {
        return greenPos;
    }
    public void setGreenPos(double x)
    {
        greenPos = x;
    }
}
