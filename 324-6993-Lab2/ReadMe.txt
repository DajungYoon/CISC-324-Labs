Question 1:
Thread 3 cracked the password

Question 2:
Since all the thread are child processes, they are sharing the memory if there is a change (ex. they find the password).
When one child process, that child is communicating with the others, what they have found. 

Q3:
To demonstrate, I added in a counter to show the time in nanoseconds. 
In the runs, multithreaded is only a bit faster than singlethreaded

Include the runs :
First Run
Single = 145538600
Multi = 136977400

Second Run
Single = 155159300 
Multi = 149988000

Third Run
Single = 153035100
Multi = 132061300

In conclusion, the time it takes to crack the 
password using multi-threaded process is a little less 
than the time it takes for the attacker who uses a
single-threaded process if we consider the same 
order of testing the first characters i.e., i, t, 
then v.


Q4:
After changing the order of testing from {‘i’, ‘t’, ‘v’} to {‘i’, ‘v’, ‘t’} 
for single-threaded process:

Include the runs :
First Run
Single =122733300
Multi =144506000

Second Run
Single =116672500 
Multi = 123196600

Third Run
Single =142501200
Multi = 137371000

In conclusion, we know that the password starts with v, meaning 
placing it closer to the start of the list the thread is iterating
through to find combinations makes it run quicker. Therefore, in my runs, 
the performance speed for single-threaded process is 
faster than multi-threaded process when changing around the chracters.