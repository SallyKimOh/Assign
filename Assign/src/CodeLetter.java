import java.util.Random;

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
public class CodeLetter {

	private char letterValue;	// - a single letter in the code

	
	
	public CodeLetter(){	// - Randomly select a code letter
		Random rnd = new Random();
		letterValue=(char)(rnd.nextInt(5)+'A');
//		System.out.println("==>"+letterValue);
		
	}
	public boolean isEquals(CodeLetter codeL){	// - BONUS - Do the code values match?
		
		boolean flag = false;
		
		if (letterValue==codeL.letterValue) {
			flag = true;
		} 
		
		return flag;
	}
	
	public boolean isEquals(char c){	// - Is the given letter correct?
	
		boolean flag = false;
		
		if (letterValue==c) {
			flag = true;
		}
		
		return flag;		
	}
	
	public void display(){	// - Display the code letter
		
		System.out.print(letterValue);
		
	}
}
