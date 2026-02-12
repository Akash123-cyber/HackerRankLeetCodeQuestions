package HackerRankLeetCodeQuestions;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;



class rangeOfPrimitiveTypes{
    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Numbers you are going to enter: ");
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {   
                System.out.print("Enter the number:");
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                
                long negShort = -((long) Math.pow(2,15));
                // System.out.println(negShort);
                long posShort = ((long) Math.pow(2,15)) - 1;
                // System.out.println(posShort);
                if( x >= negShort && x <= posShort)System.out.println("* short");
                
                long negInt = - ((long) Math.pow(2,31));
                // System.out.println(negInt);
                long posInt = ((long) Math.pow(2, 31)) - 1;
                // System.out.println(posInt);
                if( x >= negInt && x <= posInt)System.out.println("* int");
                

                long negLong = - ((long) Math.pow(2,63)) - 1;
                System.out.println(negLong);

                long posLong = ((long) Math.pow(2,63));
                System.out.println(posLong);
                if( x >= negLong && x <= posLong)System.out.println("* long");
                
                // else System.out.println("n can't be fittedd anywhere.");
                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}
