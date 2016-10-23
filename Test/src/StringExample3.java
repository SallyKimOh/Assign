

public class StringExample3 {
	public static void main (String [ ] args) {
		String name1 = "Billy";
		String name2 = name1;
		String name3 = new String(name1);
		System.out.println( name1+','+name2+','+name3);
		System.out.println(name1.equals(name2));
		System.out.println(name2.equals(name3));
		System.out.println(name1.equals(name3));
		System.out.println(name1==name2);
		System.out.println(name2==name3);
		System.out.println(name1==name3);
	}
}