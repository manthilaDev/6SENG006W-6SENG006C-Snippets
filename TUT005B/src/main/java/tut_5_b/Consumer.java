package tut_5_b;

public class Consumer extends Thread{
    private IMailBox<String> mailBox;

    public Consumer(String name,IMailBox<String> mailBox){
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run(){
        for(int i=0; i<10;i++){
            String val = mailBox.get();
            System.out.println("Consumer "+ Thread.currentThread().getName()+" "+val);
        }
    }
}
