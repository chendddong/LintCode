     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();



        // we have to split the string first and use the regex
        String[] words = s.toLowerCase().split("[ \n\t\r.,;:!?(){]");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        String cleanS = sb.toString();
        char[] charArry = cleanS.toCharArray();
        
        for (Character ch : charArry) {
            stack.push(ch);
            queue.offer(ch);
        }
        
        for (int i = 0; i < charArry.length; i++) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        
        return true;
        
        
    }
    
    
}