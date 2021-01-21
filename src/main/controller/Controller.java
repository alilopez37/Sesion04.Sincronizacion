package main.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
import main.model.Letra;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnSalir;

    @FXML
    private Line barra;


    @FXML
    void btnIniciarOnMouseClicked(MouseEvent event) {
        new Thread(new Letra('C',this)).start();
        new Thread(new Letra('B',this)).start();
        new Thread(new Letra('A',this)).start();
    }

    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        System.out.println("Controller:" + Thread.currentThread().getName());
        switch((String)arg){
            case "A":
                barra.setLayoutX(110);
                break;
            case "B":
                barra.setLayoutX(215);
                break;
            case "C":
                barra.setLayoutX(315);
                break;
        }
        try {
            Thread.sleep(200);
            System.out.println("Con 2:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        System.out.println(Runtime.version());
        System.out.println(System.getProperty("java.version"));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
