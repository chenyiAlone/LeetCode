package easy;

import java.util.*;

/**
 * ClassName: ReplaceElementswithGreatestElementonRightSide.java
 * Author: chenyiAlone
 * Create Time: 2019/1/9 22:40 
 * Description: No.1299 Replace Element swith Greatest Elementon Right Side
 */
public class ReplaceElementswithGreatestElementonRightSide {

    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, right = -1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = right;
            right = Math.max(temp, right);
        }
        return arr;
    }

}