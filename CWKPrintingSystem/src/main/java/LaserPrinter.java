/** **************************************************************
 * File:      LaserPrinter.java
 * Author:    A.M. Walgamage
 * Contents:  6SENG002W CWK.
 * Date:      12/01/23
 * Version:   1.0
 ************************************************************** */
public class LaserPrinter implements ServicePrinter {
    private String printerId;
    private String printerName;
    private int printerPaperLvl;
    private int printerTonerLvl;
    private int noOfDocumentsPrinted;
    private boolean isPaperRefilled = false;
    private boolean isTonerRefilled = false;

    /*Single Constructor
    * Respects given Parameters and Resource Limits (toner lvl, paper lvl)
    * Maintains Printer Details
    * */
    public LaserPrinter(String printerId,String printerName,int printerPaperLvl,
                        int printerTonerLvl){
        if(printerPaperLvl > Full_Paper_Tray){
            throw new IllegalArgumentException("Invalid Printer Paper Level: Paper Tray can hold maximum "+Full_Paper_Tray);
        }
        if(printerPaperLvl <0){
            throw new IllegalArgumentException("Invalid Printer Paper Level: Cannot be less than Zero");
        }
        if(printerTonerLvl > Full_Toner_Level){
            throw new IllegalArgumentException("Invalid Printer Toner Level: Cannot exceed max toner level "+Full_Toner_Level);
        }
        if(printerTonerLvl < 0){
            throw new IllegalArgumentException("Invalid Printer Toner Level: Cannot be less than Zero");
        }
        this.printerId = printerId;
        this.printerName = printerName;
        this.printerPaperLvl = printerPaperLvl;
        this.printerTonerLvl = printerTonerLvl;
        this.noOfDocumentsPrinted = 0;

    }
    /* stringify Printer data*/
    @Override
    public String toString() {
        String details = "[PrinterID: %S, Paper Level: %d, Toner Level: %d, Documents Printed: %d]";
        return String.format(details,this.printerName+"."+this.printerId,this.printerPaperLvl,this.printerTonerLvl
                ,this.noOfDocumentsPrinted);
    }

    /*Flag checker to keep track paper Refill events*/
    public boolean isPaperRefilled(){
        return isPaperRefilled;
    }
    /*Flag checker to keep track toner Refill events*/
    public  boolean isTonerRefilled(){
        return  isTonerRefilled;
    }

    /*Facilitates Print Document operation
    * takes into account the available toner and paper levels before proceeding
    * Synchronized to facilitate mutual exclusiveness
    * Updates State upon completion
    * */
    @Override
    public synchronized void printDocument(Document document) {
        while(this.printerPaperLvl < document.getNumberOfPages() || this.printerTonerLvl < document.getNumberOfPages()){
            if(this.printerPaperLvl < document.getNumberOfPages()){
                System.out.println("Paper Level at "+ this.printerPaperLvl+" Requires Paper Refill to Continue");
            }
            if (this.printerTonerLvl <document.getNumberOfPages()){
                System.out.println("Toner Level at "+ this.printerTonerLvl+" Requires Toner Replacement to Continue");
            }
            try{
                wait();
            }catch (InterruptedException exception){
                System.out.println("Print Document Interfered");
            }
        }

        this.printerTonerLvl= this.printerTonerLvl -document.getNumberOfPages();
        this.printerPaperLvl = this.printerPaperLvl -document.getNumberOfPages();
        this.noOfDocumentsPrinted++;
        System.out.printf("Requested Print Job Produced Document %S for %S \n",document.getDocumentName(),Thread.currentThread().getName());
        notifyAll();
    }

    /*Facilitates replace toner operation
     * takes into account the available toner levels before proceeding
     * Synchronized to facilitate mutual exclusiveness
     * Updates State upon completion
     * Updates Flags status flags
     * */
    @Override
    public synchronized void replaceTonerCartridge() {
        isTonerRefilled = false;
        boolean attempted = false; // to keep track of attempts
        while(this.printerTonerLvl >= Minimum_Toner_Level){
            if(attempted){
                break;
            }
            try{
                wait(5000); // Toner Technician waits 5 secs before attempting
            }catch (InterruptedException ex){
                System.out.println("Laser Printer replace Toner Cartridge Service Interrupted");
            }
            attempted = true;
        }

        if(this.printerTonerLvl < Minimum_Toner_Level){
            this.printerTonerLvl = Full_Toner_Level;
            isTonerRefilled = true;
        }
        notifyAll();

    }
    /*Facilitates replace paper operation
     * takes into account the available paper levels before proceeding
     * Synchronized to facilitate mutual exclusiveness
     * Updates State upon completion
     * Updates Flags status flags
     * */
    @Override
    public synchronized void refillPaper() {
        isPaperRefilled = false;
        boolean attempted = false; // to keep track of attempts
        /*Following condition ensures paper tray will not overflow*/
        while(!(this.printerPaperLvl < (Full_Paper_Tray - SheetsPerPack))){
            if(attempted){
                break;
            }
            try{
                wait(5000); // Paper Technician waits 5 secs before attempting
            }catch (InterruptedException ex){
                System.out.println("Laser Printer refill paper Service Interrupted");
            }
            attempted = true;
        }
        if (this.printerPaperLvl < (Full_Paper_Tray - SheetsPerPack)){
            this.printerPaperLvl += SheetsPerPack;
            isPaperRefilled =true;
        }
        notifyAll();

    }
}
