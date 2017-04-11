/*
 ATM

Use the Account class attached to simulate an ATM machine. 
Create ten accounts in an array with id 0, 1, ….,9, and initial balance $100. 
The system prompts the user to enter an id. If the id is entered incorrectly, 
ask the user to enter a correct id. Once an id is accepted, 
the main menu is displayed as shown in the sample run. 
You can enter a choice 1 for viewing the current balance, 
2 for withdrawing money, 3 for depositing money, 
and 4 for exiting the main menu. Once you exit, 
the system will prompt for an id again. 
Thus, once the system starts, it will not stop

***************Sample Output**********************

 
Enter an ID: 4
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 1
The balance is $100.0
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 2
Enter an amount to withdraw: 3
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 1
The balance is $97.0
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 3
Enter an amount to deposit: 20
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 1
The balance is $117.0
 
Main Menu
1: check balance
2: withdraw
3: deposit
4: exit
 
Enter a choice: 4
 
Enter an ID:
 */
package assignment;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment6 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount userAccount;
        BankAccount[] accounts = new BankAccount[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount();
        }
        
        // Main logic loop.
        while(true){
            System.out.print("Enter ID number: ");
            
            int userID;
            do{
                userID = input.nextInt();
                if(userID > 10 || userID < 1){
                    System.out.println("ID not found.");
                    System.out.print("Enter ID number: ");
                }else{
                    System.out.println("User ID: " + userID);
                }
            }while(userID > 10 && userID < 1);

            // !!CAUTION!!
            // Account is (userID - 1) due to zero-based Array index.
            // !!CAUTION!!
            userAccount = accounts[userID - 1];

			// Main loop for bank account actions.
            int choice;
            do{            
                displayMenu();
                choice = input.nextInt();
                System.out.println();
                doChoice(choice, userAccount);
            } while(choice != 4);

            System.out.println("Thank you for doing business at Shepherd's Bank!");
            System.out.println("Logging out...");
        }
    }
    
    // Return menu items. Placed into Array for easier expandability.
    private static String[] getMenuItems(){
        String[] menuItems = new String[]{"Check Balance", "Withdraw", "Deposit", "EXIT"};
        return menuItems;
    }
    
	// Evaluates choice and perform action on current bank account.
    private static void doChoice(int choice, BankAccount account){
        Scanner input = new Scanner(System.in);
        switch(choice){
			// Check balance.
            case 1:
                account.checkBalance();
                break;
			// Withdraw from balance.
            case 2:
                System.out.print("Withdraw Amount (in U.S. Dollars): ");
                
				// Stop withdrawal if no money in balance.
                if(account.getBalance() < 0){
                    account.warningAccountOverdrawn();
                }else{
                    account.withdraw(input.nextDouble());
                }
                // Shows balance.
                account.checkBalance();
                break;
			// Deposit amount into balance.
            case 3:
                System.out.print("Deposit Amount (in U.S. Dollars): ");
                
                account.deposit(input.nextDouble());
				// Shows balance.
                account.checkBalance();
                break;
            case 4:
                break;
            default:
                System.out.println("Please choose a valid option.");
                break;
        }
    }
    
	// Shows menu items.
    private static void displayMenu(){
        String[] menu;
		// Retrieve menu options.
        menu = getMenuItems();
        
        System.out.println("Main Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ": " + menu[i]);
        }
        System.out.println();
        System.out.print("Choice: ");
    }
}

class BankAccount{
    private double balance;

	// Initialize account with 100 dollars.
    public BankAccount(){
        balance = 100;
    }
    
	// Increase balance by deposited amount.
    public void deposit(double amount){
        balance += amount;
    }
    
	// Returns only balance amount.
    public double getBalance(){
        return balance;
    }
	
	// Shows balance.
    public void checkBalance(){
        System.out.println(String.format("Balance: $%.2f", balance));
        System.out.println();
    }
    
	// Decrease balance by amount.
    public void withdraw(double amount){
        balance -= amount;
    }
    
	// Give warning that balance is less than 0.
    public void warningAccountOverdrawn(){
        System.out.println();
        System.out.println("!!WARNING!! Account Overdrawn!");
        System.out.println("Please deposit funds to withdraw from account.");
    }
}
