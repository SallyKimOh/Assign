package cst8284.shape;

import java.util.ArrayList;


public class TestSolidObject2 {
	
	static ArrayList<SolidObject<BasicShape>> solidObjects = new ArrayList<>();
	   // TODO: define a new ArrayList of type SolidObject.  Call this array solidObjects.
		
	   public static void main(String[] args){
 
//	      Circle circle1 = new Circle(3.0);  // and use a depth = 5.0
//	      Square square1 = new Square(4.0);  // and use a depth = 2.0
//	      Rectangle rectangle1 = new Rectangle(2.0, 8.0); // and use a depth = 2.0
//	      Rectangle rectangle2 = new Rectangle(3.0, 5.0); // and use a depth = 2.0
//
//	      SolidObject<BasicShape> shapeCircle = new SolidObject<BasicShape>(new Circle(3.0), 1.0);
//	      SolidObject shapeSquare = new SolidObject<BasicShape>(new Square(4.0), 1.0);
//	      SolidObject shpaerectangle1 = new SolidObject<BasicShape>(new Rectangle(2.0, 8.0), 1.0);
//	      SolidObject shaperectangle2 = new SolidObject<BasicShape>(new Rectangle(3.0, 5.0), 1.0);
	      
	      solidObjects.add(new SolidObject<BasicShape>(new Circle(3.0), 5.0));
	      solidObjects.add(new SolidObject<BasicShape>(new Square(4.0), 2.0));
	      solidObjects.add(new SolidObject<BasicShape>(new Rectangle(2.0, 8.0), 2.0));
	      solidObjects.add(new SolidObject<BasicShape>(new Rectangle(3.0, 5.0), 2.0));
	      
//	      for(int i = 0; i < solidObjects.size(); ++i){
//	    	  
//	    	  System.out.println(solidObjects.get(i));
//	      }
	   
	      
	      // TODO: Create four new SolidObjects based on the four BasicShapes just defined (circle1, 
	      // square1, rectangle1, and rectangele2) using the two-arg SolidObject constructor, using the
	      // the depths indicated to the right of each definition above.  Then load each of these 
	      // SolidObjects into the solidObjects array you declared at top, i.e. using solidObjects.add(...);  
	      
	      // Alternately, rather than create four separate variables for each of the BasicShapes
	      // (as declared above) and then create four new SolidObjects (just described in the first half of 
	      // this TODO), and then finally load up each solid object into the array separately, you could 
	      // simply call the arrayList add() method four times, instantiating a new SolidObject() inside
	      // the add method's parentheses, while invoking the appropriate BasicShape and depth in the 
	      // SoldObjectconstructor's parameters.  Thus you can load the entire solidObject array in 4 lines 
	      // rather than the 12 lines that would otherwise be required.

			
	      displayVolumeComparison(solidObjects); 
	      displaySurfaceAreaComparison(solidObjects);

	   }
		
//	   private static void ArrayList() {
//		// TODO Auto-generated method stub
//		   
//		
//	}


		public static boolean isVolumeEqual(SolidObject<BasicShape> a,SolidObject<BasicShape> b){
			if(a.getVolumn() == b.getVolumn()){
				return true;
			}else{
				return false;
			}
		}
		
	// TODO: Create a public static method isVolumeEqual() that takes two SolidObjects as 
	   // parameters, and if they have the same volume, returns true, otherwise false.  This
	   // method is called by the displayVolumeComparison method, whose code is provided below.

		
		public static boolean isSurfaceAreaEqual(SolidObject<BasicShape> a,SolidObject<BasicShape> b){
			if(a.getSurfaceArea() == b.getSurfaceArea()){
				return true;
			}else{
				return false;
			}
			
		}
	   // TODO: Create a public static method isSurfaceAreaEqual() that takes two SolidObjects 
	   // as parameters and if they have the same surface area, returns true, otherwise false.  
	   // This method is called by the displayVolumeComparison method, whose code is provided below.

		
	   public static void displayVolumeComparison(ArrayList<SolidObject<BasicShape>> arList){
			
	      // Print out column header
	      System.out.println("\nCheck the array: are the volumes of the solid objects equal?\n");
	      System.out.print("\t\t");
	      
	      for (SolidObject<BasicShape> ColumnHeader: arList)
	         System.out.print("\t" + ColumnHeader.getName());
	      
			
		 // Print out each row,starting with the name of the object
		 for (SolidObject<BasicShape> solidObjRow: arList){
		    System.out.println();	// Next line
		    System.out.print(solidObjRow.getName());
	            for (SolidObject<BasicShape> solidObjColumn: arList)
	               System.out.print("\t\t" + isVolumeEqual(solidObjColumn, solidObjRow));
	         }    
	      }
		
	   public static void displaySurfaceAreaComparison(ArrayList<SolidObject<BasicShape>> arList){
			
	      // Print out column header
	      System.out.println("\nCheck the array: are the surface areas of the solid objects equal?\n");
	      System.out.print("\t\t");
	       for (SolidObject<BasicShape> ColumnHeader: arList)
	         System.out.print("\t" + ColumnHeader.getName());
			
	      // Print out each row,starting with the name of the object
	      for (SolidObject<BasicShape> solidObjRow: arList){
	         System.out.println();	// Next line
	         System.out.print(solidObjRow.getName());
	         for (SolidObject<BasicShape> solidObjColumn: arList)
	            System.out.print("\t\t" + isSurfaceAreaEqual(solidObjColumn, solidObjRow));  
	      }
	   }
	}
