/*
Write an addition program that displays the sum of two numbers.

The program should prompt the user to enter the first and second number.

************Sample Output******************

Enter first integer: 15

Enter second integer: 22

Sum is 37
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declaring used variables.
        Scanner input = new Scanner(System.in);
        int firstNum, secondNum;
        
        // Get first number input.
        System.out.print("Please enter your first number: ");
        firstNum = input.nextInt();
        System.out.println(String.format("You entered %d.\n", firstNum));
        
        // Get second number input.
        System.out.print("Please enter you second number: ");
        secondNum = input.nextInt();
        System.out.println(String.format("You entered %d.\n", secondNum));
        
        // Get and display the sum of the numbers.
        int sum;
        sum = addNumbers(firstNum, secondNum);
        System.out.println(String.format("The sum of these numbers is %d.", sum));
        
        // Done retrieving data.
        // Close scanner.
        input.close();
        
    }
    
    /**
     * Adds multiple numbers together.
     * @param numbers Following the String.format() documentation,
     *                the numbers parameter allows multiple inputs for further class expansion,
     *                  although the code currently asks for only two numbers.
     * @return 
     */
    private static int addNumbers(int... numbers){
        int value = 0;
        
        // Add each argument from numbers together.
        for (int i = 0; i < numbers.length; i++) {
            value += numbers[i];
        }
        
        // Return value.
        return value;
    }
}
