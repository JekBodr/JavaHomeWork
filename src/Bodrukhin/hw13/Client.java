package hw13;

import java.util.ArrayList;
import java.util.Random;

public class Client implements Runnable {
    Random random = new Random();
    final int maxDelay;
    final ArrayList<Integer> list;

    public Client(ArrayList<Integer> list, int maxDelay) {
        this.list = list;
        this.maxDelay = maxDelay;
    }

    public void consume() {
        synchronized (list) {
            while (list.isEmpty()) {
                System.out.println("Список пуст!");
                try {
                    System.out.println("Ожидание потрибителя");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer firstElement = list.get(0);
            System.out.println("Потреблено: " + firstElement);
            list.remove(firstElement);
            System.out.println("Полный список: " + list);
            list.notifyAll();
        }
    }

    @Override
    public void run() {
        System.out.println("Потребитель начал работу");
        while (true) {
            consume();
            try {
                int delay = random.nextInt(maxDelay);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
