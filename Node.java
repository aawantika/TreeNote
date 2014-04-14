import java.util.List;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;
    
    public Node(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public Node<T> getParent() {
        return parent;
    }
    
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    
    public List<Node<T>> getChildren() {
        return children;
    }
    
    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }
    
    public String toString() {
        String childrenString = "";
        for (Node<T> node : children) {
            childrenString += node.data  + " ";
        }

        return "data: " + data + ", parent: " + parent.data + ", children: " + childrenString; 
    }
}