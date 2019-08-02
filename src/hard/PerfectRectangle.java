package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: PerfectRectangle.java
 * Author: chenyiAlone
 * Create Time: 2019/8/2 23:49
 * Description: No.391 Perfect Rectangle
 * 思路:
 *          矩形除了四个顶点以外都只出现了一次
 *
 *          Point 散列使用两个不同的质数，能够更好完成散列，加速 hash
 *
 *      1. 将每个矩形的四个角都放入 map 中，保存最外层的两个点坐标用于求矩形的面积
 *      2. 判断总面积是否相同
 *      3. 检查合并后矩形的四个顶点的数目是否为 1，然后将其置为 0
 *      4. 检查所有的点出现的次数是否都为偶数
 *
 *
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 *
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 *
 *
 * Example 1:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [3,2,4,4],
 *   [1,3,2,4],
 *   [2,3,3,4]
 * ]
 *
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 *
 *
 *
 *
 * Example 2:
 *
 * rectangles = [
 *   [1,1,2,3],
 *   [1,3,2,4],
 *   [3,1,4,2],
 *   [3,2,4,4]
 * ]
 *
 * Return false. Because there is a gap between the two rectangular regions.
 *
 *
 *
 *
 * Example 3:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [3,2,4,4]
 * ]
 *
 * Return false. Because there is a gap in the top center.
 *
 *
 *
 *
 * Example 4:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [2,2,4,4]
 * ]
 *
 * Return false. Because two of the rectangles overlap with each other.
 */
public class PerfectRectangle {

    private static class Point {
        int x;
        int y;

        private Point() {}

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 17 * x + 31 * y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point other = (Point)obj;
            return x == other.x && y == other.y;
        }

    }


    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = minX;
        int maxX = Integer.MIN_VALUE, maxY = maxX;
        long total = 0;
        Map<Point, Integer> cnt = new HashMap<>();


        for (int[] rec : rectangles) {
            minX = Math.min(minX, rec[0]);
            minY = Math.min(minY, rec[1]);
            maxX = Math.max(maxX, rec[2]);
            maxY = Math.max(maxY, rec[3]);
            total += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            Point p1 = new Point(rec[0], rec[1]);
            Point p2 = new Point(rec[2], rec[3]);
            Point p3 = new Point(rec[0], rec[3]);
            Point p4 = new Point(rec[2], rec[1]);
            if (!cnt.containsKey(p1)) cnt.put(p1, 0);
            if (!cnt.containsKey(p2)) cnt.put(p2, 0);
            if (!cnt.containsKey(p3)) cnt.put(p3, 0);
            if (!cnt.containsKey(p4)) cnt.put(p4, 0);
            cnt.put(p1, cnt.get(p1) + 1);
            cnt.put(p2, cnt.get(p2) + 1);
            cnt.put(p3, cnt.get(p3) + 1);
            cnt.put(p4, cnt.get(p4) + 1);

        }
        long area = (maxX - minX) * (maxY - minY);
        if (area != total) return false;

        if (cnt.containsKey(new Point(minX, minY)) && cnt.get(new Point(minX, minY)) != 1) return false;
        if (cnt.containsKey(new Point(minX, maxY)) && cnt.get(new Point(minX, maxY)) != 1) return false;
        if (cnt.containsKey(new Point(maxX, minY)) && cnt.get(new Point(maxX, minY)) != 1) return false;
        if (cnt.containsKey(new Point(maxX, maxY)) && cnt.get(new Point(maxX, maxY)) != 1) return false;
        cnt.put(new Point(minX, minY), 0);
        cnt.put(new Point(minX, maxY), 0);
        cnt.put(new Point(maxX, minY), 0);
        cnt.put(new Point(maxX, maxY), 0);

        for (Point p : cnt.keySet()) {
            if (cnt.get(p) % 2 != 0) return false;
        }
        return true;
    }

}
