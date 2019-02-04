package Controllers;

import Dependencies.Games.Coinflip;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CoinflipController {

    @FXML private JFXTextField amount;
    @FXML private Button h;
    @FXML private Button t;
    @FXML private Arc red;
    @FXML private Arc black;
    @FXML private Label prompt;

    private Coinflip cf;


    public void intialize(){
        cf =new Coinflip();
        cf.addCurrentPlayer(LoginController.currentUser);
    }

    public void handler(ActionEvent e)
    {
        if(e.getSource()==h && cf.userManager.getStatusOfUser(LoginController.currentUser).equals("Playing") && validate())
        {
            cf.heads = true;
            cf.bet(Integer.parseInt(amount.getText()));
        }
        if(e.getSource()==t && cf.userManager.getStatusOfUser(LoginController.currentUser).equals("Playing") && validate())
        {
            cf.heads = false;
            cf.bet(Integer.parseInt(amount.getText()));
        }

    }



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


    public void rotate(javafx.event.ActionEvent actionEvent) {

        double rotateAmnt= 360*Math.random();


        long step = System.nanoTime() + 3000000000L;
            for(int i=0;i<rotateAmnt;i++) {

            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (now < step) {
                        red.getTransforms().add(new Rotate(6));
                        black.getTransforms().add(new Rotate(6));

                    }
                }
            }.start();


        }
    }
}
