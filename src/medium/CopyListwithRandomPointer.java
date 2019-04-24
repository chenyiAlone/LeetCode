package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
/**
 * 
 * ClassName: CopyListwithRandomPointer
 * @author chenyiAlone  
 * Create Time: 2019/04/24 17:57:14
 * Description: No.138
 * 思路:
 * time: O(n), space: O(n)
 * 
 *   ps: 自己写的方法开了 
 *          map=> 储存 copy 对象 
 *          set=> 记录被遍历过得元素 
 *          linkelist=> 遍历
 *          
 *   1. 首先检查 map 中是否含有这个元素，如果有就取出来，没有就 new 一个Copy 的对象并将它放进 map
 *   2. 同样的方法检查 next + random ，将 copy 对象组合起来
 *   3. 将这个 copy 完成的 Node 放入 set 避免重复 copy
 *  
 *  
 * time: O(n), space: O(1)
 *   . 三次遍历
 *   1. node1->copy1->node2->copy2....
 *               +-------------v 
 *   2. node1->copy1->node2->copy2...
 *        +-------------^
 *   3. 
 * 
 * 
 */
public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Node next, iter = head;
        while (iter != null) {
            next = iter.next;
            Node copy = new Node();
            copy.val = iter.val;
            iter.next = copy;
            copy.next = next;
            iter = next;            
        }
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        iter = head;
        Node res = new Node();
        Node cur = res;
        while (iter != null) {
            cur.next = iter.next;
            cur = cur.next;
            iter.next = iter.next.next;
            iter = iter.next;
        }
        return res.next;
    }
    
    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        LinkedList<Node> que = new LinkedList<>();
        Set<Integer> trace = new HashSet<>();
        que.offer(head);
        while (!que.isEmpty()) {
            Node n = que.poll();
            int val = n.val;   
            if (!trace.contains(val)) {
                Node cur = null;
                if (map.containsKey(val)) {
                    cur = map.get(val);
                } else {
                    cur = new Node();
                    cur.val = val;
                    map.put(val, cur);
                }
                if (n.next != null) {
                    que.offer(n.next);   
                    int next_val = n.next.val;
                    Node cur_next = null;
                    if (map.containsKey(next_val)) {
                        cur_next = map.get(next_val);
                    } else {
                        cur_next = new Node();
                        cur_next.val = next_val;
                        
                        map.put(next_val, cur_next);
                    }
                    cur.next = cur_next;
                }    
                if (n.random != null) {
                    que.offer(n.random);
                    int random_val = n.random.val;
                    Node cur_random = null;
                    if (map.containsKey(random_val)) {
                        cur_random = map.get(random_val);
                    } else {
                        cur_random = new Node();
                        cur_random.val = random_val;
                        
                        map.put(random_val, cur_random);
                    }
                    cur.random = cur_random;
                }
                trace.add(val);
            }
        }
        return map.get(head.val);
    }
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
