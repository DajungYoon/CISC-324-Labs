/*
Dajung Yoon
Lab 3
Student #:20206993
*/

// This file defines class "writer".

// This code uses
//      class Semaphore, from the java.util.concurrent package in Java 5.0 which defines the behaviour of a 
//                           semaphore, including acquire and release operations.
//      class Synch, which defines the semaphores and variables
//                   needed for synchronizing the readers and writers.
//      class RandomSleep, which defines the doSleep method.


public class Writer extends Thread {
  int myName;  // The variable myName stores the name of this thread.
               // It is initialized in the constructor for class Reader.

  RandomSleep rSleep;  // rSleep can hold an instance of class RandomSleep.



  // This is the constructor for class Writer.  It has an integer parameter,
  // which is the name that is given to this thread.
  public Writer(int name) 
  {
    myName = name;  // copy the parameter value to local variable "MyName"
    rSleep = new RandomSleep();   // Create and instance of RandomSleep.
  }  // end of the constructor for class "Writer"

  public void run () 
  {
    for (int I = 0;  I < 2; I++) {
      // Get permission to write
      System.out.println("Writer " + myName + " wants to write");
      try{
            Synch.mutex.acquire();
      }
      catch(Exception e){}
      // Simulate the time taken by writing.
      System.out.println("Writer " + myName + " is now writing");
      rSleep.doSleep(1, 200);
      
      // We're done writing.  Signal the mutex semaphore.  If a Reader thread
      // was waiting on mutex, that reader starts, and allows other waiting
      // readers (who are waiting on "mutex") to start as well.  If a Writer
      // thread was waiting on mutex, then that writer goes next.  If no one
      // was waiting on wrt, then mutex has the value 1, so the next future
      // reader or writer can go without waiting.

      if (Synch.activeReader + Synch.activeWriter >0) {
            Synch.waitingWriter++;
      }
      else {
    	      Synch.writeQueue.release();
    	      Synch.activeWriter++;
      }
      
      //release because it is done going through the access of the variables
      Synch.mutex.release();
 
      //if there is one left, its takes it and start writing
      try{
      	Synch.writeQueue.acquire();
      }
      //if noting is left throw an exception
      catch(Exception e){}
      

      //else, start writing

      // Simulate the time taken by writing.
      System.out.println("Writer " + myName + " is now writing");
      rSleep.doSleep(1, 200);

     //test if a writer is writing, if yes, release the head in writeQueue
     //else release all of the readers
      try
      {
      	Synch.mutex.acquire();
      }
      catch(Exception e){}

      //decrement the writers, they are done
      Synch.activeWriter--;
 
      //check if there are any writers waiting  
      if (Synch.waitingWriter>0) 
      {
            //if yes, release one writer
            Synch.writeQueue.release();
            Synch.activeWriter++;

            //the writers are done
            Synch.waitingWriter--;
      }
      //if readers are waiting
      else if (Synch.waitingReader>0)
      {
    	do {
    		//writers release 
            Synch.readQueue.release();
            Synch.activeReader++;

            //the readers are done
            Synch.waitingReader--;
    		  	
    	  } while(Synch.waitingReader>0);
 
      }
 
     System.out.println("Writer " + myName + " is finished writing");
     Synch.mutex.release();
      
      // Simulate "doing something else"
      rSleep.doSleep(1, 1000);
    } // end of "for" loop
  }  // end of "run" method
}  // end of class "Writer"