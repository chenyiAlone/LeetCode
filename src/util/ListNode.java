package util;
/**
 * 
 * ClassName: ListNode
 * @author chenyiAlone  
 * Create Time: 2018/11/30 11:43:57
 * Description: LeetCode题目中定义的类
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x; 
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder("[");
        ListNode t = this;
        while (t != null && t.next != null) {
            sb.append(t.val + ", ");
            t = t.next;
        }
        sb.append(t.val + "]");
        return sb.toString();
    }
}
