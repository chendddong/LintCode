/*
    Implement a stack with min() function,
    which will return the smallest number in the stack.
    It should support push, pop and min operation all in O(1) cost.
*/

/*
     Notice

    min operation will never be called if there is no number in the stack.

    Example:
    push(1)
    pop()   // return 1
    push(2)
    push(3)
    min()   // return 2
    push(1)
    min()   // return 1
 */

///////////////////////////////
// Store the min ACCORDINGLY //
///////////////////////////////

public class MinStack {
    /* Using one to store temporary info */
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;
    
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    /* Always push to stack; Push the min to the minStack though */
    public void push(int number) {
        stack.push(number); 

        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    /* Walkthrough */

    // Example:
    // push(1)
    // pop()   // return 1
    // push(2)
    // push(3)
    // min()   // return 2
    // push(1)
    // min()   // return 1

    // stack: [1 2 3 1
    //        x
    // minStack: [1 2 2 1
    //           x   
    public int pop() { /* Pop both */
        minStack.pop();
        return stack.pop();
    }
    public int min() { 
        return minStack.peek();
    }
}

///////////////////////////////////
// Save a bit when store the min //
///////////////////////////////////

public class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            /* Only update the min when necessary */
            if (minStack.peek() >= number) {
                minStack.push(number);
            }
        }   
    }

    public int pop() {
        /* Pop the min when necessary */
        if (stack.peek().equals(minStack.peek())) { /* Compare Objects */
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
