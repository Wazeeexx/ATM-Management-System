import java.io.*;
import java.sql.*;
public class Account{
	private int id;
	private String name;
	private String address;
   	private int acc_num;
    private int pin;
    private String accountType;
    private double initialDeposit;
    private Atm bank;
	public Account(){  
    }
    public Account(Atm bank, int id,  String name, String address,int acc_num, int pin, String accountType, double initialDeposit){
    		this.bank = bank;
    		this.id = id;
    		this.name = name;
    		this.address = address;
         	this.acc_num = acc_num;
            this.pin = pin;
            this.accountType = accountType;
            this.initialDeposit = initialDeposit;
         	 }
       public Account(int pin, String name){
         	this.name = name;
            this.pin = pin;   
       }
       public Atm getBankname(){
      	 return bank;
		}
      public int getId(){
      	return id;
      }
      public String getName(){
      	return name;
      }
      public String getAddress(){
      	return address;
      }

    public int getAccNum(){
		return acc_num;
	}
	
	public int getPin(){
		return pin;
	}
	public String getaccountType(){
		return accountType;
	}
	public double getInitialDeposit(){
		return initialDeposit;
	}
	public void setBank(Atm bank){
		this.bank = bank;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setAccNum(int acc_num){
		this.acc_num = acc_num;
	}
	public void setPin(int pin){
		this.pin = pin;
	}
	public void setAccountType(String accountType){
		this.accountType = accountType;
	}
	public void setInitialDeposit(double initialDeposit){
		this.initialDeposit = initialDeposit;
	}
	public void print(){
		bank.displayBank();
		System.out.println("\t\t\t\tCustomer Id: " + id);
		System.out.println("\t\t\t\tCustomer Name: " + name);
		System.out.println("\t\t\t\tCustomer Address: " + address);
		System.out.println("\t\t\t\tAccount Number: " + acc_num);
		System.out.println("\t\t\t\tAccount Pin: " + pin);
		System.out.println("\t\t\t\tAccount Type: " + accountType);
		System.out.println("\t\t\t\tInitial Deposit: " + initialDeposit);
	}
	public void display(){
		System.out.println("\n\n\t\t\t\tName: " + name);

	}
	public void disp(){
		System.out.println("\t\t\t\tAccount Pin: " + pin);
	}
		public boolean add(){
		try{
			File file = new File("Data/Account.txt");
			if(!file.exists()){
				return false;
			}
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(Atm.getAtmID() + "\t");
			bufferedWriter.write(id + "\t");
			bufferedWriter.write(name + "\t");
			bufferedWriter.write(address + "\t");
			bufferedWriter.write(acc_num + "\t");
			bufferedWriter.write(pin + "\t");
			bufferedWriter.write(accountType + "\t");
			bufferedWriter.write(initialDeposit + "\n");
			bufferedWriter.close();
			return true;
		}catch(IOException x){
			System.out.println("Error");
		}
		return false;
	}
	public static Account get(int searchAccnum){
		Account account = null;
		try{
			FileReader fileReader = new FileReader("Data/Account.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataBank = Integer.parseInt(data[0]);
				int dataID = Integer.parseInt(data[1]);
				String dataName = (data[2]);
				String dataAddress = (data[3]);
				int dataAccNum = Integer.parseInt(data[4]);
				int dataPin = Integer.parseInt(data[5]);
				String dataType = data[6];
				double dataInitialDeposit = Double.parseDouble(data[7]);
				
				if(searchAccnum == dataAccNum){
					 account = new Account(Atm.get(dataBank), dataID, dataName,   dataAddress, dataAccNum, dataPin, dataType, dataInitialDeposit);
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}
		return account; 
	}
	public static Account get(int searchAccnum, int searchPin){
		Account account = null;
		try{
			FileReader fileReader = new FileReader("Data/Account.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataBank = Integer.parseInt(data[0]);
				int dataID = Integer.parseInt(data[1]);
				String dataName = (data[2]);
				String dataAddress = (data[3]);
				int dataAccNum = Integer.parseInt(data[4]);
				int dataPin = Integer.parseInt(data[5]);
				String dataType = data[6];
				double dataInitialDeposit = Double.parseDouble(data[7]);
				
				if(searchAccnum == dataAccNum && searchPin == dataPin){
					 account = new Account(Atm.get(dataBank),dataID, dataName, dataAddress,  dataAccNum, dataPin, dataType, dataInitialDeposit);
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	return account; 
	}
	public static void viewAll(){
		System.out.printf("\n%-15s %-17.23s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
			 "Bank ID", "Bank Name", "Bank Address", "Customer Id", "Name", "Address", "Account Number", "Account Pin", "Account Type", "Initial Deposit");
		try{
			FileReader fileReader = new FileReader("Data/Account.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataBank = Integer.parseInt(data[0]);
				int dataID = Integer.parseInt(data[1]);
				String dataName = (data[2]);
				String dataAddress = (data[3]);
				int dataAccNum = Integer.parseInt(data[4]);
				int dataPin = Integer.parseInt(data[5]);
				String dataType = data[6];
				double dataInitialDeposit = Double.parseDouble(data[7]);
			
				Account acc1 = new Account(Atm.get(dataBank), dataID,  dataName, dataAddress, dataAccNum,  dataPin, dataType,  dataInitialDeposit);
				acc1.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}
	public void printRow(){
		bank.printRow();
		System.out.printf("%-15s %-17.23s %-15s %-15s %-15s %-15s %-15s", id, name, address, acc_num, pin,  accountType, initialDeposit);
		}
	public void printRowws(){
		System.out.printf("%-17s %-19s", name, acc_num);
	}
}