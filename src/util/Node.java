package util;

import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    
    public List<Node> children;
    public Node(int val) {
        this.val = val;
    }
}
