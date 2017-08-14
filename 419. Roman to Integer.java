public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    // String I = "1";
    // String V = "5";
    // String X = "10";
    // String L = "50";
    // String C = "100";
    // String D = "500";
    // String M = "1000";

    
//     I	V	X	L	C	D	M
// 	    1	5	10	50	100	500	1,000
    public int romanToInt(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        
        int sum = 0;
        int first = convert(result[0]);
        
        for (int i = 1; i < s.length(); i++) {
            if (first < convert(result[i])) {
                sum = sum - first;
            } else {
                sum = sum + first;
            }
            first = convert(result[i]);
        }
        
        sum += first;
        return sum;
    }
    
    
    private int convert(char s) {
      switch(s) {
         case 'I' :
            return 1; 
         case 'V' :
             return 5;
         case 'X' :
             return 10;
         case 'L' :
             return 50;
         case 'C' :
             return 100;
         case 'D' :
             return 500;
         case 'M' :
             return 1000;
        }
        return 0;
    
    }
}



public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) {
                return 0;
        }
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int length = s.length();
        int result = m.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
                result += m.get(s.charAt(i));
            } else {
                result -= m.get(s.charAt(i));
            }
        }
        return result;
    }
}

/*
The use of the hash map and the possibility to reduce the length of the code 
*/