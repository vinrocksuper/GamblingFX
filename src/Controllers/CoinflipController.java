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


    public void rotate(double rotateAmnt) {
        //long step = System.nanoTime() + 100000000L;

        for(int i=0;i<rotateAmnt*20;i++) {
            red.getTransforms().add(new Rotate(.05));
            black.getTransforms().add(new Rotate(.05));

          /**  new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (now < step) {
                        red.getTransforms().add(new Rotate(.05));
                        black.getTransforms().add(new Rotate(.05));

                    }

                }
            }.start();**/
        }

    }

    public void handler(javafx.event.ActionEvent e) {
        if(!validate())
        {
            displayAlert();
        }

            cf.heads =true;
            double x = cf.bet(Integer.parseInt(amount.getText()),LoginController.currentUser);
            rotate(x);
            balance.setText(Integer.toString(LoginController.currentUser.getBalance()));
            green.setText(Double.toString(cf.getGreenPos()));
    }
    public void handlert(javafx.event.ActionEvent e) {
        if(!validate())
        {
            displayAlert();
        }

            cf.heads =false;
            double x = cf.bet(Integer.parseInt(amount.getText()),LoginController.currentUser);
            rotate(x);
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
