/*
    Given an expression s includes numbers, letters and brackets. Number
    represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.
 */

/*
    Example
    s = abc3[a] return abcaaa
    s = 3[abc] return abcabcabc
    s = 4[ac]dy, return acacacacdy
    s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadad
 */

/*
    Three main attributes of Stack:
        1. Store the temporary value
        2. Flip the sequence
        3. Prevent the stack overflow
 */

///////////
// Stack //
///////////

/* Mind those Objects conversion */
public class Solution {

    public String expressionExpand(String s) {
        ArrayDeque<Object> stack = new ArrayDeque<>(); /* Object stack */
        int number = 0; /* For getting the right amount */

        /* Traverse s by character */
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { /* Under the Character Object*/
                /* Convert char to int; From right to left sequence */
                number = number * 10 + c - '0';
            } else if (c == '[') { /* Push the number here */
                stack.push(Integer.valueOf(number)); /* Integer object */
                number = 0; /* Set the number back */
            } else if (c == ']') {
                /* Pop all strings before a number */                
                String newStr = popString(stack); 
                Integer count = (Integer) stack.pop(); /* Cast */
                /* Push back the timed 'long' str */
                for (int i = 0; i < count; i++) { 
                    stack.push(newStr);
                }
            } else { /* Pure String */
                stack.push(String.valueOf(c)); /* String object */
            }
        }

        return popString(stack); /* Pop all of the String at once */
    }

    private String popString(ArrayDeque<Object> stack) {
        /* For flip the sequence */
        ArrayDeque<String> buffer = new ArrayDeque<>();

        /* Pop all the necessary string to the buffer */ 
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop()); /* Cast */
        }

        /* SB is better for string concatenation */
        StringBuilder sb =  new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}

///////////////
// Recursion //
///////////////

public class Solution {

    public String expressionExpand(String s) {
        int number = 0;
        int parent = 0;
        String subString = "";
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (parent > 0) {
                    subString += c;        
                }
                parent++;
            } else if (c == ']') {
                parent--;
                if (parent == 0) {
                    String expandedString = expressionExpand(subString);
                    for (int i = 0; i < number; i++) {
                        sb.append(expandedString);
                    }
                    number = 0;
                    subString = "";
                } else {
                    subString += c;
                }
            } else if (c >= '0' && c <= '9') {
                if (parent == 0) {
                    number = number * 10 + c - '0';
                } else {
                    subString += c;
                }
            } else {
                if (parent == 0) {
                    sb.append(String.valueOf(c));
                } else {
                    subString += c;
                }
            }
        } 
        
        return sb.toString();
    }
}