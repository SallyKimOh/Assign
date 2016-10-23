import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class T1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		T1 t = new 

		 int a1 = -10;
		 int b1 = -2;
		 int c1 = 0;
		 
		 
//		 String a2 = Integer.
		 NumberFormat format = NumberFormat.getNumberInstance();
		 System.out.println(format.format(2.01));
		 System.out.println(format.format(2.10));

		 String abc = "ABCDEDF";
		 System.out.println(abc.charAt(3));
		 
		 DecimalFormat df1 = new DecimalFormat("#.###");
//		 DecimalFormat df2 = new DecimalFormat("%.2f%n");
		 System.out.println(df1.format(2.10));
//		 System.out.println(df2.format(2.10));
		 System.out.format("%.3f%n", 2.1000);
		 System.out.format("===>"+"%f%n", 2.1000);
		 
		 int num1 = 10, num2 = 0, num3 = 4, num4 = 6;
		 num2 *= num4 / num3 + ++num2;
		 System.out.println(num2);
		 
		 System.out.println("TEST==>"+3+5);
		 
		 float fnum1 = 22.2f, fnum2 = 44.4f;
//		 fnum1 = num3 / 3 + 4 * num3 - 3 / 2;
		 fnum2 += 3/2.0f + fnum1;
		 System.out.println(fnum2);
		 System.out.println(22.2f+1.1f);
		 System.out.println(0.2f+1.1f);
		 System.out.print(fnum2);
		 System.out.format("===>"+"%f%n", fnum2);
		 
		 String sname = new String("ACB DGE");
		 String sname1 = "ACD EFEf";
		 System.out.println(sname);
		 System.out.println(sname1.length());
		 Time tim = new Time();
		 
		 System.out.println(tim.testHours);
		 
		 if (sname1.compareTo("ACD EFE")==0){
			 System.out.println("true");
		 } else {
			 System.out.println("false");
							 }
		 
		 
		 c1 = a1+b1;
				 
			DecimalFormat form = new DecimalFormat("#.##");
			
				 System.out.println();
				 if ((a1 < 0) || (b1 < 0)) {
					 
					 System.out.println("error");
					 
					 return;
				 }
		 

		
		
		int i = 0;
		String test = "��";
		
		
		float a = 0; 
		
		test.getBytes();
		
		System.out.println("TEST==>"+i);
		
		System.out.print("small==>"+i);
		System.out.println("\n TES11sss11T==>"+i);
		System.out.println("byte==>"+test.getBytes().length);
		//System.out.println("Size is "+ char.SIZE / 8);
		char tt     ='a';
		float t1 = 9.62f;
		float t2 = 8.82f;
		double t3 = 9.62;
		double t4 = 8.82;
		
		
		int b = new Integer(0);
		
		System.out.println(t1+t2);
		System.out.println(t3+t4);
		System.out.println(b);
		System.out.println(i);
	
		//Location.class..valueOf(""+ee);
		
//		Scanner info = new Scanner(System.in);
		System.out.println(10 + 17 % 3 + 4.2);
		
		int x = 5, y = 6; y+= x++;
		 System.out.println(x);
		 System.out.println(y);
		 
		 System.out.println("====");
		 System.out.println('a'+1);
		 System.out.println('A'-1);
		 System.out.println('w'-'a'+'A');
		 
		 char im = 162;
		 System.out.println(im);
		 
		 //System.out.println();
		 
		 
		 

//		 int a1 = -10;
//		 int b1 = -2;
//		 int c1 = 0;
//		 
//		 c1 = a1+b1;
//				 
//			DecimalFormat form = new DecimalFormat("#.##");
//			
//				 System.out.println();
//				 if ((a1 < 0) || (b1 < 0)) {
//					 
//					 System.out.println("error");
//					 
//					 return;
//				 }
		 
		 
		 
	}

	
}
