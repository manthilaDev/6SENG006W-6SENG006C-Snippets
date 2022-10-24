package lec_2_a;
public class BackAccount {
    private String accountNo;
    private double accountBalance;

    public BackAccount(String accountNo,double accountBalance){
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }
    public synchronized double deposit(double amount){
        while(this.accountBalance >= 10000){
            try{
            wait();
        }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.accountBalance+= amount;
        System.out.println(Thread.currentThread().getName()+" balance after performing deposit "+ this.accountBalance);
        notifyAll();
        return  this.accountBalance;
    }
    public synchronized double withdraw(double amount){
        while(this.accountBalance < 1000){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if (this.accountBalance >= amount){
            this.accountBalance-= amount;
        }else{
            throw new IllegalArgumentException("Insufficient Balance");
        }
        System.out.println(Thread.currentThread().getName()+" balance after performing withdraw "+ this.accountBalance);
        notifyAll();
        return this.accountBalance;
    }
    public synchronized double getAccountBalance() {
        return this.accountBalance;
    }
    public String getAccountNo(){
        return  this.accountNo;
    }

}
