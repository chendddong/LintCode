// Given two arrays, write a function to compute their intersection.

//  Notice

// Each element in the result must be unique.
// The result can be in any order.
// Example
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
// The hashSet!!!

// use two hashset
// how to copy item from hashset to array

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null) {
    		return null;
    	}

    	HashSet<Integer> hash = new HashSet<>();
    	for (int i = 0; i < nums1.length; i++) {
    		hash.add(nums1[i]);
    	}
    	HashSet<Integer> resultHash = new HashSet<>();
    	for (int i = 0; i < nums2.length; i++) {
    		if (hash.contains(nums2[i]) && !resultHash.contains(num2[i])) {
    			resultHash.add(nums2[2]);
    		}
    	}

    	int size = resultHash.size();
    	int[] result = new int[size];
    	int index = 0;
    	// how to copy item from hashset to array
    	for (Integer num : resultHash) {
    		result[index++] = num;
    	}

    	return result;

    }
}