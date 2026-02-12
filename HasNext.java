package HackerRankLeetCodeQuestions;

import java.util.Scanner;

public class HasNext {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str;
        int count = 0;

        // while scanner has a character to read
        while(sc.hasNext()){

            str = sc.nextLine();
            count++;

            System.out.printf("%1$d %2$s%n",count, str);
        }

    }
}
