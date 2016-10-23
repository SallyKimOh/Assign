/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class Test123 {

	   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      
		   int firstArg = 0;
			   
		   if(args.length > 0) {
			   
			   try{
				   firstArg = Integer.parseInt(args[0]);
			   
			   } catch(Exception e){
				      System.err.println("Argument" +args[0] + "must be an integer.");
				      System.exit(1);
			   }
		   System.out.println("You entered" + firstArg);
			   
		   }

	   }
	
}
