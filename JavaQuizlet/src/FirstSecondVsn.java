import java.util.*;
import java.io.*;

/***
 * 
 * @author Timot
 * This is a a user input comparison program. 
 * 
 * Precondition: String one must be a valid string, with a valid file reference.
 * Precondition: String two must be a valid string, with a valid file reference.
 * Precondition: The number of lines in the two reference files should be the same. 
 * 
 */

public class FirstSecondVsn extends ManipulateNormalTextFiles{

 public static void main(String[] args) throws IOException {

	 final int CURRENT_LIST_NUM = 7;
	 //boolean extra_strings = false;
	 
	 //String one = "E:/TimEng/OneDrive/Documents/12th Grade/AP European History (Allen)/Summer Work/Countries.txt";
	 //String two = "E:/TimEng/OneDrive/Documents/12th Grade/AP European History (Allen)/Summer Work/Capitals.txt";
	 
	 //these are the file locations of your text files
	 String one = "C:/Users/Timot/OneDrive/Documents/1 - Cornell Freshman/FREN 2090/Ch " + CURRENT_LIST_NUM + " Vocab English.txt";
	 String two = "C:/Users/Timot/OneDrive/Documents/1 - Cornell Freshman/FREN 2090/Ch " + CURRENT_LIST_NUM + " Vocab French.txt";
	
	 //if (extra_strings == true) {
	//	 String three = "C:/Users/Timot/OneDrive/Documents/1 - Cornell Freshman/FREN 2090/Ch 6 Vocab English.txt";
	//	 String four = "C:/Users/Timot/OneDrive/Documents/1 - Cornell Freshman/FREN 2090/Ch 6 Vocab French.txt"; 
	 //}
	 
	 //these are the arrays that store the text documents' items
	 ArrayList <String> arr1 = new ArrayList<String>();
	 ArrayList <String> arr2 = new ArrayList<String>();
	 ArrayList <String> wrong = new ArrayList<String>();
	 
	 //stores text items in arrays
	 StoreTxt(one, arr1);
	 StoreTxt(two, arr2);
	 //StoreTxt(three, arr1); 
	 //StoreTxt(four, arr2);
 
	 Scanner input = new Scanner(System.in);
	 StopWatch timer = new StopWatch();
	 StopWatch timer2 = new StopWatch();
	 StopWatch timer3 = new StopWatch();
	 Random generator = new Random();
	 
	 /*//in case you want multiple files to test
	 System.out.println("Do you want to include the second list? y/n");
	 String second_array = input.nextLine();
	 if(second_array == "y") {
		 StoreTxt(three, arr1); 
		 StoreTxt(four, arr2);
	 }*/
		
	 int x = arr1.size(); //ignore this comment //change this to how many times you want to run it
	 final int y = arr1.size();
	 int count = arr1.size();
	 int numWrong = 0;
	 final int divide = arr1.size();
	 
	 int times1 = 0;
	 int times2 = 0;
	 String choice = "y";
	  
	 System.out.println(x + " to start!");
	 System.out.println();
	  
	 timer2.start();
        
	 while(choice != "n"){
		 times1 ++;
		 timer.start();
		  
		 while (count > 0){
			  
			 times2++;
			 int j = generator.nextInt(x); // or could use int j = Math.random() * arr1.size();
    
			 System.out.println(arr1.get(j));
			 String ans = input.nextLine();
			 timer3.start();
    
			 if(ans.toUpperCase().equals("BREAK"))
			 //if(ans.equals("BREAK") || ans.equals("break")) // if you want to stop
			 { break; }
			  
			 else if (ans.equals(arr2.get(j))){ // if you got it right
				 System.out.println("correct");
				 arr1.remove(j);
				 arr2.remove(j);
				 x--;
				 count--;
			 } 
    
			 //if you got it wrong
			 else{
				 System.out.println("incorrect " + arr2.get(j) + " is correct");
				 numWrong++;
				 //wrong.add(ans); 
				 wrong.add(arr1.get(j));
				 wrong.add(arr2.get(j));
			 }
			 
			 timer3.stop();
			 System.out.println();
			 System.out.println(x + " left!");
			 System.out.println();
    
		 }
         
		 timer.stop();
		  
		 for(int i = 0; i < wrong.size(); i+=2){ 
		  //System.out.println("You said " + wrong.get(i) + " , which is " + wrong.get(i + 1) + " = " + wrong.get(i + 2)); 
			 System.out.println(wrong.get(i)+ " = " + wrong.get(i + 1) + " is correct.");
		  }
		  if(times2 < y) {
			  System.out.println("You finished early! Try again.");
		  }
		  else if (times2 > y) {
			  System.out.println("It took you " + times2 + " rounds, out of " + y + " total, which is a difference of " + (times2 - y) + " !");
		  }
		  
		  System.out.println("It took " + timer.getElapsedTime()/1000 + " seconds to do, or " + timer.getElapsedTime() + " ms to do.");
		  System.out.println(numWrong + " wrong: ");
		  System.out.println("It also took you on average " + (timer3.getElapsedTime()/1000)/divide + " seconds per question!");
			 
		  //in case someone used break
		  arr1.clear();
		  arr2.clear();
		  
		  //reset all the variables
		  StoreTxt(one, arr1);
		  StoreTxt(two, arr2);
		  //if(second_array == "y") {
//			  StoreTxt(three, arr1);
//			  StoreTxt(four, arr2);
		  //}
		  x = arr1.size();
		  count = arr1.size();
		  numWrong = 0;
		  timer.reset();
		  wrong.clear(); 
   
		  System.out.println("Would you like to go again? y/n");
		  choice = input.nextLine();
   
		  if(choice.equals("n"))
		  { break; }
		  
	  }
	  timer2.stop();
	  System.out.println("It took " + timer2.getElapsedTime()/1000 + " seconds to do, or " + timer2.getElapsedTime() + " ms to do in total.");
	  
	  if(times1 == 1)
	  { System.out.println("You did it 1 time."); }
	  else
	  { System.out.println("You did it " + times1 + " times!"); }
     
	  input.close();
  
	  //End program
	  
 }

}