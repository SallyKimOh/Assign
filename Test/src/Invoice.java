import java.util.Scanner;

public class Invoice {
	
//	3.12 (Invoice Class ) 
//	Create a class  called Invoice 
//	that a hardware store  might use to represent an invoice for an item sold at the store . 
//	An Invoice should include four pieces of information as instance variables -a part number (type  String ),
//	a part description (type  String ), 
//	a quantity of the item being purchased (type  int ) 
//	and a price per item (double ). 
//	Your class  should have a constructor  that initializes  the four instance variables . 
//	Provide a set and a get method  for each instance variable . 
//	In addition, provide a method  named  getInvoiceAmount 
//	that calculates the invoice amount (i.e., multiplies the quantity by the price per item), 
//	then returns the amount as a double  value . 
//	If the quantity is not positive, it should be set to 0. 
//	If the price per item is not positive, it should be set to 0.0. 
//	Add a main method  to the class  
//	that demonstrates class  Invoice's capabilities by reading in valuies from stdin and prints to stdout the complete state of the object  each time the state of the object  is changed. 
	
	
	private String information;
	private String description;
	private int quantity;
	private double price;
	
	public Invoice(String i, String d, int q, double p){
		information = i;
		description = d;
		quantity = q;
		price = p;
	}
	
	public double getInvoiceAmount(){
		double amount;
		
		amount = quantity * price;
		
		return amount;
	}
	
	
	public String getInformation() {
		return information;
	}







	public void setInformation(String information) {
		this.information = information;
	}







	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public int getQuantity() {
		return quantity;
	}







	public void setQuantity(int quantity) {
		if (quantity < 0) quantity = 0;
		
		this.quantity = quantity;
	}







	public double getPrice() {
		if (price < 0) price = 0.0;
		return price;
	}







	public void setPrice(double price) {
		this.price = price;
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Making a new object of class Invoice:");
		System.out.print("Enter the part number:");
		String partNumber = stdin.nextLine();	
		System.out.print("Enter the part description:");
		String desc = stdin.nextLine(); 
		System.out.print("Enter the Quantity of Items:");
		int quantity = stdin.nextInt(); 
		System.out.println("Enter the Price Per Item with cents in decimals:");
		double price = stdin.nextDouble();
		
		Invoice stdout = new Invoice(partNumber,desc,quantity,price);

		stdout.setQuantity(quantity);
		stdout.setPrice(price);
		System.out.println("\nUsing all the get methods the state of the object is:");
		System.out.println("The part number: "+ stdout.getInformation());
		System.out.println("The part description: "+ stdout.getDescription());
		System.out.println("The Quantity of Items: "+ stdout.getQuantity());
//		System.out.println("The Price Per Item with cents in decimals: "+ stdout.getPrice());
		System.out.format("The Price Per Item with cents in decimals: "+"%.2f%n", + stdout.getPrice());

//		System.out.println("Using getInvoiceAmount the Invoice is: "+ stdout.getInvoiceAmount());
		System.out.format("Using getInvoiceAmount the Invoice is: "+"%.2f%n", + stdout.getInvoiceAmount());

		System.out.println("\nUsing the setters to mutate the object one step at a time:");

		System.out.println("\n\nEnter the new Price Per Item with cents in decimals:");
		price = stdin.nextDouble();
		stdout.setPrice(price);
		System.out.println("Using all the get methods the state of the object is:");
		System.out.println("The part number: "+stdout.getInformation());
		System.out.println("The part description: "+stdout.getDescription());
		System.out.println("The Quantity of Items: "+stdout.getQuantity());
		System.out.format("The Price Per Item with cents in decimals: "+"%.2f%n", + stdout.getPrice());
		System.out.format("Using getInvoiceAmount the Invoice is: "+"%.2f%n", + stdout.getInvoiceAmount());
		
		System.out.println("\nEnter the new Quantity of Items:");
		quantity = stdin.nextInt();
		stdout.setQuantity(quantity);

		System.out.println("Using all the get methods the state of the object is:");
		System.out.println("The part number: "+stdout.getInformation());
		System.out.println("The part description: "+stdout.getDescription());
		System.out.println("The Quantity of Items: "+stdout.getQuantity());
		System.out.format("The Price Per Item with cents in decimals: "+"%.2f%n", + stdout.getPrice());
		System.out.format("Using getInvoiceAmount the Invoice is: "+"%.2f%n", + stdout.getInvoiceAmount());

		System.out.println("\nEnter the new part description:");
		String descrip = stdin.nextLine();
		desc = stdin.nextLine();
		stdout.setDescription(desc);

		System.out.println("Using all the get methods the state of the object is:");
		System.out.println("The part number: "+stdout.getInformation());
		System.out.println("The part description: "+stdout.getDescription());
		System.out.println("The Quantity of Items: "+stdout.getQuantity());
		System.out.format("The Price Per Item with cents in decimals: "+"%.2f%n", + stdout.getPrice());
		System.out.format("Using getInvoiceAmount the Invoice is: "+"%.2f%n", + stdout.getInvoiceAmount());

		System.out.println("\nEnter the new part number:");
		partNumber = stdin.nextLine();
		stdout.setInformation(partNumber);
		System.out.println("Using all the get methods the state of the object is:");
		System.out.println("The part number: "+stdout.getInformation());
		System.out.println("The part description: "+stdout.getDescription());
		System.out.println("The Quantity of Items: "+stdout.getQuantity());
		System.out.format("The Price Per Item with cents in decimals: "+"%.2f%n", + stdout.getPrice());
		System.out.format("Using getInvoiceAmount the Invoice is: "+"%.2f%n", + stdout.getInvoiceAmount());
		System.out.print("\n");
		
		
		
	
	}

}
