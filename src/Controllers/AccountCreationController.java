package Controllers;

import Dependencies.Systems.CSVReader;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Controller for the Account Creation Scene.
 * @Author Afaq Anwar
 * @Version 01/29/19
 */
public class AccountCreationController {
    @FXML private JFXTextField firstNameField;
    @FXML private JFXTextField lastNameField;
    @FXML private JFXTextField usernameField;
    @FXML private JFXPasswordField passwordField;
    private CSVReader csvReader;
    private PrintWriter writer;
    private StringBuilder stringBuilder;
    private List<String> existingData;

    /**
     * Runs on Scene load.
     * @throws IOException
     */
    public void initialize() throws IOException {
        File protectedData = new File("src/Dependencies/Systems/Data/LoginData.csv");
        csvReader = new CSVReader(protectedData);
        writer = new PrintWriter(protectedData);
        stringBuilder = new StringBuilder();
        existingData = csvReader.getAllData();
    }

    /**
     * Method called on Create Account Button click.
     * Runs helper methods in order to write to the CSV File.
     */
    @FXML
    private void createAccount() {
        this.addCurrentData();
        this.writeToFile();
    }

    /**
     * Adds current data to the existing data, as long as the User does not already exist.
     */
    private void addCurrentData() {
        if (!userExists()) {
            existingData.add(firstNameField.getText() + "," + lastNameField.getText() + "," + usernameField.getText() + "," + passwordField.getText());
        }
    }

    /**
     * Checks if a Username exists within the CSV File.
     * @return True if the Username exists, false otherwise.
     */
    private boolean userExists() {
        String currentUsername = usernameField.getText();
        return csvReader.getDataString(3).contains(currentUsername);
    }

    /**
     *  Overwrite the CSV file with new data.
     *      StringBuilder was used in order to optimize for future MS EXCEL Parsing.
     */
    private void writeToFile() {
        stringBuilder.append("firstname,lastname,username,password");
        stringBuilder.append("\n");
        for (String string : existingData) {
            String[] splitStr = string.split(",");
            for (int i = 0; i < splitStr.length; i++) {
                if (i == splitStr.length - 1) {
                    stringBuilder.append(splitStr[i]);
                } else {
                    stringBuilder.append(splitStr[i]);
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\n");
        }
        writer.write(stringBuilder.toString());
        writer.close();
    }
}
