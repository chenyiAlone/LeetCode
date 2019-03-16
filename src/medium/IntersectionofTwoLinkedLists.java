package medium;

import util.ListNode;
/**
 * 
 * ClassName: IntersectionofTwoLinkedLists
 * @author chenyiAlone  
 * Create Time: 2019/03/16 21:11:41
 * Description: No.160
 * 总结：
 *   思路是两个指针，走到末尾的时候，然后再指向没有走到尾的链表，然后没走到尾的指针走到尾，
 *   这样后面更新的那个指针就已经和另一个链表(短的)等长了，然后只需要走到相同的结点返回，如果没有就返回 null
 */
public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = util.Utils.initListNode(4, 2, 8, 4, 5);
        ListNode headB = util.Utils.initListNode(5, 0, 1, 8, 4, 5);
        System.out.println(new IntersectionofTwoLinkedLists().getIntersectionNode(headA, headB));
    }
    public ListNode getIntersectionNodeDemo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA: pB.next;
        }
        return pA;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a1 = headA, a2 = headB;
        while (a1 != null && a2 != null) {
            a1 = a1.next;
            a2 = a2.next;
        }
        ListNode a;
        if (a1 == null) {
            a = headB;
            while (a2 != null) {
                a = a.next;
                a2 = a2.next;
            }
            a1 = headA;
            while (a != null && a1 != null && a.val != a1.val) {
                a = a.next;
                a1 = a1.next; 
            }
            if (a != null && a1 != null && a.val == a1.val) {
                return a;
            } else {
                return null;
            }
        } else {
            a = headA;
            while (a1 != null) {
                a = a.next;
                a1 = a1.next;
            }
            a2 = headB;
            while (a != null && a2 != null && a.val != a2.val) {
                a = a.next;
                a2 = a2.next;
            }
            if (a != null && a2 != null && a.val == a2.val) {
                return a;
            } else {
                return null;
            }
        }
    }
}
