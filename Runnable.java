import java.io.*;
import java.util.Scanner;
import java.sql.*;


public class Runnable{
	static Scanner input = new Scanner(System.in);

	private double depositAmount;
	private double withdrawAmount;
	public static double userBalance = 10000;

	public static void account(){
		System.out.print("\n\t\t\t\t\tA C C O U N T !!!!!!: ");
		System.out.print("\n\n\n\t\t\t\t\tEnter Bank ID: ");
        int atmID = input.nextInt();
		System.out.print("\n\n\n\t\t\t\t\tEnter your Customer Id: ");
        int custId = input.nextInt();
        System.out.print("\t\t\t\t\tEnter Name: ");
		String name = input.nextLine();
		name = input.nextLine();
		System.out.print("\t\t\t\t\tEnter Address: ");
		String address = input.nextLine();
        System.out.print("\t\t\t\t\tEnter your account number: ");
        int acc_num = input.nextInt();
        System.out.print("\t\t\t\t\tEnter your Pin: ");
        int pin = input.nextInt();
        System.out.print("\t\t\t\t\tEnter Account Type: ");
        String accountType = input.nextLine();
        accountType = input.nextLine();
        System.out.print("\t\t\t\t\tEnter Initial Deposit: ");
        double initialDeposit = input.nextDouble();
    

        Account newAccount = new Account(Atm.get(atmID), custId, name, address, acc_num, pin, accountType, initialDeposit);

		if(newAccount.add()){
			System.out.println("Succesfully Created an Account");
			System.out.println("\n\t\t\t\t\tPress Any Character then Press Enter to Continue....");
			input.next();
			cls();
		}else{
			System.out.println("\nError. Try again!");
		}
    }
    public static void login(){
        System.out.print("\n\n\t\t\t\t\tEnter your account number: ");
        int acc_num = input.nextInt();
        System.out.print("\t\t\t\t\tEnter your Pin: ");
        int pin = input.nextInt();
       	System.out.println();

        Account log = Account.get(acc_num, pin);

		if(log != null){
			log.print();
			System.out.println("\n\n\t\t\t\t\tSuccesfully Log In");
			System.out.print("\n\t\t\t1 - Show Balance\t 2 - Deposit Amount\t 3 - Withdraw Amount ");
			System.out.print("\n\t\t\t\t\tEnter your Command: ");
        	int choose = input.nextInt();
        	switch(choose){
			case 1:
			showBalance();
			//transaction();
			break;
			case 2:
			deposit();
			//transaction();
			break;
			case 3:
			withdraw();
			//transaction();
			break;
			default:
			cls();
		}
	
		}else{
			System.out.println("\t\t\t\t\tAccount number and Account Pin is not exist");
		}
    }
 public static void menu(){
		System.out.print("\n\t\t\t************************************************************************");
		System.out.println("\n\t\t\t\t\t\tMenu:");
		System.out.println("\t\t\t\t\t\t[0] Exit Program");
		System.out.println("\t\t\t\t\t\t[1] Create Account");
		System.out.println("\t\t\t\t\t\t[2] Log In");
		System.out.println("\t\t\t\t\t\t[3] Show Balance");
		System.out.println("\t\t\t\t\t\t[4] Deposit");
		System.out.println("\t\t\t\t\t\t[5] Withdraw");
		System.out.println("\t\t\t\t\t\t[6] transaction");
		System.out.print("\t\t\t\t\t\tEnter Choice:  ");
		}

		public static void showBalance(){
			System.out.print("\nYour Current Balance is: " + userBalance);
		}
		public static void deposit(){
			System.out.print("Please Enter The Amount to Deposit: " );
						double depositAmount = input.nextDouble();
			double total = userBalance  + depositAmount;
			System.out.print("\nYou have successfully Deposited " + depositAmount +  "\n\nNow your Balance is " + total);
		}
		public static void withdraw(){
			System.out.print("\nPlease Enter the Amount to Withdraw:");
						double withdrawAmount = input.nextDouble();
			if (withdrawAmount > userBalance){
			System.out.print("Insufficient balance. Please Try again ");
		}else {
			double total = userBalance - withdrawAmount;
			System.out.print("You have successfully Withdraw " + withdrawAmount + "\n\nNow your Balance is " + total);

		}
		}

	public static void main(String[] args) {
		int choose = -1;

		do{
			menu();
			choose = input.nextInt();
			cls();
			switch(choose){
				case 1:
					account();
					break;
				case 2:
					login();
					break;
				case 3:
					showBalance();
					break;
				case 4:
					deposit();
					break;
				case 5:
					withdraw();
					break;
				case 6:
					transaction();
					break;


			} 
		}while(choose != 0);
}
public static void Atm(){

		System.out.print("\n\n\n\t\t ENTER BANK ID: ");
		int atmID = input.nextInt();
		System.out.print("\t\t ENTER BANK Name: ");
		String bankName = input.nextLine();
		bankName = input.nextLine();
		System.out.print("\t\t BANK ADDRESS: ");
		String bankAdd= input.nextLine();

		Atm addBank = new Atm(atmID, bankName, bankAdd); 
		if(addBank.add()){
			System.out.println("\nYou are succesfully add Bank!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

public static void transaction(){

		Transaction info1 = new Transaction("BOT-8-25375-2aw", "1234567890", "0987654321", "1802651", " P 10,000.00 ");
			
		info1.printTransaction();
		System.out.println("     transaction: " + Transaction.computeTransaction());
	} 
	public static void cls(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}



