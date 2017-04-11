/*
 A school has 100 students. All lockers are closed on the first day of school. As the students enter, the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2, and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open, and opens it if it was closed). Student S4 begins with locker L3 and changes every fourth locker. Student S5 starts with L5 and changes every fifth locker, land so on, until student S100 changes L100

After all the students, have passed through the building and changed the lockers with lockers are open?

Write a program to find your answer and display all open locker numbers separated by exactly one space.

(Hint: Use an array of 100 Boolean elements, each of which indicates whether a locker is open (true) or closed (false). Initially, all lockers are closed.)

**********Sample output************

Locker 1 is open
Locker 4 is open
Locker 9 is open
Locker 16 is open
Locker 25 is open
Locker 36 is open
Locker 49 is open
Locker 64 is open
Locker 81 is open
Locker 100 is open


 */
package assignment;
/**
 *
 * @author Garrett Shepherd
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Lockers array. true = open; false = closed.
        boolean[] lockers;
        lockers = new boolean[100];
        
        // Iterate through students.
        for (int i = 0; i < 100; i++) {
            
            // Iterate through the lockers specific for each student.
            for (int j = i; j < lockers.length; j += i + 1) {
                
                // Switch locker state: open / close.
                lockers[j] = !lockers[j];
            }
        }
        
        // Print lockers with open state.
        for (int i = 0; i < lockers.length; i++) {
            if(lockers[i] == true)
                
                // i + 1, due to 0-based index of arrays.
                System.out.println(String.format("Locker %d is open.", i + 1));
        }
    }
}
