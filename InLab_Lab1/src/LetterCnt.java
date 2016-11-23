import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LetterCnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		LetterCnt lObj = new LetterCnt();
		CharCount cObj = new CharCount();
		
		
		Scanner info  = new Scanner(System.in);
		
		System.out.println("Enter the phrase:");

		String str = info.nextLine().trim().toUpperCase();
		
		str = cObj.replaceStr(str, "/");

		String[] wordList = cObj.wordArr(str, "/");

		List<CharCount> list = new ArrayList();
		
		list = cObj.getCountList(wordList);

		Collections.sort(list, cObj.CntLetterComparator);
		
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCnt()+" "+list.get(i).getLetterCnt() +" letter words");
			total+=list.get(i).getCnt();
		}

		System.out.println(total+" total words");
		
	}

}
