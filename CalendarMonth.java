import java.util.Scanner;

public class CalendarMonth
{
    // Start of main method
    public static void main( String [] args)
    {
        // Scanner used to prompt user for month and year
        Scanner input = new Scanner ( System.in );
        
        // Prompt user to enter month between 1 and 12
        System.out.println( "Please enter a month by entering a number between 1 and 12: " );
        int month = input.nextInt();
        
        // Prompt user to enter year
        System.out.println( "Please enter year (e.g., 2015): " );
        int year = input.nextInt();
        
        // Print calendar for user selection for month and year
        printMonthCalendar( month, year );
    }
    
    // Method used to print calendar of month within a year
    public static void printMonthCalendar( int month, int year )
    {
        // Method used to print header of calendar
        printMonthHeader( month, year );
        
        // Method used to print body of calendar
        printMonthBody( month, year );
    }
    
    // Method used to get header of calendar
    public static void printMonthHeader( int month, int year )
    {
        System.out.println( "       " + getMonthName( month ) + " " + year );
        System.out.println( "-----------------------------" );
        System.out.println( " Sun Mon Tue Wed Thu Fri Sat" );
    }
    
    // Method used to get month string from month int
    public static String getMonthName( int month )
    {
        // Initialized string
        String monthName = "";
        switch ( month )
        {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "Feburary";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "Novermber";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }
    
    // Method used to print month body
    public static void printMonthBody( int month, int year )
    {
        int day = 1;
        
        // Method uses Zeller's Algorithm to determine day of the week for the first day of the month
        int startDay = getStartDay( month, day, year );
        
        // Method used to get number of days in a month
        int numDaysInMonth = getNumDaysInMonth ( month, year );
        
        // Used for loops and if statements to set up spacing
        int i = 0;
        for (i = 0 ; i < startDay ; i++ )
        {
            if (startDay == 7 )
                break;
            System.out.print( "    " );
        }
        
        for ( i = 1 ; i <= numDaysInMonth ; i++ )
        {
            if ( i < 10 )
                System.out.print( "   " + i );
            else
                System.out.print( "  " + i );
            
            if ( (i + startDay) % 7 == 0 )
                System.out.println();
        }
        System.out.println( "\n" );
        
    }
    
    /*
     The method getStartDay() implements Zeller's Algorithm for determining the day of the
     week the first day of a month is. The method adjusts Zeller's numbering scheme
     for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
     that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
     
     Pre-Conditions: The month value, m,  is 1-12
     The day value, d, is 1-31, or 1-28, 1-29 for February
     The year value, y, is the full year (e.g., 2012)
     
     Post-Conditions: A value of 1-7 is returned, representing the first day of the month
     1 = Monday, ..., 7 = Sunday
     */
    public static int getStartDay( int month, int day, int year )
    {
        // Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 )
        {
            month = month + 12;
            year = year - 1;
        }
        
        int k = year % 100;      // Calculate year within century
        int j = year / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month
        
        h = ( day + ( 13 * ( month + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;
        
        return dayNum;
        
    }
    
    // Method used to get the number of days in a month or determine a leap year
    public static int getNumDaysInMonth( int month, int year )
    {
        if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
            return 31;
        if ( month == 4 || month == 6 || month == 9 || month == 11 )
            return 30;
        if ( month == 2 )
            return month = isLeapYear( year ) ? 29 : 28;
        
        return 0;
        
    }
    
    // Method used to determine if there is a leap year
    public static boolean isLeapYear( int year )
    {
        return year % 4 == 0;
        
    }
}