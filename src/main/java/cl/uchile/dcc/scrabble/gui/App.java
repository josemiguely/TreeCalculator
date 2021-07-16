package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Hola.fxml"));

        //primaryStage.setScene(new Scene(root, 300, 275));
        stage.setScene(new Scene(root,300,275));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}