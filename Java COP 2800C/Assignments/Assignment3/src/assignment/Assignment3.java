/*
(Financial application: compare loans with various interest rates)

Write a program that lets the user enter the loan amount and loan period in number of years and displays the monthly and total payments for each interest rate starting from 5% to 8% with an increment of 1/8.

Here is the formula to compute monthly payment:

Math.pow(1 + monthly interest rate, number of years * 12)

**********Sample Output************
Enter loan amount, for example 120000.95: 10000
Enter number of years as an integer, for example, 5: 3
Interest Rate       Monthly Payment     Total Payment       
5.000%               299.71             10789.52
5.125%               300.27             10809.74
5.250%               300.83             10829.98
5.375%               301.40             10850.24
5.500%               301.96             10870.52
5.625%               302.52             10890.83
5.750%               303.09             10911.16
5.875%               303.65             10931.52
6.000%               304.22             10951.90
6.125%               304.79             10972.30
6.250%               305.35             10992.72
6.375%               305.92             11013.17
6.500%               306.49             11033.64
6.625%               307.06             11054.13
6.750%               307.63             11074.65
6.875%               308.20             11095.19
7.000%               308.77             11115.75
7.125%               309.34             11136.34
7.250%               309.92             11156.95
7.375%               310.49             11177.58
7.500%               311.06             11198.24
7.625%               311.64             11218.92
7.750%               312.21             11239.62
7.875%               312.79             11260.34
8.000%               313.36             11281.09
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        
        // Display description.
        System.out.println("Enter a loan amount and payment period to display payment table.");
        
        // Get loan amount.
        System.out.print("Loan amount (e.g., 120000.95): ");
        double loanAmount = input.nextDouble();
        
        // Get years.
        System.out.print("Years (e.g., 5): ");
        int years = input.nextInt();
        
        // Input done.
        input.close();
        
        double payment;
        System.out.print("Interest Rate\t");
        System.out.print("Monthly Payment\t");
        System.out.println("Total Payment\t");
        for (double i = 5; i <= 8; i += .125) {
            // Interest rate.
            System.out.print(String.format("%.3f%%\t\t", i));
            // Monthly payment.
            payment = calculateMonthlyPayment(loanAmount, i, years);
            System.out.print(String.format("%.2f\t\t", payment));
            // Total payment.
            System.out.println(String.format("%.2f", payment * (12 * years)));
        }
        
    }
    
    private static double calculateMonthlyPayment(double loanAmount, double rate, int years){
        // Interest rate in decimal.
        double interestRate = rate / 100;
        // Interest rate per month.
        double monthlyRate = interestRate / 12;
        // Total payment period(s) in months.
        int termInMonths = years * 12;
        // Monthly payment calculation.
        double monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
        
        // Return monthly payment.
        return monthlyPayment;
        
    }
}
