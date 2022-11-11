package tut_5_b;

public class Producer extends Thread{
    private IMailBox<String> mailBox;

    public Producer(String name,IMailBox mailBox) {
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run(){
        for(int i=0; i<10;i++){
            mailBox.put(Integer.toString(i));
            System.out.println("Producer "+ Thread.currentThread().getName()+" "+ i);
        }
    }

}
