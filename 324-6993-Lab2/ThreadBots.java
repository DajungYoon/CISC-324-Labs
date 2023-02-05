//The content of this file defines a Java class named 'ThreadBot' 
//This class inherits from the predefined Java class Thread.

public class ThreadBots extends Thread
{

	int Identity; //This integer variable will be the thread identifier
	char T[] = {'a', 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 
				'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' ,
				'u' , 'v' ,'w' , 'x' , 'y' ,'z'};
    char init_char;//This character will be used by each thread as the first letter in the password 
	int counter=0;


	//Here we redefine the default constructor of this class.
	//By default it has no arguments, but in this example
	//We are using two arguments
	public ThreadBots(int id, char c) 
	{
		//Here we retrieve the value of the identity passed by the main class
		Identity = id;
		//Here we retrieve the value of the character passed by the main class
		init_char = c;
	}
	

	public void run(){
		long startTime = System.nanoTime();

		String pass;

		for (int i = 0; i < 26; i++) {
			pass = "" + init_char;
			
			pass = pass + T[i];

			String pass_2_chars = pass;
			
			for (int j = 0; j < 26; j++) {
				pass = pass + T[j];
				
				String pass_3_chars = pass;

				for (int k = 0; k < 26; k++) {
					pass = pass + T[k];
					
					String pass_4_chars = pass;
					
					for (int l = 0; l < 26; l++) {
						pass = pass + T[l];
						
						//System.out.println("Testing ["+ pass +"] by Thread(" + this.Identity +") ...");
						counter++;
						
						if ((int)(pass + ThreadAttacker.challenge).hashCode() == ThreadAttacker.captured) {
							ThreadAttacker.found = true;
							
							System.out.println("Password found ["+ pass +"] by Thread(" + this.Identity +") after "+counter+ " tries");			
							long endTime = System.nanoTime();
                            long time_to_run = endTime - startTime;
                            System.out.println("Time to run ="+ time_to_run);
						}
						//optimality
						if (ThreadAttacker.found==true){ 
							this.stop();
							}
						pass = pass_4_chars;
					}
					
					pass = pass_3_chars;
					
				}
				
				pass = pass_2_chars;
			}
			
					
			pass = "" + init_char;;
		}
			
		
	}

}
