import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Lab7 {
	
	private static int[][] display;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner info = new Scanner(System.in);
		
		System.out.println("Enter the phrase:");
		String sentence = info.nextLine();
		
		sentence = sentence.trim().toUpperCase();
		
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) <'A' || sentence.charAt(i) > 'Z' ) {
				sentence = sentence.replace(""+sentence.charAt(i), "/");
//				System.out.println(sentence);
			}
		}

		String[] word = sentence.split("/") ;
		
		HashMap hMap = new HashMap();
		
		if (word[0].length() > 0) {
			hMap.put(word[0].length(), 1);
		}
		
		
		for (int i = 1; i < word.length; i++) {
			for (int j = 0; j < i; j++) {
				if (word[i].length() == word[j].length()) {
					int cnt = (int) hMap.get(word[i].length());
//					System.out.println("cnt==>"+cnt);
					hMap.put(word[i].length(),++cnt);
					
//					System.out.println(word[i].length()+"==>"+hMap.get(word[i].length()));
					break;
				} else {
					if (j == (i-1)){
						hMap.put(word[i].length(), 1);
					}
				}
			}
			
		}
		
		int total = 0;
		Set<Integer> keys1 = hMap.keySet();

		for(int key:keys1) {
			System.out.println(hMap.get(key)+" "+key +" letter words");
			total += (int)hMap.get(key);
		}

		System.out.println(total+" total words");
		
	}

}
