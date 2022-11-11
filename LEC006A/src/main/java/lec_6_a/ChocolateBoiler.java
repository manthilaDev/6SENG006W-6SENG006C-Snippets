package lec_6_a;

public class ChocolateBoiler {

    //Non lazy initialization;
    //private static ChocolateBoiler instance = new ChocolateBoiler();

    // Lazy Initialization
    private static ChocolateBoiler instance;
    private String status;

    private ChocolateBoiler(){}
    // Example for thread synchronized
    // Synchronized method
//    public static synchronized ChocolateBoiler getInstance(){
//        if (instance == null){
//            instance = new ChocolateBoiler();
//        }
//        return instance;
//    }

    public static ChocolateBoiler getInstance()
    {
        if (instance == null)
        {
            // Synchronized block
            synchronized(ChocolateBoiler.class)
            {
                if (instance == null)
                {
                    // Important
                    // Double check to ensure instance is empty
                    instance = new ChocolateBoiler();
                    instance.status = "Initiated";
                }
            }
        }
        return instance;
    }


    //Functional methods are added below
        public String getStatus()
        {
            return status;
        }
    //    public static void boil(){}




}
