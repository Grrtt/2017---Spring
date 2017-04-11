/*
 The popularity ranking of baby names from years 2001 to 2010 is downloaded from
www.ssa.gov/oact/babynames and stored in files named babynameranking2001.txt, 
babynameranking2002.txt…. babynameranking2010.txt. 
Each file contains one thousand lines. Each line contains a ranking, 
a boy’s name, a number for the boy’s name, a girl’s name, 
and number for the girl’s name. So, the boy’s name Jacob and girl’s name 
Isabella are ranked number one and the boy’s name Ethan and girl’s name Sophia 
are ranked #2. 21,875 boys are named Jacob and 22,731 girls are named Isabella.

Write a program that prompts the user to enter the year, gender, 
and followed by a name, and displays the ranking of the name for the year.

************Sample Run****************

Enter the year:
2004
Enter the gender (M or F)
F
Enter the name:
Eva
Eva is ranked #198 in the year 2004.
 
----
Enter the year:
2008
Enter the gender (M or F)
M
Enter the name:
Putin
The name Putin was not found in year 2008.
----
Enter the year:
2002
Enter the gender (M or F)
M
Enter the name:
John
John is ranked #17 in the year 2002.
 */
package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner for input.
        Scanner input = new Scanner(System.in);
        
        // Get year choice.
        System.out.print("Enter year (2001-2010): ");
        int year = input.nextInt();
        
        // Get gender choice.
        System.out.print("Enter gender (M or F): ");
        String gender = input.next();
        
        // Get name choice.
        System.out.print("Enter name: ");
        String name = input.next();
        
        // Declare FileReader for Babynamesranking based on year.
        FileReader fr = new FileReader(String.format("Babynamesranking%d.txt", year));
        
        // Declare BufferedReader of FileReader to iterate through file lines.
        BufferedReader br = new BufferedReader(fr);

        try{
            String line;
            int i = 0;
            do{
                // Iterate through each line of the file.
                line = br.readLine();
                // Increment for each read line to give ranking number.
                i++;
                
                // If name is in read line, do the following...
                if(line.contains(name)){
                    
                    // Replace the space that follows some names in the file 
                    // instead of tab characters ("\t").
                    line = line.replaceAll(" ", "");
                    
                    // Split read line by tabs.
                    String[] lineSplit = line.split("\t");
                    
                    // Checks lineSplit array for male name.
                    if(lineSplit[1].equals(name) && gender.equalsIgnoreCase("m")){
                        System.out.println(String.format("%s is ranked #%d in the year %d.", name, i, year));
                        break;
                        
                    // Checks lineSplit array for female name.
                    }else if (lineSplit[3].equals(name) && gender.equalsIgnoreCase("f")){
                        System.out.println(String.format("%s is ranked #%d in the year %d.", name, i, year));
                        break;
                    }
                }
            } while(true);
        // IOException for readLine().
        }catch(IOException e){
            System.out.println(e.getMessage());
        // NullPointerException thrown to signify end of file.
        }catch(NullPointerException eNull){
            System.out.println(String.format("%s was not found in the year %d.", name, year));
        }
    }
}
