package lec_4_a;

class Runner extends Thread {
    public volatile boolean terminate = false;
    public  int tick =1;

    public Runner( int id )
    {
        super( "Runner" + id ) ;
    }

    @Override
    public void run()
    {
        while ( tick < 400000 && !terminate )
        {
            tick++ ;
        }
    }

}
