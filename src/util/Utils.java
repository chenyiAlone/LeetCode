package util;


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
}
