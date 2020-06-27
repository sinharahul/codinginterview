package simple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class ShittyProducerConsumer {
    public static void main(String[] args) {
        launch();
    }

    static void launch() {
        Queue<Integer> queue = new LinkedList<>();
        Runnable producer = () -> {
            while (true) {

                for (int i = 0; i < 100; i++) {
                    queue.add(i);
                }
            }
        };
        new Thread(producer).start();
        Runnable consumer = () -> {
            while (true) {

                System.out.println("Reading ..."+ queue.poll());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();

    }
}
