package tut_a;
public class SimpleThread extends Thread{
    final int OneSecond = 1000;

    public SimpleThread(String str){
        super(str);
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(getName()+ ": "+ i);
            try{
                sleep((int) (Math.random()*OneSecond));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(getName() + ": Termination");
    }
}
