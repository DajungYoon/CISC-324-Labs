/*
Dajung Yoon
Lab 4
Student #:20206993
*/

public class TrafficLightsController extends Thread {
	public static boolean EastBoundLightRed = true;
	public static boolean WestBoundLightRed = true;
	public static int greenLightPeriod = 500; //time unit used for green light period
	public static int carTime = 2;//for the simulated delay
	
	public void run () {
		int simulatedTime = 0;
        //timeSim needs to know how many threads there are so it can know when all 
		//threads have finished so that simulated time can be start.
		Synch.timeSim.threadStart();

		//this variable will be used to let the cars know how much time it needs to get across
		int timeLeft;

		//while there is time left
		while(simulatedTime<100) {
			
			//get Mutex on traffic light and Eastcounter
		    Synch.Mutex.acquire();
		   
		    //Turn the light green
			EastBoundLightRed = false;

			//this variable is used to keep track of how much time is left
			timeLeft = greenLightPeriod;
			
			//while there are cars waiting, and there is enough time
			while((Synch.EastBoundCarCounter>0) && (timeLeft>0)) 
			{ 
				Synch.EastEntrance.release(); 
				//release the mutex on traffic light and the counter 
				Synch.Mutex.release();
				//delay between cars
				Synch.timeSim.doSleep(carTime);
							
				//Get mutex on EastBoundCarCounter
				Synch.Mutex.acquire();

				//decrement because the cars are going to leave the light
				Synch.EastBoundCarCounter--;

				//calculate the time again after the amount of cars left
				timeLeft = timeLeft - carTime;
				  
			}
			//Release mutex
			Synch.Mutex.release();
			
			//Traffic light period (timeLeft)
			Synch.timeSim.doSleep(timeLeft);

	
			//get Mutex on traffic light
		    Synch.Mutex.acquire();
			//Both traffic light becomes red for the delayed time
			WestBoundLightRed = true;
			EastBoundLightRed = true;
			Synch.Mutex.release();
			Synch.timeSim.doSleep(100);
			
			---------------------------------------------------------------------------------------------

			//SAME THING FOR THE WEST BOUND NOW

		    Synch.Mutex.acquire();
			WestBoundLightRed = false;
			timeLeft = greenLightPeriod;
			
			while((Synch.WestboundCarCounter>0)&& (timeLeft>0)) 
			{ 
				Synch.WestEntrance.release(); 
				Synch.Mutex.release();
				Synch.timeSim.doSleep(carTime);
				Synch.Mutex.acquire();

				Synch.WestboundCarCounter--;
				timeLeft = timeLeft - carTime;
				  
			}

			Synch.Mutex.release();
			Synch.timeSim.doSleep(timeLeft);

		    Synch.Mutex.acquire();
			//Both traffic light becomes red for the delayed time
			WestBoundLightRed = true;
			EastBoundLightRed = true;
			Synch.Mutex.release();
			Synch.timeSim.doSleep(100);
			
			simulatedTime++;
		}
		
		
	  }
}