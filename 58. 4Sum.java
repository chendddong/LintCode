// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.

// Inputs int[] nums, int target
// Outputs ArrayList<ArrayList<Integer>> results;

// corner cases 

// the run time for this one is O(n)

// public class Solution {
//     /**
//      * @param numbers : Give an array numbersbers of n integer
//      * @param target : you need to find four elements that's sum of target
//      * @return : Find all unique quadruplets in the array which gives the sum of
//      *           zero.
//      */
//     public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
//         ArrayList<ArrayList<Integer>> results = new ArrayList<>();
//         if (numbers == null || numbers.length < 4) {
//             return results;
//         }
//         // outer pointers
//         int i = 0, j = numbers.length - 1;
//         Arrays.sort(numbers);
//         while (i < j) {
//             int targetTwo = target - numbers[i] - numbers[j];       
//             int k = i + 1;
//             int l = j - 1;
//             while (k < l) {
//                 int v = numbers[k] + numbers[l];
//                 if (v == targetTwo) {
//                     ArrayList<Integer> result = new ArrayList<Integer>();
//                     result.add(numbers[i]);
//                     result.add(numbers[k]);
//                     result.add(numbers[l]);
//                     result.add(numbers[j]);
//                     results.add(result);
//                     k++;
//                     l--;
//                 }
//                 if (v > targetTwo) {
//                     l--;
//                 }
//                 if (v < targetTwo) {
//                     k++;
//                 }

//             }
            
//             i++;
//             j--;
//         }

//         return results;
//     }
// }


// /* 
// feels bad man, the times up
// */


// Solution #1 by jiuzhang

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; i++) {
            // reduce duplicates for the same directions
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            // reduce duplicates for the same directions
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;

                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        // also reduce the duplicates for left and right pointer
                        // in the across pointers
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return rst;
    }
}

/* 
So, 1. always to remember to sort the array before doing anything else
    2. how to remove duplicates for the i j and the left and right
    3. think about the process while writing the code
*/