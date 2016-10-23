/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class Duplo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Block red = new Block(6,2,1,"Red",true,false,false);
		Block blue = new Block(4,2,1,"Blue",false,false,false);
		red.placeOn(blue);
		red.rotate();
		Block green = new Block(4,2,2,"Green",false,false,true);
		blue.placeOn(green);
		
		Block yellow = new Block(2,2,1,"Yellow",false,false,false);
		green.placeOn(yellow);
		
	}

}
