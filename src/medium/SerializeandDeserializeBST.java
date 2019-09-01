package medium;

import util.TreeNode;
/**
 * ClassName: SerializeandDeserializeBST.java
 * Author: chenyiAlone
 * Create Time: 2019/9/1 19:34
 * Description: No.449
 * 思路:
 *      1. 使用空格分隔便于后面恢复的时候拆解成一个个的结点
 *      2. 使用 # 来表示 null 的叶子节点
 *      3. dfs() 来完成对其的遍历
 *
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 */
public class SerializeandDeserializeBST {

    private int index = 0;
    private StringBuilder str = new StringBuilder();

    private void dfsSer(TreeNode root) {
        if (root == null) {
            str.append('#').append(" ");
            return;
        }
        str.append(root.val).append(" ");
        dfsSer(root.left);
        dfsSer(root.right);
    }


    private TreeNode dfsDes(String[] ns) {
        if ("#".equals(ns[index])) {
            index++;
            return null;
        }
        int val = Integer.parseInt(ns[index++]);
        TreeNode root = new TreeNode(val);
        root.left = dfsDes(ns);
        root.right = dfsDes(ns);
        return root;
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        str.setLength(0);
        dfsSer(root);
        System.out.println(str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] ns = data.split(" ");
        return dfsDes(ns);
    }
}
