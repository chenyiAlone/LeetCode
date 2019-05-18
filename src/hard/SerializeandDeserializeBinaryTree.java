package hard;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SerializeandDeserializeBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/5/18 13:18
 * Description: No.297
 * 思路:
 *      1. * 作为 null
 *      2. DFS
 *
 *      ------------- 踩到的坑 --------------------
 *      想利用先序和中序遍历得到的结果来构造二叉树来着
 *      结果他们的值可能相同，没注意这点，所以就掉进了这个坑里，写出了方案，但是不不能处理有重复，且前后逆序的二叉树
 *
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 */
public class SerializeandDeserializeBinaryTree {

    private int index = 0;
    private String rootToString(TreeNode root) {
        if (root == null)
            return "* ";
        String res = root.val + " ";
        res += rootToString(root.left);
        res += rootToString(root.right);
        return res;

    }

    private TreeNode stringToTreeNode(String[] nodes) {
        if (nodes[index].equals("*"))
            return null;
        TreeNode t = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        t.left = stringToTreeNode(nodes);
        index++;
        t.right = stringToTreeNode(nodes);
        return t;
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rootToString(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        index = 0;
        return stringToTreeNode(nodes);
    }


    private class SerializeandDeserializeBinaryTreeError {
        private List<Integer> preorder = new ArrayList<>();
        private List<Integer> inorder = new ArrayList<>();

        private int point = 0;

        private void trace(TreeNode root) {
            preorder.add(root.val);
            if (root.left != null) {
                trace(root.left);
            }
            inorder.add(root.val);
            if (root.right != null)
                trace(root.right);
        }

        private TreeNode build(int lb, int rb) {
            if (lb > rb)
                return null;
            if (lb == rb) {
                point++;
                return new TreeNode(inorder.get(lb));
            }
            int cur = -1;
            for (int i = lb; i <= rb && rb >= 0; i++) {
                if (inorder.get(i).equals(preorder.get(point))) {
                    cur = i;
                    break;
                }
            }
            if (cur == -1)
                return null;
            TreeNode temp;
            point++;
            temp = new TreeNode(inorder.get(cur));
            TreeNode left = build(lb, cur - 1);
            TreeNode right = build(cur + 1, rb);
            temp.left = left;
            temp.right = right;
            System.out.println("  " + temp.val + "\n"
                    + " /" +  "\\ \n"
                    + (left == null ? null : left.val) + "  " + (right == null ? null : right.val));
            return temp;
        }

        private void stringToTree(String data) {
            preorder = new ArrayList<>();
            inorder = new ArrayList<>();
            String[] nums = data.split(" ");
            int len = nums.length / 2;
            System.out.println(len);
            for (int i = 0; i < len; i++) {
                preorder.add(Integer.parseInt(nums[i]));
                inorder.add(Integer.parseInt(nums[i + len]));
            }
        }

        private String treeToString() {
            StringBuilder res = new StringBuilder();
            for (int i : preorder)
                res.append(i).append(" ");
            for (int i : inorder)
                res.append(i).append(" ");
            res.setLength(res.length() - 1);
            System.out.println(res.toString());
            return res.toString();
        }


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            point = 0;
            preorder = new ArrayList<>();
            inorder = new ArrayList<>();
            trace(root);
            System.out.println(preorder);
            System.out.println(inorder);
            point = 0;
            return treeToString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            stringToTree(data);
            System.out.println("perv = " + preorder);
            System.out.println("inorder = " + inorder);
            System.out.println("preorder.size() = " + preorder.size());
            return build(0, preorder.size() - 1);
        }

        /**
         *       3
         *      / \
         *     2   3
         *    /
         *   4
         * @param args
         */
        /*
        public static void main(String[] args) {
            TreeNode root = Utils.initTree(3,2,4,3);
            Utils.printTree(root);
            SerializeandDeserializeBinaryTreeOld ser = new SerializeandDeserializeBinaryTreeOld();
            String s = ser.serialize(root);
            TreeNode deserTree = ser.deserialize(s);
            Utils.printTree(deserTree);
        }
        */
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}