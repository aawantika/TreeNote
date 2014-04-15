import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TreeNote {

	private Node root;
	private Node currentNode;
	private int level;

	public TreeNote() {
		root = new Node("root");
		root.setHeight(0);
		level = 0;
	}

	// Adds a input of String to the tree.
	public void add(String input) {
		String[] array = input.split("\\n");
		ArrayList<Integer> branchIndex = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			String element = array[i];
			if (element.substring(0,2).equals("> ")) {
				branchIndex.add(i);
			}
		} 

		for (int i = 0; i < array.length; i++) {
			String element = array[i];
			int numOfLevels = element.indexOf(" ");
			element = element.substring(numOfLevels + 1);
			level = 2;
			if (branchIndex.contains(i)) {
				level = 1;
				root = addNewBranch(element);
			} else {
				currentNode = addHelper(currentNode, element, numOfLevels);
			}
		}
	}

	// Helper method figures out where to place the new node and adds it.
	private Node addHelper(Node current, String data, int numOfLevels) {
		List<Node> currentChildren = current.getChildren();
		if (numOfLevels == level) {
			Node newNode = new Node(data);
			newNode.setParent(current);
			newNode.setHeight(level);
			currentChildren.add(newNode);
		} else if ( numOfLevels > level) {
			level++;
			addHelper(current.getChildren().get(0), data, numOfLevels);
		} else {
			level++;
			addHelper(current.getParent(), data, numOfLevels);
		}
		return current;
	}

	// Adds a new branch to the tree.
	private Node addNewBranch(String data) {
		List<Node> currentChildren = root.getChildren();
		Node newNode = new Node(data);
		newNode.setParent(root);
		newNode.setHeight(1);
		currentChildren.add(newNode);
		currentNode = newNode;
		return root;
	}

	public boolean remove(String data) {
		Node removeNode = get(data);
		boolean removeSuccessful = false;
		if (removeNode != null && removeNode.getChildren().size() == 0) {
			Node parent = removeNode.getParent();
			List<Node> parentsChildren = parent.getChildren();
			Node temp = new Node(data);
			int index = parentsChildren.indexOf(temp);
			parentsChildren.remove(index);
			removeSuccessful = true;
		}

		return removeSuccessful;
	}

	// Checks if the tree contains a piece of text
	// Uses the get method to traverse through the tree
	public boolean contains(String data) {
		Node node = get(data);
		if (node != null) {
			return true;
		}
		return false;
	}

	// Gets the node from the tree using DFS
	// Null if the node doesn't exist in tree
	public Node get(String data) {
		boolean found = false;
		Node foundNode = null;
		List<String> list = new ArrayList<String>();
		Stack<Node> stack = new Stack<Node>();
		List<Node> childrenList = root.getChildren();

		for (int i = 0; !found && (i < childrenList.size()); i++) {
			Node node = childrenList.get(i);
			if (node.getData().equals(data)) {
				foundNode = node;
				found = true;
			} else {
				stack.push(node);
			}
		}

		while(!stack.isEmpty() && !found) {
			Node tempNode = stack.pop();
			int height = tempNode.getHeight();

			String carrot = ">";
			while (height > 1) {
				carrot = carrot + ">";
				height--;
			}
			carrot += " ";

			list.add(carrot + tempNode.getData());
			childrenList = tempNode.getChildren();
			for (Node node : childrenList) {
				if (node.getData().equals(data)) {
					foundNode = node;
					found = true;
				} else {
					stack.push(node);
				}
			}
		}

		return foundNode;
	}

	// Converts the tree to a String with proper newlines and >
	public List<String> treeToString() {
		List<String> list = new ArrayList<String>();
		Stack<Node> stack = new Stack<Node>();
		list = stringHelper(root, list, stack);

		// StringBuilder sb = new StringBuilder();
		// for (String item : list) {
		// 	sb.append(item + "\n");
		// }
		// return sb.toString();

		return list;
	}

	// Helper that goes through entire tree and adds it to a arraylist.
	// Uses DFS to traverse through the tree.
	private List<String> stringHelper(Node current, List<String> list, Stack<Node> stack) {
		List<Node> childrenList = current.getChildren();
		for (int i = childrenList.size() -1; i > -1; i--) {
			stack.push(childrenList.get(i));
		}

		while(!stack.isEmpty()) {
			Node tempNode = stack.pop();
			int height = tempNode.getHeight();

			carrot += " ";

			list.add(carrot + tempNode.getData());
			childrenList = tempNode.getChildren();
			for (int i = childrenList.size() -1; i > -1; i--) {
				stack.push(childrenList.get(i));
			}
		}

		return list;
	}
}