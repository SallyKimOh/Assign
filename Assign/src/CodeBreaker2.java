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
public class CodeBreaker2 {

	
	private CodeLetter letter1;	// - First code letter
	private CodeLetter letter2;	// - Second code letter
	private CodeLetter letter3;	// - Third code letter
	private boolean done;	// - Is the game done?
	private Scanner input = new Scanner(System.in);	// - Common scanner
	private String guess;	// - Current guess
	
	public CodeBreaker2() {	// - Display welcome message and create secret code
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

			if (guess.length() > 3) {
				System.out.println("Guess is too long ");
				chk = true;
			} else if (guess.length() < 3){
				System.out.println("Guess is too short");
				chk = true;
			} else {
				for(int i = 0; i < 3; i++) {
					
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
		
		if ((num == 6)&&(!done)){
			System.out.println("You lose");
		}
	
	}
	
	public void checkGuess(){	// - Verify the guess
		
		boolean check1 = false;
		boolean check2 = false;
		boolean check3 = false;
		
		
		int colChar = 0;
		int colPlace = 0;
		
		
		if (guess.equals("QUIT")) {
			done = true;
			System.out.println("\nYou lose");
		} else {

			for(int i = 0; i < 3; i++) {
				
				check1 = letter1.isEquals(guess.charAt(i));
				if (check1) {
					colChar++;
					if (i==0){
						colPlace++;
					}
					break;
				} 
			}
			
			for(int i = 0; i < 3; i++) {
				check2 = letter2.isEquals(guess.charAt(i));
				if (check2) {
					colChar++;
					if (i==1){
						colPlace++;
					}
					break;
				} 
			}
	
			for(int i = 0; i < 3; i++) {
				check3 = letter3.isEquals(guess.charAt(i));
				if (check3) {
					colChar++;
					if (i==2){
						colPlace++;
					}
					break;
				} 
			}
			
			
			CodeLetter[] cl = {letter1,letter2,letter3};
			
			for(int i = 0; i < 3; i++) {
				check3 = letter3.isEquals(guess.charAt(i));
				if (check3) {
					colChar++;
					if (i==2){
						colPlace++;
					}
					break;
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
