package tut_5_b;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiSlotMailBox implements IMailBox<String>{

    private Queue<String> slotList = new LinkedList<>();
    private static final int MAX_SIZE = 10;
    private boolean isFull() {return  slotList.size() == MAX_SIZE;}


    ReentrantLock lock = new ReentrantLock(true);
    Condition available = lock.newCondition();
    Condition unavailable = lock.newCondition();

    @Override
    public void put(String value) {
        lock.lock();
        while(isFull()){
            try {
                available.await();
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        slotList.add(value);
        unavailable.signalAll();
        lock.unlock();
    }

    @Override
    public String get() {
        try {
            lock.lock();
            while (slotList.isEmpty()) {
                try {
                    unavailable.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            String lastVal = slotList.poll();
            available.signalAll();
            return lastVal;
        }finally {
            lock.unlock();
        }

    }
}
