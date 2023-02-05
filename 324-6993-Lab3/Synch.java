/*
Dajung Yoon
Lab 3
Student #:20206993
*/

// This file defines class "Synch".  This class contains all the semaphores
// and variables needed to coordinate the instances of the Reader and Writer
// classes.  

import java.util.concurrent.*;

public class Synch {

  public static Semaphore mutex;
  public static Semaphore wrt;
  public static int readcount = 0;
  public static Semaphore readQueue;//the readers who arrived when a writer was writing or when a writer was waiting
  public static Semaphore writeQueue;//the writers who arrived when at least one reader was reading the data structure or when a writer was writing on the data structure
  public static int activeReader = 0; //Counter for active readers
  public static int activeWriter = 0; //Counter for active writers
  public static int waitingReader = 0; //Counter for waiting readers
  public static int waitingWriter = 0; //Counter for waiting writers

}  // end of class "Synch"
