package HackerRankLeetCodeQuestions;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NumberFormatterCurrencyFormatter {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat nf;
        nf = NumberFormat.getCurrencyInstance(Locale.US);
        String us = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
        String india = nf.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
    
}
