import java.util.*;

public class Test{
	public static void main(String[] args) {
		Node<String> main = new Node<String>("hello");

		List<Node<String>> list = new ArrayList<Node<String>>();
		Node<String> child1 = new Node<String>("child1");
		Node<String> child2 = new Node<String>("child2");
		Node<String> child3 = new Node<String>("child3");
		Node<String> child4 = new Node<String>("child4");
		Node<String> child5 = new Node<String>("child5");
		list.add(child1);
		list.add(child2);
		list.add(child3);
		list.add(child4);
		list.add(child5);

		main.setChildren(list);
		main.setParent(new Node<String>("root"));

		//System.out.println(main);

		String test = "> Penguins\n>> soft\n>> cuddly\n> Zebras\n>> tall\n>>>usually 5\n>> striped";
		String[] array = test.split("\\n");
	}
}