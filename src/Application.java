import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Application extends javafx.application.Application {
    /**
     * Sets up the first Scene of the Application.
     * @param primaryStage The main Stage.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Resources/FXML/Login.fxml"));
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/PT_Sans-Web-Regular.ttf"), 10);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
