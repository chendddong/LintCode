public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // need a stack and it can be anything so we use Object
        Stack<Object> stack = new Stack<>();
        // for manipulate the number latter;
        int number = 0;
        // taverse all the String in the 'big String'
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // how to manipulate between char and int;
                number = number * 10 + c - '0';
            } else if (c == '[') {
                // manipulate between 
                stack.push(Integer.valueOf(number));
                number = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            } else {
                //how to manipulate between char and int;
                stack.push(String.valueOf(c));
            }
        }

        return popStack(stack);
    }

    private String popStack(Stack<Object> stack) {
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }

        StringBuilder sb =  new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}