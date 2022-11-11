package lec_6_b;

public class Consumer extends Thread{

    private MailBox mailBox;

    public Consumer(String name,MailBox mailBox){
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run(){
        for (int i=0; i<=20;i++){
            mailBox.get();
            System.out.println(Thread.currentThread().getName()+" Consumes : "+ i);
        }
    }

}
