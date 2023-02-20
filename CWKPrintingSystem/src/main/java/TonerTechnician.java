/** **************************************************************
 * File:      TonerTechnician.java
 * Author:    A.M. Walgamage
 * Contents:  6SENG002W CWK.
 * Date:      12/01/23
 * Version:   1.0
 ************************************************************** */
public class TonerTechnician extends Thread{

    private String tonerTechnicianName;
    private ThreadGroup tonerTechnicianGroup;
    private ServicePrinter tonerTechnicianPrinter;

    public TonerTechnician(String tonerTechnicianName,ThreadGroup group,ServicePrinter printer){
        super(group,tonerTechnicianName);
        this.tonerTechnicianName = tonerTechnicianName;
        this.tonerTechnicianGroup = group;
        this.tonerTechnicianPrinter = printer;
    }

    @Override
    public void run()
    {
        int noOfAttempts = 3;
        int noOfCartridges =0;
        for(int i=0;i<noOfAttempts;i++){
            try{
                tonerTechnicianPrinter.replaceTonerCartridge();
                if(((LaserPrinter)tonerTechnicianPrinter).isTonerRefilled()){
                    noOfCartridges++;
                }
                /*Toner Technician Thread will go into sleep random amount of time*/
                int tonerTechnicianWaitTime = (int)(Math.random()*100);
                Thread.sleep(tonerTechnicianWaitTime);
            }catch (InterruptedException ex){
                System.out.println("Toner Technician replace toner Interrupted ");
            }
        }


        System.out.printf("Toner Technician finished, cartridges replaced: %d \n",noOfCartridges);
    }


}
