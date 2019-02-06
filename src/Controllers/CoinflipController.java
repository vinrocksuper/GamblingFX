package Controllers;

import Dependencies.Games.Coinflip;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CoinflipController implements Initializable {

    @FXML private JFXTextField amount;
    @FXML private Button h;
    @FXML private Button t;
    @FXML private Arc red;
    @FXML private Arc black;
    @FXML private Label prompt;

    private Coinflip cf;

    public boolean validate()
    {
        return (amount.getText().matches("[0-9]") && amount.getText().length() < 10);
    }

    private void displayAlert() {
        if (amount.getText().matches("[^0-9]")) {
            prompt.setText("Bets are whole numbers only.");

        } else if (amount.getText().length() > 10) {
            prompt.setText("Please bet a smaller amount. (Less than 1 Billion.)");

        }
    }


    public double rotate() {

        double rotateAmnt= 360*Math.random();

        long step = System.nanoTime() + 3000000000L;

            for(int i=0;i<rotateAmnt;i++) {

            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (now < step ) {
                        red.getTransforms().add(new Rotate(.05));
                        black.getTransforms().add(new Rotate(.05));

                    }

                }
            }.start();


        }
        return rotateAmnt;
    }

    public void handler(javafx.event.ActionEvent e) {
    /**    if(!validate())
        {
            displayAlert();
        }**/
        if(e.getSource()==h )
        {
            double x = rotate();
            cf.bet(100,x);
        }
        if(e.getSource()==t )
        {
            double x = rotate();
            cf.bet(100,x);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cf = new Coinflip();
        cf.addCurrentPlayer(LoginController.currentUser);
    }
}
