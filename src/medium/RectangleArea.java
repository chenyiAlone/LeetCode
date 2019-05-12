package medium;
/**
 * ClassName: RectangleArea.java
 * Author: chenyiAlone
 * Create Time: 2019/5/12 13:17
 * Description: No.223
 * 思路:
 *      1. 分别求出相交矩形的对应该种命名方式的坐标位置 (a, b) (c, d)
 *      2. c = max(min(C, G), a)
 *         d = man(min(D, H), b)
 *
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        int y1 = 0, y2 = 0, x = 0;
        int a = Math.max(A, E), b = Math.max(B, F), c = Math.max(a, Math.min(C, G)), d = Math.max(b, Math.min(D, H));
        int area = (c - a) * (d - b);
        return total - area;
    }
}
