//The content of this file defines a Java class named 'ThreadBot' 
//This class inherits from the predefined Java class Thread.

public class SingleThreadBots extends Thread
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
	public SingleThreadBots(int id, char c, char d, char e) 
	{
		//Here we retrieve the value of the identity passed by the main class
		Identity = id;
		//Here we retrieve the value of the character passed by the main class
		char init_char_1 = c;
		char init_char_2 = d;
		char init_char_3 = e;
	}
	

	public void run()
	{	
        long start_time = System.nanoTime();
		//Here is where you write the code that should crack the password
      

        // for question 3
        char[] seq_q3 = {'i', 't', 'v'};

		//********************************************
        //If you want to test the sequence for question 4, replace, first_letter_for_q3 in the pass variable
		//to first_letter_for_q4
        char[] seq_q4 = {'i', 'v', 't'};
    

        for (int i=0; i<3; i++) {
            for (int j=0; j<26; j++) {
                for (int k=0; k<26; k++) {
                    for (int l=0; l<26; l++) {
                        for (int m=0; m<26; m++) {

							//System.out.println("Testing ["+ pass +"] by Thread(" + this.Identity +") ...");

							counter++;
                            //change seq_4 to 3 if you want to test question 3
                            String pass = "" + seq_q4[i] + T[j] + T[k] + T[l] + T[m];

                            //if the password matches the challenge
                            if ((pass + SingleThreadAttacker.challenge).hashCode() == SingleThreadAttacker.captured) {
                                SingleThreadAttacker.found = true;
                                System.out.println("Password found ["+ pass +"] by Thread(" + this.Identity +") after "+counter+ " tries");
                                
								//stop the timer
                                long end_time = System.nanoTime();
                                long time_to_run = end_time - start_time;
                                System.out.println("Time to run ="+ time_to_run);
                            }

                            //if pass found, stop  
                            if (SingleThreadAttacker.found == true) {
                            	this.stop();
                            }
                        }
                    }
                }
                
            }
        }
		
       
	}

}
