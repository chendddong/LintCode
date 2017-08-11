/**
 * As the title described, you should only use two stacks to implement a
 * queue's actions.
 */

/*
    The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

    Both pop and top methods should return the value of first element.

    Have you met this question in a real interview? Yes
    Example
    push(1)
    pop()     // return 1
    push(2)
    push(3)
    top()     // return 2
    pop()     // return 2
 */

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

    /* Only push the element to 1 stack. */    
    public void push(int element) {
        stack1.push(element);
    }

    /* If stack2 is empty, throw all the elements from stack1 to stack2 */
    public int pop() {
        if (stack2.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.pop();
    }
    public int top() {
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