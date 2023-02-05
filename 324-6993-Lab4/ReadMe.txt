/*
Dajung Yoon
Lab 4
Student #:20206993

This is the ReadMe File.
*/

Changes were in the MainMethod, TrafficLightsController, Synch, and Car class
 
TrafficLightsController Class:
New variables- EastBoundLightRed, WestBoundLightRed, 
greenLightPeriod (time unit used for green light period), 
carTime (the time for the car to get across)

This class will release the mutex semaphore. Both of the entrance semaphores depend on if there is enough time (simulatedTime)
Depending if there are cars waiting,
or if there is enough time to get across. Then the mutex for each of the 
east and west entrances will release. 
	

Car Class:
No new variables.

In this class, the release condition for the cars had to be implemented.
Using the TrafficLightsController class, if the light is red for a certain entrance, then you had to implement the 
wait/block function. Otherwise, release the cars into the intersection. 
The condition to check this is an if statement, if the light is red or if there are any cars waiting. 

MainMethod Class:
In the MainMethod class, the westbound and eastbound semaphores were created. 
The TrafficLightsController had to start before the cars. So the cars know when they are able to release or wait etc. 

Synch class:
New variables - The EastEntrance, WestEntrance semaphores were declared so the other classes can call them
The counters for the eastbound cars and westbound cars are needed to count if there are any cars in waiting. 
The counter will increment for when they are put into the semaphore, and will decremrent as they cross the bridge on a green light. 
 

 