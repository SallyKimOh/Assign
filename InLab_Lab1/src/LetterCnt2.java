import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LetterCnt2 {

//	private static List<CharCount> cntList = new ArrayList();
	
//	public String[] wordArr(String str, String portion) {
//		
//		String[] wordList = str.split(portion);
//		return wordList;
//		
//	}
//	
//	public String replaceStr(String str, String portion) {
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
//				str = str.replaceAll(String.valueOf(str.charAt(i)), portion);
//
//			
//			}
//		}
//
//		return str;
//	}
//
//	
//	
//	public List<CharCount> getCountList(String[] wordList) {
//		CharCount tempLetterCnt;
//		
//		int ord = 0;
//		for (int i = 0; i < wordList.length; i++) {
//			int temp = 0;
//			tempLetterCnt = new CharCount();
//			
//			if (!wordList[i].trim().isEmpty()) {
//				for (int j = 0; j < cntList.size(); j++) {
//					if (wordList[i].length() == cntList.get(j).getLetterCnt()) {
//						int cnt = cntList.get(j).getCnt();
//						tempLetterCnt.setCnt(cnt);
//						tempLetterCnt.setLetterCnt(wordList[i].length());
//
//						cntList.remove(j);
//						
//						cntList.add(j, tempLetterCnt);
//						temp ++;
//						break;
//					}
//				}
//				if (cntList.isEmpty() || temp == 0) {
//					
//					tempLetterCnt.setCnt(0);
//					tempLetterCnt.setLetterCnt(wordList[i].length());
//						
//					cntList.add(ord++,tempLetterCnt);
//				} 				
//
//			}
//
//		}
//		
//		return cntList;
//	}
//	
//	
//	public static Comparator<CharCount> CntLetterComparator = new Comparator<CharCount>() {
//
//		public int compare(CharCount s1, CharCount s2) {
//			   int letterCnt1 = s1.getLetterCnt();
//		   int letterCnt2 = s2.getLetterCnt();
//
//		   //ascending order
//		   return letterCnt1-letterCnt2;
//
//		   //descending order
//	    }};
//	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LetterCnt2 lObj = new LetterCnt2();
		
		CharCount cObj = new CharCount();
		
		Scanner info  = new Scanner(System.in);
		
		System.out.println("Enter the phrase:");

		String str = info.nextLine().trim().toUpperCase();
		
		str = cObj.replaceStr(str, "/");

//		System.out.println(str);
		String[] wordList = cObj.wordArr(str, "/");

//		CharCount tempLetterCnt;
//		
//		int ord = 0;
//		for (int i = 0; i < wordList.length; i++) {
//			int temp = 0;
//			tempLetterCnt = new CharCount();
//			
//			if (!wordList[i].isEmpty()) {
//				for (int j = 0; j < cntList.size(); j++) {
//					if (wordList[i].length() == cntList.get(j).getLetterCnt()) {
//						int cnt = cntList.get(j).getCnt();
//						tempLetterCnt.setCnt(cnt);
//						tempLetterCnt.setLetterCnt(wordList[i].length());
//
//						cntList.remove(j);
//						
//						cntList.add(j, tempLetterCnt);
//						temp ++;
//						break;
//					}
//				}
//			}
//
//			if (cntList.isEmpty() || temp == 0) {
//				
//				tempLetterCnt.setCnt(0);
//				tempLetterCnt.setLetterCnt(wordList[i].length());
//					
//				cntList.add(ord++,tempLetterCnt);
//			} 				
//		}

		cObj.getCountList(wordList);

		List<CharCount> cntList = new ArrayList();
		
		cntList = cObj.getCountList(wordList);
		
		Collections.sort(cntList, cObj.CntLetterComparator);
//		   for(CharCount str1: cntList){
//				System.out.println(str1);
//		   }
		
		int total = 0;
		for (int i = 0; i < cntList.size(); i++) {
			System.out.println(cntList.get(i).getCnt()+" "+cntList.get(i).getLetterCnt() +" letter words");
			total+=cntList.get(i).getCnt();
		}

		System.out.println(total+" total words");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
