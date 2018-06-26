import java.util.*;
import java.io.*;

public class FirstSecondVsnOriginal extends ManipulateNormalTextFiles{

 public static void main(String[] args) throws IOException {

  //final int CURRENT_LIST_NUM = 5;
  
  //String one = "E:/TimEng/OneDrive/Documents/12th Grade/AP European History (Allen)/Summer Work/Countries.txt";
  //String two = "E:/TimEng/OneDrive/Documents/12th Grade/AP European History (Allen)/Summer Work/Capitals.txt";
  
  String one = "C:/Users/Timot/OneDrive/Documents/12th Grade/French V (McCarthy)/La vie en Rose Definition.txt";
  String two = "C:/Users/Timot/OneDrive/Documents/12th Grade/French V (McCarthy)/La vie en Rose French.txt";
  
  ArrayList <String> arr1 = new ArrayList<String>();
  ArrayList <String> arr2 = new ArrayList<String>();
  ArrayList <String> wrong = new ArrayList <String>();
  
  StoreTxt(one, arr1);
  StoreTxt(two, arr2);
  
  Scanner input = new Scanner(System.in);
  StopWatch timer = new StopWatch();
  StopWatch timer2 = new StopWatch();
  Random generator = new Random();
  
        int x = arr1.size(); //ignore this comment //change this to how many times you want to run it
        final int y = arr1.size();
        int count = arr1.size();
        int numWrong = 0;
        
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
    
    if(ans.equals("BREAK") || ans.equals("break")) // if you want to stop
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
    
    System.out.println();
          System.out.println(x + " left!");
          System.out.println();
    
   }
         
   timer.stop();
   System.out.println("It took " + timer.getElapsedTime()/1000 + " seconds to do, or " + timer.getElapsedTime() + " ms to do.");
         System.out.println(numWrong + " wrong: ");
   for(int i = 0; i < wrong.size(); i+=2){ 
    //System.out.println("You said " + wrong.get(i) + " , which is " + wrong.get(i + 1) + " = " + wrong.get(i + 2)); 
    System.out.println(wrong.get(i)+ " = " + wrong.get(i + 1) + " is correct.");
   }
   System.out.println("It took you " + times2 + " rounds, out of " + y + " total, which is a difference of " + (times2 - arr1.size()) + " !");
   
   //reset all the variables
   StoreTxt(one, arr1);
   StoreTxt(two, arr2);
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
          
 }

}