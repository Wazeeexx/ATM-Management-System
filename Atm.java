import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class Atm{
	private static int atmID;
	private static String bankName;
	private static String location;

	public Atm  (){
	}
	public Atm(int atmID, String bankName, String location){
		this.atmID = atmID;
		this.bankName = bankName;
		this.location = location;
	}
	public Atm(int atmID){
		this.atmID = atmID;
	}
	public static int getAtmID(){
		return atmID;
	}
	public static String getBankName(){
		return bankName;
	}
	public String getLocation(){
		return location;
	}
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public static void print(){
		System.out.println("BANK NAME " + "" + "" + "LANDBANK");
		System.out.println("BANK ADDRESS " + "" + "" + "IRIGA CITY");
		}
		public static void displayBank(){
		System.out.println("BANK NAME: " + "LANDBANK");
		System.out.println("BANK ADDRESS: " + "IRIGA CITY");

		}
		public boolean add(){
		try{
			File file = new File("Data/Atm.txt");
			if(!file.exists()){	
				return false;
			}
			FileWriter fileWriter = new FileWriter(file, true);	
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(atmID + "\t");
			bufferedWriter.write(bankName + "\t");
			bufferedWriter.write(location + "\t");
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}   return false;
	}

	 public static Atm get(int searchId){
        Atm bankname = null;
		 try{
            FileReader fileReader = new FileReader("Data/Atm.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] data = line.split("\t");

                int dataAtmID = Integer.parseInt(data[0]);
				String dataBankName = data[1];
				String dataLocation = data[2];

				 if(searchId == dataAtmID){
                     bankname = new Atm(dataAtmID, dataBankName, dataLocation);}
        }
		 }catch(IOException y){
            System.out.println("Error");
        }
		 return bankname; 
		}

    	public static void viewAll(){
        System.out.printf("\n%-15s %-17.23s %-20s\n",
          "Atm Id", "Bank Name", "Location");
        try{
            FileReader fileReader = new FileReader("Data/Atm.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] data = line.split("\t");

                 int dataAtmID = Integer.parseInt(data[0]); 
                 String dataBankName = data[1];
                 String dataLocation = data[2];

                Atm bank = new Atm(dataAtmID, dataBankName, dataLocation);
                bank.printRow();
                System.out.println();
            }
        }catch(IOException z){
            System.out.println("Error");
        }
    }
	public void printRow(){
		System.out.printf("%-15s %-17.23s %-20s", atmID, bankName, location);
	}
}