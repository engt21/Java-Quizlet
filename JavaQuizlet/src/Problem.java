    //Problem        : Volleyball Rotations
    //Language       : Java
    //Compiled Using : javac
    //Version        : Java 1.7.0_75
    //Input for your program will be provided from STDIN
    //Print out all output from your program to STDOUT
    
    import java.util.Scanner;
    //Your submission should *ONLY* use the following class name
    public class Problem
    {
        public static void main(String[] args)
        {
            
            int rotations = 0;
            String setter = "";
            String beglineup = "";
            String side = "";
            
           Scanner stdin = new Scanner(System.in);
           //while(stdin.hasNextLine()) 
           //{
               rotations = stdin.nextInt();
               stdin.nextLine();
               setter = stdin.nextLine();
               beglineup = stdin.nextLine();
               side = stdin.nextLine();
               //System.out.println(stdin.nextLine());
           //}
           stdin.close();
           String[][] players = new String[2][3];
           
           players[1][2] = beglineup.substring(0,1);
           players[0][2] = beglineup.substring(2,3);
           players[0][1] = beglineup.substring(4,5);
           players[0][0] = beglineup.substring(6,7);
           players[1][0] = beglineup.substring(8,9);
           players[1][1] = beglineup.substring(10,11);
           
           for(int i = 0; i < rotations; i++){
                if (!players[0][2].equals(setter)){
                   String removed = players[0][2];
                   players[0][2] = players[0][1];
                   players[0][1] = players[0][0];
                   players[0][0] = players[1][0];
                   players[1][0] = players[1][1];
                   players[1][1] = players[1][2];
                   players[1][2] = side.substring(2,3);
                   
                   side += " " + removed;
                   side = side.substring(0,2) + side.substring(4, side.length());
               }
               else if (players[0][2] == setter){
                   System.out.println("doing else");
                   String temp = players[0][2];
                   players[0][2] = players[0][1];
                   players[0][1] = players[0][0];
                   players[0][0] = players[1][0];
                   players[1][0] = players[1][1];
                   players[1][1] = players[1][2];
                   players[1][2] = temp;
               }
           }
           String one = players[1][2];
           String two = players[0][2];
           String three = players[0][1];
           String four = players[0][0];
           String five = players[1][0];
           String six = players[1][1];
           String space = " ";
           
           System.out.println(one+space+two+space+three+space+four+space+five+space+six);
           
        }
    
    }
