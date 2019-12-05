package easy;

/**
 * ClassName: QuadTreeIntersection.java
 * Author: chenyiAlone
 * Create Time: 2019/12/5 16:03
 * Description: No.558 QuadTree Intersection
 */
public class QuadTreeIntersection {
    
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) 
            return quadTree1.val ? quadTree1 : quadTree2;
        else if (quadTree2.isLeaf) 
            return quadTree2.val ? quadTree2 : quadTree1;
        else {
            Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tr.val == bl.val && bl.val == br.val)
                return tl;
            return new Node(false, false, tl, tr, bl, br);
        }                    
    }
    
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    
}