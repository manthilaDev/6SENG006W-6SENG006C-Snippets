package lec_6_b;

import java.util.LinkedList;
import java.util.Queue;

public class MultiSlotMailBox implements MailBox<String>{

    private Queue<String> slotList = new LinkedList<>();
    private final int MAX_SIZE = 10;

    private  boolean isFull(){  return slotList.size() == MAX_SIZE;}

    @Override
    public synchronized void put(String number) {
        while (isFull()){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        slotList.add(number);
        notifyAll();
    }

    @Override
    public synchronized String get() {
        while (slotList.isEmpty()){
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        notifyAll();
        return slotList.poll();
    }
}
