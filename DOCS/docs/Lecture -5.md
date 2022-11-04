## Thread Scheduling and Thread Group

- [Geek for Geeks Reference](https://www.geeksforgeeks.org/fixed-priority-pre-emptive-scheduling/)

> setPriority() method is used to give priority to the thread.

**By default, thread will have a priority value of *5*

- Similar priority thread will share resources following round-robin mechanism.

> yield() will make the current thread give up

- Even with priority set place order in which the thread will execute is *nondeterministic*. 


> `Java Scheduling Rule`  
	At any given time, the highest priority runnable thread is running.
	**Unfortunately this cannot be always ensured. 


