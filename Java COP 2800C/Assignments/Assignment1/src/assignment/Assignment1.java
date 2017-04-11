package assignment;



/*
    (Population projection) The U.S. Census Bureau projects population based on the following assumptions:

    One birth every 7 seconds
    One death every 13 seconds
    One new immigrant every 45 seconds

    Write a program to display the population for each of the next five years. Assume the current population is 312,032,486 and one year has 365 days. 
    Hint: In Java, if two integers perform division, the result is an integer. The fractional part is truncated. 
    For example, 5 / 4 is 1 (not 1.25) and 10 / 4 is 2 (not 2.5). To get an accurate result with the fractional part, 
    one of the values involved in the division must be a number with a decimal point. For example, 5.0 / 4 is 1.25 and 10 / 4.0 is 2.5.

    *************OUTPUT*****************

    Starting population: 312032486

    Population Year One: 314812582

    Population Year Two: 317592679

    Population Year Three: 320372776

    Population Year Four: 323152872

    Population Year Five: 325932969

    Good luck
 */

/**
 * @Garrett Shepherd
 */
public class Assignment1 {

    
    static final int SECONDS_PER_YEAR =
                365 *   // Days
                24 *    // Hours 
                60 *    // Minutes
                60;     // Seconds
    static final int STARTING_POPULATION = 312032486;
    
    /*
    Births, deaths, and immigrants by day per second.
    */
    static double birthsPerYear = SECONDS_PER_YEAR / 7.0;
    static double deathsPerYear = SECONDS_PER_YEAR / 13.0;
    static double immigrantsPerYear = SECONDS_PER_YEAR / 45.0;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Population is 'double' to catch the fractions.
        */
        double population = STARTING_POPULATION;
        
        System.out.println("Starting population: " + (int) population);
        
        
        String year = "";
        for (int i = 1; i <= 5; i++) {
            population += birthsPerYear;
            population -= deathsPerYear;
            population += immigrantsPerYear;
            
            switch(i){
                case 1: year = "One";   break;
                case 2: year = "Two";   break;
                case 3: year = "Three"; break;
                case 4: year = "Four";  break;
                case 5: year = "Five";  break;
            }
            System.out.println(String.format("Population Year %s: %d", year, (int) population));
        }
    }
}
