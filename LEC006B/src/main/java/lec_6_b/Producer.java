package lec_6_b;

public class Producer extends Thread{
    private MailBox  mailBox;

    public  Producer(String name,MailBox mailBox){
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run(){
        for(int i=0;i<=20;i++){
            if (mailBox instanceof SingleSlotMailBox){
                mailBox.put(i);
                System.out.println(Thread.currentThread().getName()+" Produces : "+ i);
                continue;
            }
            mailBox.put(Integer.toString(i));
            System.out.println(Thread.currentThread().getName()+" Produces : "+ i);
        }

    }


}
