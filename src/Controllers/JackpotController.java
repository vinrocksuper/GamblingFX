package Controllers;

import Dependencies.Games.Jackpot;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class JackpotController
{
    @FXML private Label yourName;
    @FXML private Label balanceNum;
    @FXML private Label currentBet;
    @FXML private Button startButton;
    @FXML private Label timeNum;
    @FXML private Label winPercent;
    @FXML private Button submitButton;

    private boolean gameState = false;
    private Jackpot jp;

    public void intialize()
    {
        jp = new Jackpot();
    }

    public void start()
    {
        if (!gameState)
        {
            gameState = true;
            long step = System.nanoTime() + 10000000000L;
            new AnimationTimer()
            {
                public void handle(long now)
                {
                    if (now > step)
                    {
                        timeNum.setText("0");
                    }
                    if (now < step)
                    {
                        long time2 = now - step;
                        timeNum.setText(Long.toString(-time2));
                    }
                }
            }.start();
        }
    }
    public void bet()
    {

    }
}
