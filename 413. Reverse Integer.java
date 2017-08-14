public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        int reversed_n = 0;
        
        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
}

// 321 --> 123
// reversed_n = 0
// temp = 0 + 1 = 1
// n = 32

// reversed_n = 1
// temp = 10 + 2 = 12
// n = 3

// reversed_n = 12
// temp = 120 + 3 =123
// n = 0

