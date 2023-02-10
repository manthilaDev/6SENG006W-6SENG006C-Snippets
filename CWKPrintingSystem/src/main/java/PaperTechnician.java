/** **************************************************************
 * File:      PaperTechnician.java
 * Author:    A.M. Walgamage
 * Contents:  6SENG002W CWK.
 * Date:      12/01/23
 * Version:   1.0
 ************************************************************** */
public class PaperTechnician extends Thread{
    private String paperTechnicianName;
    private ThreadGroup paperTechnicianGroup;
    private ServicePrinter paperTechnicianPrinter;

    public PaperTechnician(String paperTechnicianName,ThreadGroup threadGroup,LaserPrinter printer){
        super(threadGroup,paperTechnicianName);
        this.paperTechnicianName = paperTechnicianName;
        this.paperTechnicianGroup = threadGroup;
        this.paperTechnicianPrinter = printer;
    }

    @Override
    public void run(){
        int numberOfAttempts =3;
        int noOfUsedPaperPacks =0;
        for(int i=0;i<numberOfAttempts;i++){
            try{
                paperTechnicianPrinter.refillPaper();
                if(((LaserPrinter)(paperTechnicianPrinter)).isPaperRefilled()){
                    noOfUsedPaperPacks++;
                }
                /*Paper Technician Thread will go into sleep random amount of time*/
                int paperTechnicianWaitTime = (int) (Math.random()*100);
                Thread.sleep(paperTechnicianWaitTime);
            }catch (InterruptedException ex){
                System.out.println("Paper Technician Refill Process Interrupted");
            }
        }


        System.out.printf("Paper Technician Process finished,packs of paper used: %d \n",noOfUsedPaperPacks);

    }


}
