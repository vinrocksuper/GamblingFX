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
        // Font loading, due to JavaFX 2.2 not being able to call fonts directly through the CSS File.
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/SpaceMono-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/SpaceMono-BoldItalic.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/SpaceMono-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Black.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-ExtraBold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-ExtraLight.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Light.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Medium.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-SemiBold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Resources/Fonts/WorkSans-Thin.ttf"), 10);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 600, 400));

        // Removes the borders and generic bar above the window.
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
