package main.model;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Letra extends Observable implements Runnable {
    private char letra;
    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore semC = new Semaphore(0);

    public Letra(char letra, Observer objeto){
        addObserver(objeto);
        this.letra = letra;
    }
    @Override
    public void run() {

        while (true) {
            switch(letra){
                case 'A':
                    try {
                        semA.acquire();
                        System.out.println("A" + Thread.currentThread().getName());
                        setChanged();
                        notifyObservers(String.valueOf(letra));
                        semB.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                case 'B':
                    try {
                        semB.acquire();
                        System.out.println("B");
                        setChanged();
                        notifyObservers(String.valueOf(letra));
                        semC.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                case 'C':
                    try {
                        semC.acquire();
                        System.out.println("C");
                        setChanged();
                        notifyObservers(String.valueOf(letra));
                        semA.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
            }

            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(900) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
