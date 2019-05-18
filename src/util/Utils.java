package util;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 工具类
 * @author chenyiAlone
 *
 */
public class Utils {
    /**
     * 将array数组中的p和q元素进行交换
     * @param array 
     * @param p 
     * @param q
     */
    public static void exch(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
    
    /**
     * 遍历打印数组的所有元素
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 遍历打印布尔数组的所有元素
     * @param array
     */
    public static void printArray(boolean[] array) {
        for (boolean t : array) {
            int  i = t ?  1 : 0;
            System.out.print(i + " ");
        }
        System.out.println();
    }
    /**
     * 
     * @param array
     */
    public static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }
    
    /**
     * 打印一个 Char 类型的二维数组
     */
    public static void printCharArray(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    /**
     * 初始化一个是否有序的数组
     * @param n     数组元素的个数
     * @param order 是否有序
     * @return array 
     */
    public static int[] initArray(int n, boolean order) {
        return order ? initArray(n) : shuffle(initArray(n));
    }
    
    /**
     * 初始化返回一个用于n个元素初始值为0-n的数组
     * @param n
     * @return
     */
    public static int[] initArray(int n) {
        int[] array = new int[n];
        while (n-- > 0) {
            array[n] = n;
        }
        return array;
    }
    
    public static int[] initArray(int ... nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        return array;
    }
    /**
     * 遍历打印ListNode
     * @param list  ListNode链表
     */
    public static void printListNodes(ListNode list) {
        while (list != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println("NULL");
    }
    
    /**
     * 初始化一个有n个结点的ListNode,结点的值为1-n
     * @param n
     * @return
     */
    public static ListNode initListNode(int n) {
        ListNode list = new ListNode(1);
        ListNode temp = list;
        for (int i = 2; i <= n; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return list;
    }
    public static ListNode initListNode(int ... nums) {
        ListNode list = new ListNode(0);
        ListNode temp = list;
        for (int i : nums) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return list.next;
    }
    // [1,2,3,null,null,4,5]
    public static TreeNode initTree(Integer ... nums) {
        TreeNode tree = null;
        Queue<TreeNode> queue = new LinkedList<>();
        tree = new TreeNode(nums[0]);
        queue.add(tree);
        int p = 1;
        while (!queue.isEmpty() && p != nums.length) {
            TreeNode t = queue.poll();
            t.left = p < nums.length && nums[p] != null ? new TreeNode(nums[p]) : null;
            p++;
            t.right = p < nums.length && nums[p] != null ? new TreeNode(nums[p]) : null;
            p++;
            if (t.left != null)
                queue.offer(t.left);
            if (t.right != null)
                queue.offer(t.right);
        }
        return tree;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.print((t == null ? null : t.val) + ", ");
            if (t != null) {
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }
        System.out.println();
    }

    /**
     * 将数组随机打乱
     * @param array
     * @return 
     */
    public static int[] shuffle(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int exch = (int)(Math.random()*(i+1));
            exch(array, i, exch);
        }
        return array;
    }

    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(null);
//        System.out.println(list.size());
//        TreeNode root = initTree(1,2,3,null,null,4,5);
//        printTree(root);
        System.out.println(Integer.parseInt("null"));

    }
}
