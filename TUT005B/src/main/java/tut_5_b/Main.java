package tut_5_b;

public class Main {
    public static void main(String[] args) {

        IMailBox multiSlotMailBox = new MultiSlotMailBox();
        Thread consumer = new Consumer("Consumer",multiSlotMailBox);
        Thread producer = new Producer("Producer",multiSlotMailBox);

        consumer.start();
        producer.start();

    }
}
