import java.util.List;
import java.util.ArrayList;

public class Node {

    private String data;
    private int height;
    private Node parent;
    private List<Node> children;
    
    public Node(String data) {
        this.data = data;
        children = new ArrayList<Node>();
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public List<Node> getChildren() {
        return children;
    }
    
    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return data.equals(((Node)obj).data);
        } 
        return false;
    }
    
    public String toString() {
        String childrenString = "";
        for (Node node : children) {
            childrenString += node.data  + " ";
        }

        return "data: " + data + ", height: " + height + ", parent: " + parent.data + ", children: " + childrenString; 
    }
}