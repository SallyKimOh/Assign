import java.util.Scanner;

/**
 * @author Sae il Kim
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 10. 29.
 *
 * @Modify_User
 * @Modify_date 2016. 10. 29.
 */
public class CodeBreaker {

	
	private CodeLetter letter1;	// - First code letter
	private CodeLetter letter2;	// - Second code letter
	private CodeLetter letter3;	// - Third code letter
	private boolean done;	// - Is the game done?
	private Scanner input = new Scanner(System.in);	// - Common scanner
	private String guess;	// - Current guess
	
	public CodeBreaker() {	// - Display welcome message and create secret code
//		display();
		System.out.println("Welcome to CodeBreaker");
		System.out.println("You have 6 tries to find the secret 3 letter code");
		System.out.println("The letters range from A to E");
		System.out.println("Good luck");
		System.out.println("The code can have repeat letters");

		
		letter1 = new CodeLetter();
		letter2 = new CodeLetter();
		letter3 = new CodeLetter();

		while ((letter2.isEquals(letter1))||(letter3.isEquals(letter1))||(letter3.isEquals(letter2))) {
			letter2 = new CodeLetter();
			letter3 = new CodeLetter();
		}
	

	
	}
	
	public boolean done() {	// - Is the game done?
		
		return done;
	}
	
	private boolean isValid(char l){	// - Is the given letter valid?
		char[] mLetter = {'A','B','C','D','E'};
		boolean chk = false;
		for (int i = 0; i < 5; i++) {
			if (l == mLetter[i]) {
				chk = true;
			}
		}	
		
		return chk;
		
	}
	
	public void getGuess(int num){	// - Get guess #

		boolean chk = false;

		do {
			
			System.out.print("Enter guess #"+num+" :");
			guess = input.nextLine().toUpperCase();

			if ((guess.equals("QUIT"))||((num == 6)&&(!done))) {
				done = true;
				break;

			} else if (guess.length() > 3) {
				System.out.println("Guess is too long ");
				chk = true;
			} else if (guess.length() < 3){
				System.out.println("Guess is too short");
				chk = true;
			} else {
				for(int i = 0; i < guess.length(); i++) {
					
					if (!this.isValid(guess.charAt(i))) {
						switch (i) {
							case 0:
								System.out.println(guess.charAt(i)+" is not a valid first letter");	
								break;
							case 1:
								System.out.println(guess.charAt(i)+" is not a valid second letter");	
								break;
							case 2:
								System.out.println(guess.charAt(i)+" is not a valid third letter");	
								break;
						}

						chk = true;
						break;
					} else {
						chk = false;
					}
					
				}

			}
			
		} while(chk);
	
		this.checkGuess();
		
		
	}
	
	public void checkGuess(){	// - Verify the guess
		
		int colChar = 0;
		int colPlace = 0;
		
		if ((guess.equals("QUIT"))||(done)) {
			done = true;
			System.out.println("\nYou lose");
		} else {
			
			CodeLetter[] cl = {letter1,letter2,letter3};
			
			for(int i = 0; i < cl.length; i++) {
				
				for (int j = 0; j < guess.length(); j++) {
					if (cl[i].isEquals(guess.charAt(j))){
						colChar++;
						if (i == j) colPlace++;
						break;
						
					}
					
				}
				
			}
			
			System.out.println(colPlace+" right letter in the right place ");
			System.out.println((colChar-colPlace)+" right letter in the wrong place ");
			
			if (colPlace== 3) {
				
				System.out.println("\nYou win");
				done = true;
				
			}
		}
		
	}
	
	public void display(){	// - Display the secret code
		
		System.out.print("The code was ");
		letter1.display();
		letter2.display();
		letter3.display();

		
		
	}
}
