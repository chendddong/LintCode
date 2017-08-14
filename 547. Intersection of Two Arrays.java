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

// version 1: sort & merge
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }

        return result;
    }
}

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

        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                continue;
            }
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        
        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return true;
        } 

        if (nums[end] == target) {
            return true;
        }

        return false;
    }
}