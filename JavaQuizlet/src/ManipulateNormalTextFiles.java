import java.io.*;
import java.util.*;
public class ManipulateNormalTextFiles {
    
 public static void ReadTxt(String str){
 //public static void main(String [] args) {

  ArrayList <String> arr = new ArrayList<String>();
  
        // The name of the file to open.
        //String fileName = "H:/APCS2015ENG/FridayProjectArr1.txt";
  
  String fileName = str;
  
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                arr.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
 //}
 }
 
 public static void StoreTxt(String str, ArrayList<String> arr){
  //public static void main(String [] args) {

   //ArrayList <String> arr = new ArrayList<String>();
   
         // The name of the file to open.
         //String fileName = "H:/APCS2015ENG/FridayProjectArr1.txt";
   
   String fileName = str;
   
         // This will reference one line at a time
         String line = null;

         try {
             // FileReader reads text files in the default encoding.
             FileReader fileReader = new FileReader(fileName);

             // Always wrap FileReader in BufferedReader.
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             while((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                 arr.add(line);
             }   

             // Always close files.
             bufferedReader.close();         
         }
         catch(FileNotFoundException ex) {
             System.out.println(
                 "Unable to open file '" + fileName + "'");                
         }
         catch(IOException ex) {
             System.out.println("Error reading file '" + fileName + "'");                  
             // Or we could just do this: 
             // ex.printStackTrace();
         }
  //}
 }

}

