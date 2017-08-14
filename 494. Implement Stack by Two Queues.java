class Stack {
    // as the question stated, we need two queues

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // [instantiate added]
    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    // [added]
    private void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }

    private void swapQueues() {
        // when we swap we have to focus on queue1 and queue2
        // be cautious on this
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Push a new item into the stack
    public void push(int x) {
        queue1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }

    // Return the top of the stack
    public int top() {
        moveItems();
        int item = queue1.poll();
        swapQueues();
        // we have to put the item back...
        queue1.offer(item);
        return item;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return queue1.isEmpty();
    }    
}