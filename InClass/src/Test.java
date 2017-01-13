	/**
	 * 
	 */
	
	/**
	 * @author ssang_000
	 *
	 */
	public class Test {
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
			for (int j= 0; j < 8; j++) {
	
				if (j != 0) {
					System.out.print("\n");
				}
				for (int i= 0; i < 8; i++) {
		
					if (j%2==0) {
						System.out.print("* ");
					} else {
						System.out.print(" *");
						
					}
				}
	
			}
			

			
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4;
			int num5;
			
			System.out.println(num1);
			num4 = num1; 
			System.out.println(num4);
			
			num5 = num1; 
			System.out.println(num5);
			
			
			String hex = Integer.toHexString(17);
			System.out.println("Hex value is " + hex);			
			System.out.println("toBinaryString is " + Integer.toBinaryString(17));			
			System.out.println("toBinaryString is " + Integer.toUnsignedString(17));			
	  
		
		    String bin = "";
		    String binFragment = "";
		    int iHex;
		    hex = hex.trim();
		    hex = hex.replaceFirst("0x", "");

		    for(int i = 0; i < hex.length(); i++){
		        iHex = Integer.parseInt(""+hex.charAt(i),16);
		        binFragment = Integer.toBinaryString(iHex);

		        while(binFragment.length() < 4){
		            binFragment = "0" + binFragment;
		        }
		        bin += binFragment;
		
		System.out.println(bin);
		System.out.println(binFragment);
		
		
		    }
		    
		    int i = 10;

		    do

		    {

		    System.out.println( i++ );

		    }

		    while ( i < 10);		    
		
		}
	
	}
