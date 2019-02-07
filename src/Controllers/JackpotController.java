package Controllers;

import Dependencies.Games.Jackpot;
import Dependencies.Systems.User;
import Dependencies.Systems.UserManager;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import  javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class JackpotController implements Initializable
{
    @FXML private Label yourName;
    @FXML private Label balanceNum;
    @FXML private Label currentBet;
    @FXML private Button startButton;
    @FXML private Label timeNum;
    @FXML private Label winPercent;
    @FXML private Button submitButton;
    @FXML private TextField field;
    @FXML private Label prompt;

    private boolean gameState = false;
    private Jackpot jp;


    public void start()
    {
        if (!gameState)
        {
            gameState = true;
            long step = System.nanoTime() + 15000000000L;

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

    /**
     * Makes sure the betting amount entered is a whole number that is less than 1,000,000,000.
     * @return True if it meets the requirements, false otherwise.
     */
    private boolean validateBet() {
        return (prompt.getText().length() < 10 && prompt.getText().length() > 0 && jp.userManager.validateAmount(LoginController.currentUser, Integer.parseInt(prompt.getText())));
    }

    private void displayAlert() {
        if (field.getText().length() > 10) {
            prompt.setText("Smaller Bet Pls.");
        } else if (field.getText().matches(".")) {
            prompt.setText("Whole # Only.");
        } else if (field.getText().matches("[a-zA-Z]")){
            prompt.setText("Numbers Pls.");
        }
    }

    public void handler(javafx.event.ActionEvent e) {
        if (!validateBet()) {
            displayAlert();
        }
    }

    public void bet()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jp = new Jackpot();
        jp.addCurrentPlayer(LoginController.currentUser);
        balanceNum.setText(Integer.toString(LoginController.currentUser.getBalance()));
        yourName.setText(LoginController.currentUser.getFirstName() + " " + LoginController.currentUser.getLastName());
    }
}
