/*
 Assignment #9 (Count the occurrences of numbers entered)

Write a program that reads an unspecified number of integers and finds the one that has the most occurrences. 

The input ends when the input is 0. For example, if you entered 2 3 40 3 5 4 -3 3 3 2 0 the number 3 occurred most often.

If not one but several numbers have the most occurrences, all of them should be reported.

For example, since 9 and 3 appear twice in the list 9 30 3 9 3 2 4, both occurrences should be reported.

******sample output****

Enter an integer: 2

Enter an integer: 3

Enter an integer: 40

Enter an integer: 3

Enter an integer: 5

Enter an integer: 4

Enter an integer: -3

Enter an integer: 3

Enter an integer: 3

Enter an integer: 2

Enter an integer: 0

Number 3 occurred most

****sample output*****

Enter an integer: 9

Enter an integer: 30

Enter an integer: 3

Enter an integer: 9

Enter an integer: 3

Enter an integer: 1

Enter an integer: 4

Enter an integer: 0

Number 3 occurred most

Number 9 occurred most
 */
package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author Garrett Shepherd
 */
public class Assignment9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize scanner for user input.
        Scanner input = new Scanner(System.in);
        // Initialize HashMap to store intries.
        HashMap entries = new HashMap();
        
        System.out.println("Please enter any whole number (enter 0 to exit).");
        // Main loop.
        String number;
        do{
            // Asks for integer, but stores as String.
            // HashMap throws an exception for negative integer Keys.
            // Storing Keys as Strings and 
            // parsing the Integer solves this issue.
            System.out.print("Number: ");
            number = input.next();
            
            // Loop breaks on 0.
            if(Integer.parseInt(number) == 0)
                break;
            
            // Add user input if Key doesn't exist in HashMap.
            // "Initializes" to Key Value to 1.
            if(!entries.containsKey(number)){
                entries.put(number, 1);
            }else{
                // Gets value. 
                Integer value = (Integer) entries.get(number);
                // Updates Key value by 1 if Key exists.
                // ---------------------------------------------
                // Initially tried "value++", but found that the
                // Key was updated with 'value' and THEN 'value' was updated.
                // Incremented first to solve the issue.
                entries.put(number, ++value);
            }
        }while(Integer.parseInt(number) != 0);
        
        // Get list of Keys to iterate.
        Set entriesSet = entries.keySet();
        
        // Iterator for Keys.
        Integer next;
        Integer highestValue = 0;
        Iterator iterator = entriesSet.iterator();
        
        // Gets the highest Value among all Keys by comparing to the
        // impossible, lowest value -> 0.
        while(iterator.hasNext()){
            next = (Integer) entries.getOrDefault(iterator.next(), 0);
            if(next > highestValue)
                highestValue = next;
        }
        
        // Initialize ArrayList to store all Keys whose Value == 'highestValue'.
        // ArrayList set to the number of Keys present.
        ArrayList highestEntries = new ArrayList(entriesSet.size());
        iterator = entriesSet.iterator();
        Object o;
        
        // Iterate through entries and compare to 'highestValue'.
        while(iterator.hasNext()){
            o = iterator.next();
            // Add to ArrayList if Key Value == 'highestValue'.
            if(entries.get(o) == highestValue){
               highestEntries.add(o);
            }
        }
        
        // Print that every Key in the ArrayList had the highest occurance.
        for(Object entry : highestEntries){
            System.out.println(entry + " occurred most often.");
        }
    }
    
}
