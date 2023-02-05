Question 1:
1.1 
When the program is executed, the reason why 1 is outputting 0 is because the parent and child function is
not communicating with eachother. So when 1/2 = 0, the only calculation is calculating from 0, and ignoring the second half.
Another example would be the input 5. If the input 5 then, 5/2=2.5. So the parent function will calculate 0+1+2=3. 
Ignoring the child function which would be 3+4+5=12. 

1.2 
How I fixed the issue was adding in the exit total to the child process in line 73. For the program to commincate to 
the parent process their own calculation and add it to the total. By adding in the wait function, it will wait until the
child function terminates.
The total sum in line 79, adds the status of the child process and that is the final value printed. 

1.3 
The value of n is 26. With the exit code, the reason why it has a limination is due to the 1 byte memory allocation. 
When the exit code value is greater than 255, then it will return an exist code modulo 256. To be more specific, it 
is if the child function has caluclated a sum greater than 255. When it tries to access the least significant bit, it ignores the overflow.

1.4 
The value n is 46. 
The reason why the value of n is much bigger is because the child function is then calculating the first have 
of the sum, which are values much smaller than the second half of n.

Question 2:
2.1
The reason why the num file never reachers 15000 is because 
when using the function getpid() within the else system, it
will only return the value of the PID of the first process. The print statements
are not associated to the following pid_n in the if statement. So the second print statement is not
going to be assigned to pid_2. All it is doing is printing it simutaneously.


2.3 
The value of n would be 5000. The reason because of the 6 test cases that was run with the original code. The only value output in the nums file never went below 5000. 
NUM_INCREMENTS is set at 5000. Since the code is running simutaneously, then it will only receive the increment from one pid.
During the test cases, the value output were:5021, 5001, and 5014
