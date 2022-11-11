package tut_5_a;

public class Main {
    public static void main(String[] args) {

        MailBox mailBox = new MailBox();
        Thread consumer = new Consumer("Consumer",mailBox);
        Thread producer = new Producer("Producer",mailBox);

        consumer.start();
        producer.start();

    }
}
