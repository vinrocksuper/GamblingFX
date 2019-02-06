package Controllers;

import Dependencies.Games.Crash;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import sun.rmi.runtime.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for the Crash Game Scene.
 * TO DO - Multi Colored Circles, PlayerList, Update player balance.
 * @Authors Afaq Anwar & Wai Hin Leung
 * @Version 02/06/2019
 */
public class CrashGameController {
    @FXML private Pane pane;
    @FXML private Circle circle;
    @FXML private VBox playerList;
    @FXML private JFXTextField amountField;
    @FXML private JFXButton playButton;
    @FXML private JFXButton clearButton;
    @FXML private StackPane stackPane;
    @FXML private Label timer;
    @FXML private Label textMultiplier;

    private Crash crashGame;

    /**
     * Runs on Scene load.
     */
    public void initialize() {
        crashGame = new Crash();
        crashGame.addCurrentPlayer(LoginController.currentUser);
        this.startPregameTimer();
    }

    /**
     * Initializes the 10 second timer before the Crash game starts.
     */
    private void startPregameTimer() {
        Timer pregameTimer = new Timer();
        TimerTask countdown = new TimerTask() {
            int currSeconds = 10;
            @Override
            public void run() {
                if (currSeconds > 0) {
                    Platform.runLater(() -> timer.setText("Starting in: " + currSeconds + " Seconds"));
                    currSeconds--;
                } else {
                    Platform.runLater(() -> disableControls(false));
                    Platform.runLater(() -> timer.setVisible(false));
                    Platform.runLater(() -> disableFunctionalControls(true));
                    Platform.runLater(() -> animateGame());
                    this.cancel();
                }
            }
        };
        pregameTimer.schedule(countdown, 1000, 1000);
    }

    /**
     * Animates the game using critical functions.
     */
    private void animateGame() {
        AnimationTimer gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (crashGame.isGameRunning()) {
                    crashGame.setCurrentMultiplier(crashGame.getCurrentMultiplier() + ((crashGame.getBustingMultiplier() / 5.7) * 0.01));
                    crashGame.updatePlayerMultipliers();
                    textMultiplier.setText(Double.toString((double) Math.round(crashGame.getCurrentMultiplier() * 100) / 100));
                    circle.setRadius(circle.getRadius() + 0.1);
                } else {
                    this.stop();
                }
            }
        };
        gameTimer.start();
    }

    /**
     * Button Handler.
     * @param actionEvent Any ActionEvent.
     */
    @FXML
    private void handleButtons(ActionEvent actionEvent) {
        if (actionEvent.getSource() == playButton && crashGame.userManager.getStatusOfUser(LoginController.currentUser).equals("Playing") && crashGame.isGameRunning()) {
            crashGame.userManager.setStatusOfUser(LoginController.currentUser, "Won");
            this.displayWinningAlert();
            playButton.setText("Play");
        } else if (actionEvent.getSource() == playButton) {
            if (validateBet()) {
                crashGame.userManager.setStatusOfUser(LoginController.currentUser, "Playing");
                crashGame.placeBet(Integer.parseInt(amountField.getText()), LoginController.currentUser);
                playButton.setText("Withdraw");
                this.disableControls(true);
            } else {
                this.displayAlert();
            }
        }
        if (actionEvent.getSource() == clearButton) {
            amountField.clear();
        }
    }

    /**
     * Makes sure the betting amount entered is a whole number that is less than 1,000,000,000.
     * @return True if it meets the requirements, false otherwise.
     */
    private boolean validateBet() {
      return (amountField.getText().length() < 10 && amountField.getText().length() > 0 && crashGame.userManager.validateAmount(LoginController.currentUser, Integer.parseInt(amountField.getText())));
    }



    /**
     * Displays alerts based on the user error.
     */
    private void displayAlert() {
        if (amountField.getText().matches("[^0-9]")) {
            JFXDialog dialog = new JFXDialog();
            dialog.setContent(new Label("Bets can be whole numbers only!"));
            dialog.show(stackPane);
        } else if (amountField.getText().length() > 10) {
            JFXDialog dialog = new JFXDialog();
            dialog.setContent(new Label("Cannot place a bet over 1,000,000,000!"));
            dialog.show(stackPane);
        } else if (amountField.getText().length() == 0) {
            JFXDialog dialog = new JFXDialog();
            dialog.setContent(new Label("Please place a valid bet amount."));
            dialog.show(stackPane);
        } else if (crashGame.userManager.validateAmount(LoginController.currentUser, Integer.parseInt(amountField.getText()))) {
            JFXDialog dialog = new JFXDialog();
            dialog.setContent(new Label("Insufficient Funds!"));
            dialog.show(stackPane);
        }
    }

    private void displayWinningAlert() {
        JFXDialog dialog = new JFXDialog();
        dialog.setContent(new Label("You have won " + Math.floor(crashGame.getPlayerBet(LoginController.currentUser) * crashGame.getPlayerMultiplier(LoginController.currentUser))));
        dialog.show(stackPane);
    }


    private void disableFunctionalControls(boolean bool) {
        amountField.setDisable(true);
        clearButton.setDisable(bool);
    }

    private void disableControls(boolean bool) {
        playButton.setDisable(bool);
        clearButton.setDisable(bool);
        amountField.setDisable(bool);
    }
}
