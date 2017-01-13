import java.util.Arrays;
import java.util.Scanner;

public class ProblemSolution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner info = new Scanner(System.in);
		
		int[] num = new int[3];
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("input number"+(i+1)+":");
			num[i] = info.nextInt();
		}

		Arrays.sort(num);
		System.out.println(Arrays.toString(num));

		String[] str = new String[3];

		for (int i = 0; i < str.length; i++) {
			System.out.println("input String"+(i+1)+":");
			str[i] = info.next();
//			System.out.println("===>"+i);
//			System.out.println("===>"+str[i]);
		}

		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		
		
		
	}

}
