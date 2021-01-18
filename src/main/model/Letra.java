package main.model;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

public class Letra extends Observable implements Runnable {
    private char letra;

    public Letra(char letra, Observer objeto){
        addObserver(objeto);
        this.letra = letra;
    }
    @Override
    public void run() {
        while (true) {
            setChanged();
            notifyObservers(String.valueOf(letra));
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(900) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
