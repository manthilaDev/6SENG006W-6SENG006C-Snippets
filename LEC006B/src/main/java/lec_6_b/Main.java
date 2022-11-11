package lec_6_b;


public class Main {
    public static void main(String[] args) {
        MailBox  singleSlotMailBox= new SingleSlotMailBox();
        MailBox multiSlotMailBox = new MultiSlotMailBox();

        Thread producer1 = new Producer("Producer 1",singleSlotMailBox);
        Thread consumer1 = new Consumer("consumer 1",singleSlotMailBox);
        Thread producer2 = new Producer("Producer 2",multiSlotMailBox);
        Thread consumer2 = new Consumer("consumer 2",multiSlotMailBox);
        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();

    }
}
