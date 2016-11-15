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
		
	}

}
