import java.util.Scanner;

public class Class8B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = new int[5];
		
		Scanner info = new Scanner(System.in);
		int maxNum = 0;
		int minNum = 0;
		
		
		for (int i = 0; i < 5; i++) {
			num[i] = info.nextInt();
			
			if (i == 0) {
				maxNum = num[i];
				minNum = num[i];
			} else {	
				maxNum = Math.max(num[i],maxNum);
				minNum = Math.min(num[i],minNum);
			}
		}
		System.out.println("Max:"+maxNum);
		System.out.println("Min:"+minNum);
		
		
		int temp = 0;
		
		maxNum = 0;
		minNum = 0;
		
		for (int i = 0; i <  5; i++) {
			
			temp = info.nextInt();
			if (i == 0) {
				maxNum = temp;
				minNum = temp;
			} else {
				if (maxNum - temp < 1) {
					minNum = maxNum;
					maxNum = temp;
				} 
			}
			
		}
		
		System.out.println("Max:"+maxNum);
		System.out.println("Min:"+minNum);
	}

}
