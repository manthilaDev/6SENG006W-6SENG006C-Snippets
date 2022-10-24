Discussing more on Java thread in detail. 

 1. New
 2. Runnable 
 3. Blocked
 4. Waiting 
 5.  Waited/ Time
 6.  Terminated

* An Inital Thread object is created.  
* And thread is at the New state of Thread Cycle  

> Thread th1 = new Thread(new MyThread(),"Thread 01");

 - Initiating the thread into runnable state
 
> th1.start()

- Once the start method is called, thread will be got two options

	- Ready
	- Running 
- When the thread gets allocated, the time to perform it will move into **running state.**
- If the thread is interrupted or sleep it will move into the **ready state**
- Once the *run()* completes the execution it will reach the **Terminated**
> Thread.sleep(100)
- Sleep method will bring a running thread into **Waited Time** State. 
- While thread is sleeping, if an interruption made it will move back into ready state.
- 
> th1.join()
- Calling join() will put all the other thread into timed waiting state

# Why use a while method ?

To ensure the reentrant point is validated. 

> while(this.accountBalance < 1000){  
    try{  
        wait();  
    }catch (InterruptedException e){  
        e.printStackTrace();  
    }  
}