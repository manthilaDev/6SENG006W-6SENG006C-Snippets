/** **************************************************************
 * File:      PrintingSystem.java
 * Author:    A.M. Walgamage
 * Contents:  6SENG002W CWK.
 * Date:      12/01/23
 * Version:   1.0
 ************************************************************** */
public class PrintingSystem {
    public static void main(String[] args) {
        System.out.println("[Printing System] - Staring");
        LaserPrinter printer = new LaserPrinter("24","Ip-CG",250,500);
        System.out.println("[Printing System] - Initialized Laser Printer");
        ThreadGroup studentThreadGroup = new ThreadGroup("Student Thread Group");
        ThreadGroup technicianThreadGroup = new ThreadGroup("Technician Thread Group");
        System.out.println("[Printing System] - Initialized Following Thread Groups: "+ studentThreadGroup.getName()+","
                +technicianThreadGroup.getName());
        Student studentOne = new Student("Student-01",printer,studentThreadGroup);
        Student studentTwo = new Student("Student-02",printer,studentThreadGroup);
        Student studentThree = new Student("Student-03",printer,studentThreadGroup);
        Student studentFour = new Student("Student-04",printer,studentThreadGroup);
        TonerTechnician tonerTechnician = new TonerTechnician("Toner Technician",technicianThreadGroup,printer);
        PaperTechnician paperTechnician = new PaperTechnician("Paper Technician",technicianThreadGroup,printer);
        System.out.println("[Printing System] - Initialized 4 Student Threads & 2 Technician Threads");
        System.out.println("[Printing System] - Starting Services.....");
        studentOne.start();
        studentTwo.start();
        studentThree.start();
        studentFour.start();
        tonerTechnician.start();
        paperTechnician.start();


        while(true){
            /*Checking if all threads that belongs to Thread Groups are finished working*/
            if(studentThreadGroup.activeCount() == 0 && technicianThreadGroup.activeCount()== 0){
                System.out.println("Completed Printing Process");
                System.out.println(printer);
                break;
            }
        }



    }
}
