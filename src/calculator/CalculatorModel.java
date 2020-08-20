package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorModel extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calculatorView.fxml"));
        Scene scene = new Scene(root, 500, 640);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("calculatorLayout.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
