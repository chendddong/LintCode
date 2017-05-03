public class Solution {
	// http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}

    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0;
    	for (int i = 0; i <= height.length; i++) {
    	    int curt;
    		if (i == height.length) {
    			curt = -1;
    		} else {
    			curt = height[i];
    		}
    		while (!stack.isEmpty() && curt <= height[stack.peek()]) {
    			int h = height[stack.pop()];
    			int w;
    			if (stack.isEmpty()) {
    				w = i;
    			} else {
    			    // important
    				w = i - stack.peek() - 1;
    			}
    			max = Math.max(max, h * w);
    		}
    		stack.push(i);
    	}
    	return max;
    }
}
