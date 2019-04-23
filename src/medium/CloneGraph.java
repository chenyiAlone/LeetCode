package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * ClassName: Node
 * @author chenyiAlone  
 * Create Time: 2019/04/23 22:10:08
 * Description: No.133
 * 
 * 
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
    
     
    
    Example:
    
    
    
    Input:
    {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
    
    Explanation:
    Node 1's value is 1, and it has two neighbors: Node 2 and 4.
    Node 2's value is 2, and it has two neighbors: Node 1 and 3.
    Node 3's value is 3, and it has two neighbors: Node 2 and 4.
    Node 4's value is 4, and it has two neighbors: Node 1 and 3.
     
    
    Note:
    
    The number of nodes will be between 1 and 100.
    The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
    Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
    You must return the copy of the given node as a reference to the cloned graph.
 */
class Node {
    int val;
    List<Node> neighbors;
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        LinkedList<Node> que = new LinkedList<>();
        Set<Integer> trace = new HashSet<>();
        que.offer(node);
        while (!que.isEmpty()) {
            Node n = que.poll();
            int val = n.val;
            Node temp = null;
            if (map.containsKey(val)) {
                temp = map.get(val);
                
            } else {
                temp = new Node(val, new ArrayList<Node>());
                map.put(val, temp);
            }
            if (!trace.contains(val)) {
                for (Node t : n.neighbors) {
                    que.offer(t);
                    int t_val = t.val;
                    Node cur = null;
                    if (map.containsKey(t_val)) {
                        cur = map.get(t_val);
                    } else {
                        cur = new Node(t_val, new ArrayList<Node>());
                        map.put(t_val, cur);
                    }
                    temp.neighbors.add(cur);
                }
                
            }    
            trace.add(val);            
        }  
        return map.get(node.val);
    }
}