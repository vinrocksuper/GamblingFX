package Controllers;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

/**
 * Controller for the Main Dashboard.
 * @Author Afaq Anwar
 * @Version 01/30/19
 */
public class DashboardController {
    @FXML JFXTabPane tabPane;

    /**
     * Runs on Scene load.
     */
    public void initialize() {
        this.buildTabs();
    }

    /**
     * Builds all required tabs, and adds them to the main Tab Pane.
     */
    private void buildTabs() {
        Tab jackpotTab = new Tab("Jackpot");
        tabPane.getTabs().add(jackpotTab);
        Tab rouletteTab = new Tab("Roulette");
        tabPane.getTabs().add(rouletteTab);
        Tab crashTab = new Tab("Crash");
        tabPane.getTabs().add(crashTab);
        Tab coinflipTab = new Tab("Coin Flip");
        tabPane.getTabs().add(coinflipTab);
    }
}
