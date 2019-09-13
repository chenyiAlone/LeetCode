package medium;
/**
 * ClassName: ValidateIPAddress.java
 * Author: chenyiAlone
 * Create Time: 2019/9/13 19:05
 * Description: No.468 Validate IP Address
 * 思路:
 *      1. 判断位数 + 判断当前的取值是否符合范围
 *      2. 通过 . 和 : 分开处理 IPv4 和 IPv6
 *
 *
 *
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 *
 * Output: "IPv4"
 *
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * Output: "IPv6"
 *
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 *
 * Output: "Neither"
 *
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 */
public class ValidateIPAddress {

    private String ipv4(String str) {
        int cnt = 0, val = 0, dotCnt = 0;
        String ret = "IPv4";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                if (cnt == 0 || cnt > 3 || val > 255) return "Neither";
                dotCnt++;
                cnt = 0;
                val = 0;
            } else if ('0' <= c && c <= '9') {
                if (cnt != 0 && val == 0) return "Neither";
                val = val * 10 + c - '0';
                cnt++;
            } else {
                return "Neither";
            }
        }
        if (dotCnt != 3 || cnt == 0 || cnt > 1 && val == 0 || val > 255) return "Neither";
        return ret;
    }

    private String ipv6(String str) {
        int len = str.length(), dotCnt = 0;
        String ret = "IPv6";
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ':') {
                if (cnt > 4 || cnt == 0) return "Neither";
                dotCnt++;
                cnt = 0;
            } else {
                if ('a' <= c && c <= 'f' || 'A' <= c && c <= 'F' || '0' <= c && c <= '9')
                    cnt++;
                else return "Neither";
            }
        }
        if (dotCnt != 7 || cnt > 4 || cnt == 0) return "Neither";
        return ret;
    }


    public String validIPAddress(String IP) {
        int len = IP.length();
        String ret = "Neither";

        for (int i = 0; i < len; i++) {
            char c = IP.charAt(i);
            if (c == '.') return ipv4(IP);
            if (c == ':') return ipv6(IP);
        }
        return "Neither";
    }

}