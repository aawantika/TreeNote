import java.util.*;

public class Test{
	public static void main(String[] args) {
		String test = "> Penguins\n>> soft\n>> cuddly\n> Zebras\n>> tall\n>>> usually 5\n>> striped";

		TreeNote tree = new TreeNote();
		tree.add(test);
		System.out.println(tree.treeToString());

		System.out.println("false: " + tree.remove("Penguins"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("cuddly"));		
		System.out.println(tree.treeToString());

		System.out.println("false: " + tree.remove("tall"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("striped"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("usually 5"));		
		System.out.println(tree.treeToString());

		System.out.println("false: " + tree.remove("usually 5"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("soft"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("tall"));		
		System.out.println(tree.treeToString());

		System.out.println("true: " + tree.remove("Penguins"));		
		System.out.println(tree.treeToString());

		System.out.println("false: " + tree.remove("usually 5"));		
		System.out.println(tree.treeToString());
		// System.out.println("true: " + tree.contains("usually 5"));		
		// System.out.println("false: " + tree.contains("penguins"));		

	}
}