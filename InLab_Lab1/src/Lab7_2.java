import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Lab7_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner info = new Scanner(System.in);
		
		System.out.println("Enter the phrase:");
		String sentence = info.nextLine();
		
		sentence = sentence.trim().toUpperCase();
		
		int[] letterCnt  = new int[sentence.length()];
		
		int lcnt = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) >='A' && sentence.charAt(i) <= 'Z' ) {
				lcnt++;
			} else {
				if (lcnt > 0) {
					letterCnt[lcnt-1] += 1;
				}
				lcnt = 0;
			}
			if (lcnt > 0) {   // this is for last word.
				if (i == sentence.length()-1) {
					letterCnt[lcnt-1] += 1;
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (letterCnt[i] !=0) {
				System.out.println(letterCnt[i]+" "+(i+1) +" letter words");
				total +=letterCnt[i];
			}
			
		}
		System.out.println(total+" total words");

	}

}
