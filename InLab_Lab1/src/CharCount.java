import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CharCount {

	private int cnt = 0;
	
	private int letterCnt = 0;
	
	private List<CharCount> cntList = new ArrayList<CharCount>();

	public String[] wordArr(String str, String portion) {
		
		String[] wordList = str.split(portion);
		return wordList;
		
	}
	
	public String replaceStr(String str, String portion) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
				str = str.replaceAll(String.valueOf(str.charAt(i)), portion);

			
			}
		}

		return str;
	}

	
	
	public List<CharCount> getCountList(String[] wordList) {
		CharCount tempLetterCnt;
		
		int ord = 0;
		for (int i = 0; i < wordList.length; i++) {
			int temp = 0;
			tempLetterCnt = new CharCount();
			
			if (!wordList[i].trim().isEmpty()) {
				for (int j = 0; j < cntList.size(); j++) {
					if (wordList[i].length() == cntList.get(j).getLetterCnt()) {
						int cnt = cntList.get(j).getCnt();
						tempLetterCnt.setCnt(cnt);
						tempLetterCnt.setLetterCnt(wordList[i].length());

						cntList.remove(j);
						
						cntList.add(j, tempLetterCnt);
						temp ++;
						break;
					}
				}
				if (cntList.isEmpty() || temp == 0) {
					
					tempLetterCnt.setCnt(0);
					tempLetterCnt.setLetterCnt(wordList[i].length());
						
					cntList.add(ord++,tempLetterCnt);
				} 				

			}

		}
		
		return cntList;
	}
	
	
	public static Comparator<CharCount> CntLetterComparator = new Comparator<CharCount>() {

		public int compare(CharCount s1, CharCount s2) {
			   int letterCnt1 = s1.getLetterCnt();
		   int letterCnt2 = s2.getLetterCnt();

		   //ascending order
		   return letterCnt1-letterCnt2;

		   //descending order
	    }};
	
	
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int c) {
		this.cnt = ++c;
	}

	public int getLetterCnt() {
		return letterCnt;
	}

	public void setLetterCnt(int l) {
		this.letterCnt = l;
	}
	
	
	
	
	
}
