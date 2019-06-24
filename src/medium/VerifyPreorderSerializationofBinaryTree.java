package medium;

import java.util.Stack;
/**
 * ClassName: VerifyPreorderSerializationofBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/6/24 11:54
 * Description: No.331
 *
 * 思路:
 *      1. stack 来模拟 DFS 搜索，每个元素记录子节点的个数
 *      2. 当节点的子节点数为 2 的时候就 pop 掉，让他的父节点，也就是栈顶元素 stack.push(stack.pop() + 1)
 *      3. 当遇到 stack 为空，缺还没有遍历完所有的节点的时候，说明这不是一棵树
 *          * 刚遇到 # 的时候判断当前 stack 是否为空，不为空就让栈顶元素 += 1， 为空就判断时候到达了最后一个节点，这样就出了 "#" 这种特殊情况
 *          * pop 到 satck 为空的时候判断，如果 i != nodes.length - 1 证明还没有到达最后一个节点，return false
 *      4. 最后返回 stack.isEmpty()
 *
 *
 */
public class VerifyPreorderSerializationofBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes =  preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            if ("#".equals(nodes[i])) {
                if (stack.isEmpty()) {
                    if (i != nodes.length - 1) return false;
                } else {
                    stack.push(stack.pop() + 1);
                }
                while (!stack.isEmpty() && stack.peek() == 2) {
                    stack.pop();
                    if (!stack.isEmpty()) stack.push(stack.pop() + 1);
                    else if (i != nodes.length - 1) return false;
                }
            } else {
                stack.push(0);
            }
        }
        return stack.isEmpty();
    }
   /* public static void main(String[] args) {
        VerifyPreorderSerializationofBinaryTree vpsbt = new VerifyPreorderSerializationofBinaryTree();
        String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        System.out.println(vpsbt.isValidSerialization(preorder));
    }*/

}
