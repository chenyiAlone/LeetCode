package medium;

import java.util.Stack;
/**
 * 
 * ClassName: SimplifyPath
 * @author chenyiAlone  
 * Create Time: 2019/01/27 21:36:31
 * Description: No.71
 * 总结：
 *     1. 正则表达式分割字符串,以"/+"匹配掉多余的"/"
 *     2. stack 为空的时候需要return "/"
 *     
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

    In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
    
    Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
    
     
    
    Example 1:
    
    Input: "/home/"
    Output: "/home"
    Explanation: Note that there is no trailing slash after the last directory name.
    Example 2:
    
    Input: "/../"
    Output: "/"
    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
    Example 3:
    
    Input: "/home//foo/"
    Output: "/home/foo"
    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
    Example 4:
    
    Input: "/a/./b/../../c/"
    Output: "/c"
    Example 5:
    
    Input: "/a/../../b/../c//.//"
    Output: "/c"
    Example 6:
    
    Input: "/a//b////c/d//././/.."
    Output: "/a/b/c"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) return "/";
        String[] strs = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.equals(".")) {
                
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals("")){
                stack.push(str);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += "/" + stack.pop();
        }
        if (res.length() == 0) return "/";
        return res;
    }
    
    public static void main(String[] args) {
        String path = "/home//foo";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }
}
