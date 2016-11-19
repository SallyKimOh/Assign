import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sae il Kim  
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 11. 18.
 *
 * @Modify_User
 * @Modify_date 2016. 11. 18.
 */

public class CodeBreaker4 {

	
	private List<CodeLetter4> letter = new ArrayList();	// -list of letter
	private boolean done;	// - Is the game done?
	private Scanner input = new Scanner(System.in);	// - Common scanner
	private String guess;	// - Current guess
	private int limit;
	private int letterCnt;
	private String topCh;
	
	public CodeBreaker4(int l,int c) {	// - Display welcome message and create secret code

		limit = l;
		letterCnt = c;
		
		int startCh = letterCnt + 64;
		
		System.out.print("Choose the top letter from "+(char)startCh+" to Z? ");
		
		topCh = input.next().toUpperCase();
		
		while(topCh.charAt(0) < (char)startCh || topCh.length() > 1 ) {
			System.out.println("Invalid letter. The top letter must be bigger than "+(char)startCh +" and one letter");
			System.out.print("Choose the top letter from "+(char)startCh+" to Z? ");
			
			topCh = input.next().toUpperCase();
			
		}

		
		System.out.println("\nWelcome to CodeBreaker");
		System.out.println("You have "+limit+" tries to find the secret "+letterCnt+" letter code");
		System.out.println("The letters range from A to "+topCh);
		System.out.println("Good luck");
		System.out.println("The code can have repeat letters\n");

	
		CodeLetter4 tempLetter;
	
		for (int i = 0; i < letterCnt; i++) {
			
			tempLetter = new CodeLetter4(topCh.charAt(0));
			letter.add(i, tempLetter);
			
			for (int j = 0; j < i; j++) {
				if(letter.get(j).isEquals(tempLetter)){
					letter.remove(i);
					i--; 
				}
			} 

		}
		
	}
	

	public boolean done() {	// - Is the game done?
		
		return done;
	}
	
	private boolean isValid(char l){	// - Is the given letter valid?
		return (l >= 'A' && l <= topCh.charAt(0));
	}
	
	public void getGuess(int num){	// - Get guess #
		
		boolean chk = false;
		
		while (!chk) {
			System.out.print("Enter guess #"+num+" :");
			guess = input.next().toUpperCase();
			if (guess.equals("QUIT")){
				System.out.println("You lose");
				done = true;
				chk = true;
			} else if (guess.length() > letterCnt) {
				System.out.println("Guess is too long ");
			} else if (guess.length() < letterCnt){
				System.out.println("Guess is too short");
			} else {
				
				for(int j = 0; j < guess.length(); j++) {
					
					if (!this.isValid(guess.charAt(j))) {
						System.out.println("Letter "+(j+1) +", "+guess.charAt(j)+" is not a valid letter");	
						break;
					} else {
						if (j == guess.length()-1){
							chk = true;
						}
					}
				}
			}
		}
		
	}
	
	public void checkGuess(int num){	// - Verify the guess
		
		int colChar = 0;
		int colPlace = 0;
		
//		if (!done) {
			for(int i = 0; i < letter.size(); i++) {
				for (int j = 0; j < guess.length(); j++) {
					if (letter.get(i).isEquals(guess.charAt(j))){
						colChar++;
						if (i == j) colPlace++;
						break;
					}
				}
			}
				
			if (colPlace== letterCnt) {
				System.out.println("You win");
				done = true;
			} else {
				System.out.println(colPlace+" right letter in the right place ");
				System.out.println((colChar-colPlace)+" right letter in the wrong place\n");
				
				if (num == limit) {
					System.out.println("You lose");
				}
				
			}
//		}
			
	}
	
	public void display(){	// - Display the secret code
		
		System.out.print("The code was ");
		
		for (int i = 0; i < letter.size(); i++) {
			letter.get(i).display();
		}
		
		
	}
}
