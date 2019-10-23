package easy;

import util.*;
import java.util.*;

/**
 * ClassName: EmployeeImportance.java
 * Author: chenyiAlone
 * Create Time: 2019/10/23 23:29
 * Description: No.690 Employee Importance
 */
public class EmployeeImportance {
  
    private int ret;
    private Map<Integer, Employee> map = new HashMap<>();
    private void dfs(Employee e) {
        ret += e.importance;
        for (int i : e.subordinates)
            dfs(map.get(i));
    }
    
    public int getImportance(List<Employee> employees, int id) {
        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(map.get(id));    
        return ret;
    }
}