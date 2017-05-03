public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    // we are using two stacks to revert the sequence
    // 
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }

    private void stack2ToStack1() {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }
}