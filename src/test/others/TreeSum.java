package test.others;

import static util.Utils.printArray;

public class TreeSum {


    public static void main(String[] args) {
        int target = 4;
        int[] arr = {4, 1, -2, 1, 3};
        int len = arr.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] += prefix[i] + arr[i];
        }
        int begin = -1, end = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (prefix[j] - prefix[i] == target && (j - i > end - begin)) {
                    begin = i;
                    end = j;
                }
            }
        }
        System.out.print("res: ");
        for (int i = begin; i < end; i++) {
            System.out.print(" " + arr[i]);
        }
//        System.out.println(begin + ", " + end);
//        System.out.println(ret);
    }
}
