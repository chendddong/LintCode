public class Solution {
   public int myAtoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
            
        int sign = 1;
        int index = 0;
    
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        long num = 0;
        for (; index < str.length(); index++) {
            // 这个判断表示 字符必须处于0~9之间，否则break不继续处理了，也就是存在非法的字符串，如“1234AB9”
            // 那么到A的时候，就会出现不在字符0~9之间了。
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }   
        
        
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}

/*
Handle the number correctly
Use long when int is not enough
Just be careful about everything
*/