/*    Block class
      Author:   Howard
	  Purpose:  this class models Duplo blocks
 */

public  class  Block {
	private  int  length;
	private  int  width;
	private  int  height;
	private  String colour;
	private  boolean hasWheels;
	private  boolean hasDoor;
	private  boolean hasEyes;

	// Default constructor
	public Block()
	{
		this(1,1,1,"white",false,false,false);		
	}

	// Initial constructor
	public Block (int l, int w, int h, String c, boolean hw, boolean hd, boolean he)
	{
		length=l;
		width=w;
		height=h;
		colour=c;
		hasWheels=hw;
		hasDoor=hd;
		hasEyes=he;
		System.out.print("Created ");
		view();
		System.out.println();
	}

	// Copy constructor
	public Block(Block block)
	{
		this(block.length,
			 block.width,
			 block.height,
			 block.colour,
			 block.hasWheels,
			 block.hasDoor,
			 block.hasEyes);		
	}


	// Place one on top of another
	public void placeOn (Block top)
	{ 
		System.out.print("Put "); 
		top.view();
		System.out.print("on top of "); 
		view();
		System.out.println();
	}

	// Rotate one 
	public void rotate ( ) 
	{
		prettyPrint("Rotate"); 
	}

	//	Move one ‘click?forward
	public void moveForward ( )
	{
		prettyPrint("Move one click forward"); 
	}

	//	Move one ‘click?backward
	public void moveBackward ( ) 
	{
		prettyPrint("Move one click backward"); 
	}

	//	View characteristics of one	
	public void view ( )
	{
		System.out.print(colour+" "+length+"x"+width+"x"+height+" ");
		if(hasWheels) System.out.print("with wheels ");
		if(hasDoor) System.out.print("with doors ");
		if(hasEyes) System.out.print("with eyes ");
	}

	// Pretty print an action
	private void prettyPrint(String action)
	{
		System.out.print(action+" "); 
		view();
		System.out.println();	
	}
}
