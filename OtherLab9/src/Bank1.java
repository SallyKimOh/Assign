import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bank1 extends JFrame{
	
	BankAccount1 tempObj = null;

	JFrame jFrame;
	JPanel jPanel;
	JButton addAccount;
	JButton displayAccount;
	JButton updateAccount;
	JButton monthlyUpdate;
	JButton printAccount;
	JButton readFromFile;
	JButton quit;
	JLabel jLabel;

	JButton savings;
	JButton chequing;

	private ArrayList <BankAccount1> accounts; // it holds object of class bankAccount 
	private int numAccounts;
	private int sizeBank;

	Scanner input = new Scanner(System.in);
	Bank1() {
		sizeBank = 1000;
		accounts = new ArrayList<BankAccount1>(sizeBank);

		/*
		 * Instantiate Jfram, JPanel, JButton, JLabel objects	
		 */
		jFrame = new JFrame("Welcome to Areum's Bank");
		jFrame.setVisible(true);
		jFrame.setSize(800, 800);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 *  GridBagConstraints - Arranging Component on Frame / Panel in Java
		 	So I am using this to make buttons layout pretty
		 */ 
		GridBagConstraints c = new GridBagConstraints();

		// GridBagLayout to set the layout of Jpanel component 
		jPanel = new JPanel(new GridBagLayout());
		jPanel.setBackground(Color.PINK);
		jFrame.getContentPane().add(jPanel);
		addAccount = new JButton("Add account");
		displayAccount = new JButton("d - display information of a single account");
		updateAccount = new JButton("u - Update account");
		monthlyUpdate = new JButton("m - Run monthly update");
		printAccount = new JButton("p - Print all the details");
		readFromFile = new JButton("f - Enter details from a file");
		quit = new JButton("q - Quit ");
		//jLabel = new JLabel("JLabel");

		c.insets = new Insets(10, 10, 10, 10);


		jPanel.add(addAccount, c);
		// x-axis
		c.gridx = 0;
		// y-axis
		c.gridy = 1;

		jPanel.add(displayAccount, c);
		c.gridx = 0;
		c.gridy = 2;

		jPanel.add(updateAccount, c);
		c.gridx = 0;
		c.gridy = 3;

		jPanel.add(monthlyUpdate, c);
		c.gridx = 0;
		c.gridy = 4;

		jPanel.add(printAccount, c);
		c.gridx = 0;
		c.gridy = 5;

		jPanel.add(readFromFile, c);
		c.gridx = 0;
		c.gridy = 6;

		jPanel.add(quit, c);
		c.gridx = 0;
		c.gridy = 7;

		// adding jLabel to jPanel
		//jPanel.add(jLabel);

		// adding jPanel to jFrame and set the layout
		jFrame.add(jPanel, BorderLayout.CENTER);



		/*
		 * action listener to buttons
		 */


		addAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addAccount();
				//JOptionPane.showMessageDialog(null, "Action working");	
			}

		});

		displayAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				displayAccount();
				//JOptionPane.showMessageDialog(null, "Action working");	
			}

		});


		updateAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				updateAccount();
				//JOptionPane.showMessageDialog(null, "Action working");	
			}

		});

		monthlyUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				monthlyUpdate();
				//JOptionPane.showMessageDialog(null, "Action working");	
			}

		});

		readFromFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				readFromFile();
				//JOptionPane.showMessageDialog(null, "Action working");	
			}

		});

		
		quit.addActionListener(e-> {
			jFrame.disable();
		});
		
		
//		quit.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//
//		
//				//JOptionPane.showMessageDialog(null, "Action working");	
//
//			
//			
//			
//			
//			}
//
//		});

	}


	// to test the program
	Bank1 (int size) {
		sizeBank = size;
		accounts = new ArrayList<BankAccount1>(sizeBank);	

	}

	public boolean addAccount() {

		char accType;
		savings = new JButton("savings");

		jPanel.add(savings);


		chequing = new JButton("chequing");
		jPanel.add(chequing);



		if(numAccounts >sizeBank) {
			System.out.println("Bank is full.... cannot add account!!!");
			return false;
		}


		


		chequing.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tempObj = new ChequingAccount1();

				if(tempObj.addBankAccount()) { // if its true, return them
					accounts.add(numAccounts, tempObj);
					numAccounts++;

				}

			} 
		});



		savings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tempObj = new SavingsAccount1();

				if(tempObj.addBankAccount()) { // if its true, return them
					accounts.add(numAccounts, tempObj);
					numAccounts++;

				}

			} 
		});
	
		return true;

	}



	public void monthlyUpdate()  {

		for(int i =0; i<numAccounts; i++)
			accounts.get(i).monthlyAccountUpdate();

	}



	public void printAccountDetails() {
		System.out.println("********************************************");
		System.out.println("                Banking System               ");
		System.out.println("********************************************");

		for(int i =0; i<numAccounts; i++ )
			System.out.println(accounts.get(i).toString());

	}

	public void displayAccount() {
		System.out.println("Enter account number : ");
		int num = input.nextInt();
		int index = findAccount(num);
		System.out.println(num);
		System.out.println("Enter amount to deposit/withdraw (positive number to deposit, negative number to withdraw): ");
		double amnt = input.nextDouble();
		accounts.get(index).updateBalance(amnt);
	}


	public void updateAccount() {
		System.out.println("Enter account number : ");
		int num = input.nextInt();
		int index = findAccount(num);
		System.out.println("Enter amount to deposit/withdraw (positive number to deposit, negative number to withdraw): ");
		double amnt = input.nextDouble();
	}


	public int findAccount(int num) {
		int index = -1;
		for(int i =0; i<numAccounts; i++) 
			if(accounts.get(i).accNumber == num)
				index = i;
		return index;
	}


	public boolean readFromFile() {
		Scanner bankFile = openFile();
		if(bankFile == null) {
			return true;
		}

		String type = new String();
		BankAccount1 acc = null;
		boolean isOK = true;
		while(bankFile.hasNext()) {
			type =bankFile.next();
			if(type.charAt(0) == 's')
				acc = new SavingsAccount1();
			else if (type.charAt(0)== 'c')
				acc = new ChequingAccount1();
			else
				return false;
			isOK = acc.readFile(bankFile);

			if(!isOK)
				return false;
			if(numAccounts >= sizeBank) {
				System.out.println("bank full.... cannot add");
				return true;
			}
			accounts.add(numAccounts, acc);
			numAccounts++;
		}
		closeFile(bankFile);
		return true;

	}

	public Scanner openFile() {
		Scanner file = null;
		try {
			file = new Scanner(Paths.get("bankData.txt"));
		}
		catch(IOException ioException)
		{
			System.err.println("Error opening file. Terminating");
		}
		return file;

	}
	private static void closeFile(Scanner bankFile) {

		if(bankFile != null)
			bankFile.close();


	}



}
