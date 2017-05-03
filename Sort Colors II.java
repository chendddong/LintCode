// package com.company;
// Given an array of n objects with k different colors (numbered from 1 to k),
//  sort them so that objects of the same color are adjacent,
//  with the colors in the order 1, 2, ... k.

// inputs: int[] nums, int k
// outputs: void or return int[] nums

// test cases:
// corner case k > nums.length return or return []; nums == null return or return null
// [1,2,3,4,5,3,3,2,3,1]
// [1,1,2,2,3,3,3,3,4,4]


class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length < k) {
            return;
        }

        int[] counts = new int[k];

        for (int i = 0; i < colors.length; i++) {
            int j = 0;
            for (j = 0; j < k; j++) {
                if (colors[i] == j + 1) {
                    counts[j]++;
                    continue;
                }
            }
        }

        // combine the counts together
        helper(colors, 0, 1, counts, k);


    }

    private void helper(int[] colors, int start, int number, int[] counts, int k) {
        // first time
        // colors = [1,1,2,2,3,3,3,3,4,4]
        // counts = [2,   2,     4,    2]
        // start = 0, number = 1, k = 4

        // second time
        // colors = [1,1,2,2,3,3,3,3,4,4]
        // counts = [2,   2,     4,    2]
        // start = 2, number = 2, k = 4

        // third time
        // colors = [1,1,2,2,3,3,3,3,4,4]
        // counts = [2,   2,     4,    2]
        // start = 4, number = 3, k = 4

        // fourth time
        // colors = [1,1,2,2,3,3,3,3,4,4]
        // counts = [2,   2,     4,    2]
        // start = 8, number = 4, k = 4

        // fifth time
        // colors = [1,1,2,2,3,3,3,3,4,4]
        // counts = [2,   2,     4,    2]
        // start = 10, number = 5, k = 4


        if (number > k || start > colors.length) {
            return;
        }


        int i;
        for (i = start; i < start + counts[number - 1]; i++) {
            colors[i] = number;
        }

        if (number + 1 > k || start + 1 > colors.length) {
            return;
        }
        // The i should be i!!! not i + 1 coz it is already increment previously
        helper(colors, i, number + 1, counts, k);
    }
    
}

/* 
The time for this one is O(nk) and it is too bad
But the code works fine and I test it on the IDE
and the possible time could be O(nlogk) 
*/

class Solution {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }

        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    public void rainbowSort(int[] colors,
                            int left,
                            int right,
                            int colorFrom,
                            int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }

        if (left >= right) {
            return;
        }

        int colorMid = (colorFrom + colorTo) / 2;
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }

            while (l <= r && colors[r] > colorMid) {
                r--;
            }

            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;

                l++;
                r--;
            }
        }

        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
}

/* 
Cutting the color in half! pretty amazing
*/


