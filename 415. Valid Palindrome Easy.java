/////////////////////////////
// Solution 1 two pointers //
/////////////////////////////

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }

            /* empty string */
            if (start == s.length()) {
                return true;
            }

            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase
                (s.charAt(end))) {
                break;
            } else {
                start++;
                end--;
            }
        }

        return end <= start;
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

////////////////////////////////////////////////
// Solution 2 StringBuilder & stack and queue //
////////////////////////////////////////////////

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }

        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        /* Clean the String. It's ok if it is a number*/
        String[] words = s.toLowerCase().split("[ \n\t\r.,;:!?(){]");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        /* Put Character to stack and queue */
        for (Character ch : sb.toString().toCharArray()) {
            stack.push(ch);
            queue.offer(ch);
        }

        for (int i = 0; i < stack.size(); ++i) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}

///////////////////////////////////////////////
// Solution 3 Clean String with two pointers //
///////////////////////////////////////////////

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s == "") {
            return true;
        }

        String[] words = s.toLowerCase().split("[ \n\t\r.,;:!?(){]");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        String cleanS = sb.toString();

        int i = 0;
        int j = cleanS.length() - 1;

        while (i <= j) {
            if (cleanS.charAt(i) != cleanS.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}


///////////////////////////////////////////////////////
// Solution 4 Clean String + StringBuilder.reverse() //
///////////////////////////////////////////////////////

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }

        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        /* Clean the String. It's ok if it is a number*/
        String[] words = s.toLowerCase().split("[ \n\t\r.,;:!?(){]");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        
        String str = sb.toString();
        String reversed = sb.reverse().toString();
        
        return str.equals(reversed);
    }
}