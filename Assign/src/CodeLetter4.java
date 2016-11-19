import java.util.Random;

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

public class CodeLetter4 {

	private char letterValue;	// - a single letter in the code

	
	public CodeLetter4(char topL){	// - Randomly select a code letter; topL is top litter

		Random rnd = new Random();
		
		letterValue=(char)(rnd.nextInt((int)topL-64)+'A');
		
//		System.out.println("==>"+letterValue);
		
	}

	public boolean isEquals(CodeLetter4 codeL){	// - BONUS - Do the code values match?
		
		return isEquals(codeL.letterValue);
		
	}
	
	public boolean isEquals(char c){	// - Is the given letter correct?
	
		return (letterValue==c);		
	}
	
	public void display(){	// - Display the code letter
		
		System.out.print(letterValue);
		
	}
}
