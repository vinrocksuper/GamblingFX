package Controllers;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.io.IOException;

/**
 * Controller for the Main Dashboard.
 * @Author Afaq Anwar
 * @Version 02/07/2019
 */
public class DashboardController {
    @FXML JFXTabPane tabPane;

    /**
     * Runs on Scene load.
     */
    public void initialize() throws IOException {
        this.buildTabs();
    }

    /**
     * Builds all required tabs, and adds them to the main Tab Pane.
     */
    private void buildTabs() throws IOException {
        Tab jackpotTab = new Tab("Jackpot");
        tabPane.getTabs().add(jackpotTab);
        jackpotTab.setContent(FXMLLoader.load(getClass().getResource("/Resources/FXML/JackpotGame.fxml")));
        Tab rouletteTab = new Tab("Roulette");
        tabPane.getTabs().add(rouletteTab);
        rouletteTab.setContent(FXMLLoader.load(getClass().getResource("/Resources/FXML/RouletteGame.fxml")));
        Tab crashTab = new Tab("Crash");
        crashTab.setContent(FXMLLoader.load(getClass().getResource("/Resources/FXML/CrashGame.fxml")));
        tabPane.getTabs().add(crashTab);
        Tab coinflipTab = new Tab("Coin Flip");
        tabPane.getTabs().add(coinflipTab);
        coinflipTab.setContent(FXMLLoader.load(getClass().getResource("/Resources/FXML/CoinflipGame.fxml")));
    }
}
