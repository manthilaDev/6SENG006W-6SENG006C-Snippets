package lec_2_b;
public class HouseBasedHusband extends Thread{

    private BackAccount account;

    public HouseBasedHusband(BackAccount account,String name){
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        double withdrawAmount = 10000;
        try{
            for(int i= 0; i<=10;i++){
                //System.out.println(this.name+" Account Balance after performing withdraw operation "+this.account.withdraw(withdrawAmount));
                this.account.withdraw(withdrawAmount);
                //Thread.sleep(100);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
