package hw13;

import java.util.ArrayList;
import java.util.Random;

public class Producer implements Runnable {
    Random random = new Random();
    final int maxSize, maxDelay;
    int product;
    final ArrayList<Integer> list;

    public Producer(ArrayList<Integer> list, int maxDelay, int maxSize) {
        this.list = list;
        this.maxSize = maxSize;
        this.maxDelay = maxDelay;
    }

    public void produce() {
        synchronized (list) {
            while (list.size() >= 5) {
                System.out.println("Список переполнен: " + maxSize);
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product = random.nextInt(10);

            System.out.println("Произведено: " + product);
            list.add(product);
            System.out.println("Полный список: " + list);
            list.notifyAll();
        }
    }

    @Override
    public void run() {
        System.out.println("Производитель начинает работу");
        while (true) {
            produce();
            try {
                int delay = random.nextInt(maxDelay);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
