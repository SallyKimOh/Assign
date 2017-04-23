import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Lab7_1 {
	
	private static int[][] display;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner info = new Scanner(System.in);
		
		System.out.println("Enter the phrase:");
		String sentence = info.nextLine();
		
		sentence = sentence.trim().toUpperCase();
		
		int[][] letterCnt  = new int[sentence.length()][2];
		
		int lcnt = 0;
		int n = 0;
		int count = 1;
		System.out.println("leng:"+sentence.length());
		for (int i = 0; i < sentence.length(); i++) {
			System.out.println("i==>"+i);
			if (sentence.charAt(i) >='A' && sentence.charAt(i) <= 'Z' ) {
				lcnt++;
			} else {
				System.out.println(lcnt);
				if (lcnt > 0) {
					if ((n > 0)||(letterCnt[0][0] == 1)) {
						System.out.println("AA");
						for (int j = 0; j <= n; j++) {
							if (lcnt == letterCnt[j][1]) {
								count++;
								System.out.println("couunt==>"+count);
							}
							if ((j == n)&&(count == 1)) {
								count = 1;
								n++;
							}
						}
					}
					
					if ((n == 0)&&(letterCnt[0][0] == 0)) {
						System.out.println("count=nn=>"+count);
						
						letterCnt[n][1] = lcnt;
						letterCnt[n][0] = 1;
						lcnt = 0;
						System.out.println("==>"+letterCnt[0][0]);
//						n++;
					} else {
						System.out.println("count==>"+count);
					
						letterCnt[n][1] = lcnt;
						letterCnt[n][0] = count;
						lcnt = 0;
						count= 1;
						n++;
//					}
					}
					
				}
//				lcnt = 0;
			}

			if (i == sentence.length()-1) {
				letterCnt[n][1] = lcnt;
				letterCnt[n][0] = count;
			}
		}
		
		System.out.println("num:"+n);

		
		for (int i = 0; i <= n; i++) {
			System.out.println("Cletter:"+letterCnt[i][0]);
			
		}

		for (int i = 0; i <= n; i++) {
			System.out.println("letter:"+letterCnt[i][1]);
			
		}

	}

}
