package lec_6_b;

public class SingleSlotMailBox implements MailBox<Integer>{

    private int number;
    private boolean available =false;

    @Override
    public synchronized void put(Integer number)
    {
        while(available){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        available = true;
        this.number = number;
        notifyAll();
    }

    @Override
    public synchronized Integer get()
    {
        while (!available){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        available =false;
        notifyAll();
        return this.number;
    }
}
