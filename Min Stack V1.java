// version 2, save more space. but space complexity doesn't change.
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public MinStack() {
    	stack = new Stack<Integer>():
    	minStack = new Stack<Integer>();
    }

    public void push(int number) {
    	stack.push(number);
    	if (minStack.empty() == true) {
    		minStack.push(number);
    	} else {
    		// if it equals it would push also
    		if (minStack.peek() >= number) {
    			minStack.push(number);
    		}
    	}   
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
        	minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
    	return minStack.peek();
    }
}
