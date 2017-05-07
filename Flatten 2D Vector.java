// Example
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]

// By calling next repeatedly until hasNext returns false, the order of elements
// returned by next should be: [1,2,3,4,5,6].

public class Vector2D implements Iterator<Integer> {
    Stack<List<Integer>> stack = new Stack<>();
    Stack<Integer> stackj;

    void pushListListToStack(List<List<Integer>> vec2d) {
        Stack<List<Intger>> temp = new Stack<>();
        for (List<Integer> nested : vec2d) {
            temp.push(nested);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }        
    }

    void pushListToStack(List<Integer> vec) {
        Stack<Integer> temp = new Stack<>();
        for (Intger nested : vec) {
            temp.push(nested);
        }

        while (!temp.isEmpty()) {
            stackj.push(temp.pop());
        }
    }

    public Vector2D(List<List<Integer>> vec2d) {
        pushListListToStack(vec2d);
        stackj = new Stack<>();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        return stackj.pop();
    }x

    @Override
    public boolean hasNext() {
        while (stackj.isEmpty() && !stack.isEmpty()) {
            pushListTosStack(stack.pop());
        }
        return !stackj.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*
1.  This part is a bit tricky coz the stackj can be empty or not.

    public boolean hasNext() {
        while (stackj.isEmpty() && !stack.isEmpty()) {
            pushListTosStack(stack.pop());
        }
        return !stackj.isEmpty();
    }

2. Using Two stacks

3. The reason why this use the temp is to get the right order since we are
using the Stack!
    void pushListListToStack(List<List<Integer>> vec2d) {
        Stack<List<Intger>> temp = new Stack<>();
        for (List<Integer> nested : vec2d) {
            temp.push(nested);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }        
    }
*/



