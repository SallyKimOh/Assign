import java.util.Scanner;

public class ProblemSolution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner info = new Scanner(System.in);
		
		int[] grade = new int[10];
		int total = 0;
		
		int max = 0;
		
		for (int i = 0; i < grade.length; i++) {
			System.out.println("input number"+(i+1)+":");
			grade[i] = info.nextInt();
			total +=grade[i];
			if (max < grade[i]) max = grade[i];
			
		}
		
		System.out.println("average:"+((double)total/(double)grade.length));
		System.out.println("largest:"+max);
		
		
		
	}

}
