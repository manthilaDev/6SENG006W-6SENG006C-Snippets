package tut_5_a;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MailBox {
    private int num;
    private boolean availableBool = false;

    ReentrantLock lock = new ReentrantLock(true);
    Condition available = lock.newCondition();
    Condition unavailable = lock.newCondition();

    public void put(int num)
    {
        lock.lock();
        while(availableBool){
            try {
                available.await();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        this.num = num;
        availableBool =true;
        unavailable.signalAll();
        lock.unlock();
    }
    public int get()
    {
        try
        {
            lock.lock();
            while(!availableBool)
            {
                try {
                    unavailable.await();
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
                availableBool =false;
                return num;
        }
        finally
        {
            lock.unlock();
        }

    }

}
