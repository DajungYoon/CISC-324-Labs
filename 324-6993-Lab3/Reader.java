/*
Dajung Yoon
Lab 3
Student #:20206993
*/

// This file defines class "Reader".

// This code uses
//      class Semaphore, from the java.util.concurrent package in Java 5.0 which defines the behaviour of a 
//                           semaphore, including acquire and release operations.
//      class Synch, which defines the semaphores and variables 
//                   needed for synchronizing the readers and writers.
//      class RandomSleep, which defines the doSleep method.


public class Reader extends Thread {
  int myName;  // The variable myName stores the name of this thread.
               // It is initialized in the constructor for class Reader.

  RandomSleep rSleep;  // rSleep can hold an instance of class RandomSleep.

  // This is the constructor for class Reader.  It has an integer parameter,
  // which is the name that is given to this thread.
  public Reader(int name) {
    myName = name;  // copy the parameter value to local variable "MyName"
    rSleep = new RandomSleep();  // Create an instance of RandomSleep.
  }  // end of the constructor for class "Reader"

  public void run () {
    for (int I = 0;  I < 2; I++) {
      System.out.println("Reader " + myName + " wants to read.  ");

      //Do acquire on the "mutex" semaphore, to get exclusive access to the
      // variables waitingReader, waitingWriter, activeReader, and activeWriter.
      //Synch.readcount++;
      try{
        Synch.mutex.acquire();
      }
      catch(Exception e){}
        
      // If a writer is active, the first reader waits for "waitingWriter" while still 
      // holding on to  "mutex".  Other readers, who arrive later, will get
      //  held up waiting for "mutex". 
      if (Synch.activeWriter + Synch.waitingWriter>0){
        Synch.waitingReader++;
      }
      else {
      //If no active or waiting writers are there, the reader releases the semaphore.readQueue (produce one marble) and increments the number of active readers
        Synch.readQueue.release();
        Synch.activeReader++;
      }

      //The reader releases the mutex since its has finished manipulating the shared counters AW, WW, and AR.
      Synch.mutex.release();

      //Now the reader tries to grab a marble, if there is one left, its takes it and start reading, if noting is left .readQueue==0) it gets blocked in the.readQueue queue.
      try{
        Synch.readQueue.acquire(); 
      }
      catch(Exception e){}
      
      //If the reader did not get blocked or if it got blocked then released, its starts reading 
      System.out.println("Reader " + myName + " is now reading.  ");
      rSleep.doSleep(1, 200);   

      // We're finished reading.  Decrement readcount.  If we are the last
      // reader, then signal a writer.  The signal to writer will either wake up
      // a waiting writer, or set the semaphore value to 1, so that a future
      // writer or reader can go without waiting.
      try{
        Synch.mutex.acquire();
      }
      catch(Exception e){}
      // Now we have permission to start reading.  
      // Print a message and release mutex.

      //Synch.readcount--;
      //decrements the number of active readers
      Synch.activeReader--;

      System.out.println("Reader " + myName + " is finished reading.  ");

      //check if it is the last active reader and if there is at least one writer waiting in the queue
      if (Synch.activeReader==0 && Synch.waitingWriter>0) {
        //release the semaphore.readQueue
        //one writer is released from the.readQueue queue
        Synch.writeQueue.release();
      //Increments the number of active writers
      //decrements the number of waiting writers 
        Synch.activeReader++;
        Synch.waitingWriter++;
      }

      //finished manipulating the shared counters, so release
      Synch.mutex.release();

      // Simulate "doing something else".
      rSleep.doSleep(1, 1000);
    } // end of "for" loop
  }  // end of "run" method
}  // end of class "Reader"