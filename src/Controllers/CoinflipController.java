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
import javafx.scene.control.TextField;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import sun.rmi.runtime.Log;

import java.net.URL;
import java.util.ResourceBundle;

public class CoinflipController implements Initializable {

    @FXML private TextField amount;
    @FXML private Button h;
    @FXML private Button t;
    @FXML private Arc red;
    @FXML private Arc black;
    @FXML private Label prompt;
    @FXML private Label balance;
    @FXML private Label green;
    private Coinflip cf;

    public boolean validate()
    {
        return (amount.getText().matches("[0-9]") && amount.getText().length() < 10 && LoginController.currentUser.getBalance() >Integer.parseInt(amount.getText()));
    }

    private void displayAlert() {
        if (amount.getText().matches("[^0-9]")) {
            prompt.setText("Bets are whole numbers only.");

        } else if (amount.getText().length() > 10) {
            prompt.setText("Please bet a smaller amount. (Less than 1 Billion.)");

        }
    }


    public double rotate() {
        cf.setGreenPos(0);
        double rotateAmnt= 360*Math.random();
        System.out.println(rotateAmnt);
      //  long step = System.nanoTime() + 100000000L;

        red.getTransforms().add(new Rotate(-cf.getGreenPos()));
        black.getTransforms().add(new Rotate(-cf.getGreenPos()));

        for(int i=0;i<rotateAmnt;i++) {
            red.getTransforms().add(new Rotate(1));
            black.getTransforms().add(new Rotate(1));
        }

        /**    new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (now < step ) {
                        red.getTransforms().add(new Rotate(1));
                        black.getTransforms().add(new Rotate(1));

                    }

                }
            }.start();
        **/


        return rotateAmnt;
    }

    public void handler(javafx.event.ActionEvent e) {
        if(!validate())
        {
            displayAlert();
        }

            cf.heads =true;
            cf.bet(Integer.parseInt(amount.getText()),rotate(),LoginController.currentUser);
            balance.setText(Integer.toString(LoginController.currentUser.getBalance()));
             green.setText(Double.toString(cf.getGreenPos()));
    }
    public void handlert(javafx.event.ActionEvent e) {
        if(!validate())
        {
            displayAlert();
        }

            cf.heads =false;
            cf.bet(Integer.parseInt(amount.getText()),rotate(),LoginController.currentUser);
            balance.setText(Integer.toString(LoginController.currentUser.getBalance()));
            green.setText(Double.toString(cf.getGreenPos()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cf = new Coinflip();
        cf.addCurrentPlayer(LoginController.currentUser);
        balance.setText(Integer.toString(LoginController.currentUser.getBalance()));
    }
}
