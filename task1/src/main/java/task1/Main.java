package task1;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        DelayedMessagePrinter printer1 = new DelayedMessagePrinter("First message to be logged",
                3000);
        DelayedMessagePrinter printer2 = new DelayedMessagePrinter("Second message to be logged",
                5000);
        printer2.start();
        printer1.start();
    }
}

interface Printer {
//    public String message;
}
class DelayedMessagePrinter extends Thread {
    public String message;
    public int delay;
    DelayedMessagePrinter(String message, int delay){
        this.message = message;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
    }
}

class InterfacedDelayedMessagePrinter implements Runnable {
    String message;
    int delay;

    @Override
    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
    }
}
