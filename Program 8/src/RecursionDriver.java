
public class RecursionDriver {
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length-1) {
				System.out.print(array[i]);
			}
			else {
				System.out.print(array[i] + ", ");
			}
		}
	}
	public static void main(String[] args) {
		
		int[] array = {2, 4, 6, 8, 10};
		Recursion r = new Recursion(array);
		
		int[] array2 = {2, 4, 6, 8, 10};
		Recursion r2 = new Recursion(array2);
		
		int[] array3 = {2, 4, 6, 8, 10};
		Recursion r3 = new Recursion(array3);
		
		int[] array4 = {2, 4, 6, 8, 10};
		Recursion r4 = new Recursion(array4);
		
		System.out.print("Original: [");
		printArray(array);
		System.out.println("]");
		System.out.println("reverseList(): " + r.reverseList(r.a));
		System.out.println("toOddList(): " + r2.toOddList(r2.a));
		System.out.println("toEvenRevList(): " + r3.toEvenRevList(r3.a));
		System.out.println("retPenultimate(): " + r4.retPenultimate(r4.a));
	}
}
