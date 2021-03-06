package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/root.fxml"));
        primaryStage.setTitle("App-Sincronización");
        System.out.println("Main 2:" + Thread.currentThread().getName());
        Scene scene = new Scene(root);
        scene.setOnMouseClicked(event -> {
            System.out.println(event.getScreenX());
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        System.out.println("Main 1:" + Thread.currentThread().getName());
        launch(args);
    }
}
