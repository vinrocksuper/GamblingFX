package Controllers;

import Dependencies.Systems.CSVReader;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Controller for the Login Scene.
 * @Author Afaq Anwar
 * @Version 01/30/19
 */
public class LoginController {
    @FXML private Pane pane;
    @FXML private JFXTextField usernameField;
    @FXML private JFXPasswordField passwordField;
    @FXML private StackPane stackPane;
    private CSVReader csvReader;

    /**
     * Runs on Scene load.
     */
    public void initialize() {
        File protectedData = new File("src/Dependencies/Systems/Data/LoginData.csv");
        csvReader = new CSVReader(protectedData);
    }

    /**
     * Method called on the Login Button click.
     * Checks if the current combination of the username and password exist and are correct.
     * @throws IOException
     */
    @FXML
    private void checkLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (csvReader.getDataString(3).contains(username)) {
            String correctUserPassword = csvReader.getDataString(4).get(csvReader.getDataString(3).indexOf(username));
            if (password.equals(correctUserPassword)) {
                this.allowEntry();
            } else {
                JFXDialog dialog = new JFXDialog();
                dialog.setContent(new Label("Error Incorrect Password!"));
                dialog.show(stackPane);
            }
        } else {
            JFXDialog dialog = new JFXDialog();
            dialog.setContent(new Label("Error Username Does Not Exist!"));
            dialog.show(stackPane);
        }
    }

    private void allowEntry() throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/Resources/FXML/Dashboard.fxml"));
        Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.setScene(new Scene(newRoot, 800, 600));
        currentStage.getScene().setFill(Color.TRANSPARENT);
    }

    /**
     * Method called on Create Account Button click.
     * Switches to the Account Creation Scene.
     * @throws IOException
     */
    @FXML
    private void allowAccountCreation() throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/Resources/FXML/AccountCreation.fxml"));
        Stage currentStage = (Stage) pane.getScene().getWindow();
        currentStage.setScene(new Scene(newRoot, 600, 400));
        currentStage.getScene().setFill(Color.TRANSPARENT);
    }
}
