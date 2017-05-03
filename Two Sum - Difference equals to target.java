// Given an array of integers, find two numbers that 
// their difference equals to a target value.
// where index1 must be less than index2. Please note that 
// your returned answers (both index1 and index2) are NOT zero-based.

// inputs int[] numbers, int target
// outputs int[2] index in it and not 0 based;

// null, [], [1] 
// [4, 3, 5, 8, 1] 7

// use two pointers

// public class Solution {
//     /*
//      * @param nums an array of Integer
//      * @param target an integer
//      * @return [index1 + 1, index2 + 1] (index1 < index2)
//      */
//     public int[] twoSum7(int[] nums, int target) {
//      if (nums == null || nums.length < 2) {
//          return new int[0];
//      }

//      int[] sorted = new int[nums.length];
//      System.arraycopy(nums, 0, sorted, 0, nums.length);
//      Arrays.sort(sorted);
//      int left = 0, right = 1;
//      while (left < right) {
//          if (sorted[right] - sorted[left] == target || sorted[left] - sorted[right] == target) {
//              break;
//          } else if (sorted[right] - sorted[left] < target) {
//              right++;
//          } else {
//              left++;
//          }
//      }

//      int newI = -1;
//      int newJ = -1;

//      // find the original place
//      for (int i = 0; i < nums.length; i++) {
//          if (nums[i] == sorted[left] || nums[i] == sorted[right]) {
//              if (newI == -1) {
//                  newI = i + 1;
//              } else {
//                  newJ = i + 1;
//              }

//          }
//      }
//      int[] result = {newI, newJ};
//      Arrays.sort(result);
//      return result;
//     }
// }

/* 
piece of shit...
*/

public class Solution {
    class Pair {
        public int idx, num;
        public Pair(int i, int n) {
            this.idx = i;
            this.num = n;
        }
    }
    public int[] twoSum7(int[] nums, int target) {
        int[] indexs = new int[2];
        if (nums == null || nums.length < 2) {
            return indexs;
        }

        if (target < 0) {
            target = -target;
        }

        int n = nums.length;
        Pair[] pairs = new Pair[n];
        // put index value pair to an array
        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.num - p2.num;
            }
        });

        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (i == j) {
                j++;
            }

            while (j < n && pairs[j].num - pairs[i].num < target) {
                j++;
            }

            if (j < n && pairs[j].num - pairs[i].num == target) {
                indexs[0] = pairs[i].idx + 1;
                indexs[1] = pairs[j].idx + 1;
                if (indexs[0] > indexs[1]) {
                    int temp = indexs[0];
                    indexs[0] = indexs[1];
                    indexs[1] = temp;
                }
                return indexs;
            }
        }

        return indexs;


    }
}


/* 
We should go back at this when we encounter another thing requires the 
Comparator.

Basically it recreates the array to a Pair when the pair is index and number,
and we are gonna sort the index and pair based on their diffrence of values;

比如原数列 nums = [9, 7, 6, 4, 3, 8] ---> 
pairs--->(0,9), (1, 7), (2, 6), (3, 4), (4, 3), (5, 8)
(4,3),(3,4),(2,6),(1,7),(5,8),(0,9)
Pair当中有两个属性，一个是idx一个是num，
return p1.num - p2.num就表示了根据num这个属性来排序。
*/

