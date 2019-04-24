package medium;
/**
 * 
 * ClassName: GasStation
 * @author chenyiAlone  
 * Create Time: 2019/04/24 17:50:24
 * Description: No.134
 * 思路:
 *   1. 环形路径=> %
 *   2. gas_total 车上的 gas 余量
 *   3. 判断是能都能否到达下一个位置，只有当 j > i 时才更新 i 为 j 
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int gas_total = 0;
            int j = i;
            while (j < len) {
                if (gas_total + gas[j] >= cost[j]) {
                    gas_total = gas_total - cost[j] + gas[j];
                } else {
                    break;
                }
                if ((j + 1) % len == i) {
                    return i;
                }
                j = (j + 1) % len;
            }
            if (i < j)
                i = j;
            /*
             for (int j = i; j < len; j = (j + 1) % len) {
                 if (gas_total + gas[j] >= cost[j]) {
                     gas_total = gas_total - cost[j] + gas[j];
                 } else {
                     break;
                 }
                 if ((j + 1) % len == i) {
                     return i;
                 }
             }
             */
        }
        return -1;
    }
}