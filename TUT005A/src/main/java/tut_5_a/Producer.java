package tut_5_a;

public class Producer extends Thread{
    private MailBox mailBox;

    public Producer(String name,MailBox mailBox) {
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run(){
        for(int i=0; i<10;i++){
            mailBox.put(i);
            System.out.println("Producer "+ Thread.currentThread().getName()+" "+ i);
        }
    }

}
