
public class Transaction{
 
	private String transactionId;
	private String fromAccountNo;
	private String toAccountNo;
	private String typecode;
	private String amount;

	public static String credits;


  public Transaction(String transactionId, String fromAccountNo, String toAccountNo, String typecode, String amount){
		this.transactionId = transactionId;
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
		this.typecode = typecode;
		this.amount = amount;
	}
public Transaction(String transactionId, String fromAccountNo, String toAccountNo){
		this.transactionId = transactionId;
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
	}
   	public Transaction(String typecode, String amount)
   	{
   		this.typecode =typecode;
		this.amount =amount;
   	}
  
   	public String getTransactionId(){
		return transactionId;
	}

	public String getFromAccountNo(){
		return fromAccountNo;
	}

	public String getToAccountNo(){
		return toAccountNo;
	}

	public String getTypecode(){
		return typecode;
	}

	public String getAmount(){
		return amount;
	}

	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}

	public void setFromAccountNo(String fromAccountNo){
		this.fromAccountNo = fromAccountNo;
	}

	public void setToAccountNo(String toAccountNo){
		this.toAccountNo = toAccountNo;
	}

	public void setTypecode(String typecode){
		this.typecode = typecode;
	}

	public void setDebt(String amount){
		this.amount = amount;
	}

	public void printTransaction(){
		System.out.println("  Transaction ID: " + transactionId);
		System.out.println("From Account No.: " + fromAccountNo);
		System.out.println("  To Account No.: " + toAccountNo);
		System.out.println("            Code: " + typecode);
		System.out.println("          Amount: " + amount);
	}

public static double computeTransaction(){
		int number = 1;
		double amount = 50.00;
		double payment = amount * number;

		return payment;	
	}
}

