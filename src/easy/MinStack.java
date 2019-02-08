package easy;
/**
 * 
 * ClassName: MinStack
 * @author chenyiAlone  
 * Create Time: 2019/02/08 22:26:23
 * Description: No.155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    public int index = -1;
    
    public int current = -1;
    
    public int min = Integer.MAX_VALUE;
    
    public static int capacity = 1000;
    
    public int[] stack;
    
    public int[] minIndex;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[capacity];
        minIndex = new int[capacity];
    }
    
    public void push(int x) {
        current++;
        if (current >= stack.length) {
            int[] tmp = new int[current * 2];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;
            
            tmp = new int[current * 2];
            System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
            minIndex = tmp;
        }
        stack[current] = x;
        
        if (x < min) {
            min = x;
            index = current;
        }
        minIndex[current] = index;
    }
    
    public void pop() {
        current--;
        if (current >= 0) {
            min = stack[minIndex[current]];
            index = minIndex[current];
        }
    }
    
    public int top() {
        return stack[current];
    }
    
    public int getMin() {
        return stack[minIndex[current]];
    }
}
