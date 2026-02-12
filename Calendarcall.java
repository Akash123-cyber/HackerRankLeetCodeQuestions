package HackerRankLeetCodeQuestions;
import java.util.Calendar;

public class Calendarcall {

    public static void main(String[] args){

        int day = 8;
        int month = 5;
        int year = 2015;

        //since Calendar class is an abstract class we cannot instantiate it using the new keyword
        Calendar cal = Calendar.getInstance(); 
        //Calendar.getInstance() uses a factory method to return a concrete subclass object
        //(like GregorianCalendar) referenced by an abstract class variable.

        //month is 0 based
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        System.out.println("Day is: "+days[dayOfWeek - 1]);

    }

    
}
