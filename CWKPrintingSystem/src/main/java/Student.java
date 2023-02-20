/** **************************************************************
 * File:      Student.java
 * Author:    A.M. Walgamage
 * Contents:  6SENG002W CWK.
 * Date:      12/01/23
 * Version:   1.0
 ************************************************************** */
public class Student extends Thread{
    private String studentName;
    private Printer studentPrinter;
    private ThreadGroup studentThreadGroup;
    private Document[] documentArray = new Document[5];

    public Student(String studentName,Printer printer,ThreadGroup threadGroup){
        super(threadGroup,studentName);
        this.studentName = studentName;
        this.studentPrinter = printer;
        this.studentThreadGroup = threadGroup;
    }

    @Override
    public void run(){
        int numberOfPagesPrinted =0;
        String finishedMessage = "%S Finished Printing: %d Documents, %d Pages \n";
        documentArray[0] = new Document(this.studentName,"Document 1",10);
        documentArray[1] = new Document(this.studentName,"Document 2",10);
        documentArray[2] = new Document(this.studentName,"Document 3",10);
        documentArray[3] = new Document(this.studentName,"Document 4",10);
        documentArray[4] = new Document(this.studentName,"Document 5",10);

        for(Document doc : documentArray){
            try{
                studentPrinter.printDocument(doc);
                numberOfPagesPrinted++;
                /*Student Thread will go into sleep random amount of time*/
                int randomNumberOfSeconds = ((int)(Math.random()*100));
                Thread.sleep(randomNumberOfSeconds);
            }catch (InterruptedException ex){
                System.out.println("Student Printing Process was Interrupted !");
            }
        }
        System.out.printf(finishedMessage,Thread.currentThread().getName(),documentArray.length,numberOfPagesPrinted);

    }



}
