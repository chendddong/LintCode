
//////////////////////
// Shorter version  //
//////////////////////

public class MyQueue {
    private ArrayDeque<Integer> stack1;
    private ArrayDeque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        /* Only see if the stack we are going to pop element from empty or not
        */ 
        if (stack2.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.pop();
    }

    public int top() {
        /* same here */
        if (stack2.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.peek();
    }

    private void shiftOneToTwo() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

////////////////////
// longer version //
////////////////////

public class MyQueue {
    private ArrayDeque<Integer> stack1;
    private ArrayDeque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();            
        }
        
        if (!stack1.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.pop();
    }

    public int top() {
        if (!stack2.isEmpty()) {
            return stack2.peek();            
        }
        
        if (!stack1.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.peek();
    }

    private void shiftOneToTwo() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

