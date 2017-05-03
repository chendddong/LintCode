// Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
// You are not necessary to keep the original order of positive integers or negative integers.
// [1,3,5,8,-1,-2,-4]

// the process is bit hard to achieve 

// Solution #0 by jiuzhang 
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] Am = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0)
            {
                Ap[totp] = A[i];
                totp += 1;
            }
            else
            {
                Am[totm] = A[i];
                totm += 1;  
            }   
            if(totp > totm)
                tmp = subfun(Ap, Am, A.length);
            else
                tmp = subfun(Am, Ap, A.length);
            for (int i = 0; i < tmp.length; ++i)
                A[i] = tmp[i];
        }
    }

/* 
Have no idea what this is
*/ 

// SOLUTION #1:

// 1. 先用parition把数组分为左边为负数，右边为正数。

// 2. 如果负数比较多，把多余的负数与尾部的值交换。（这样多余的数会放在数组的末尾）

// 3. left 指向数组的左边，right指向数组的右边减掉多余的数。

// 4. 第3步中，根据是正数多，还是负数多，起始位置要变一下。正数多，我们希望开始的是正数：

// 例如 3 -1 2

// 负数多，我们希望开始的是负数，如 -1 3 -2

// 5. 不断交换left, right指针，并一次前进步长2. 直到left, right 相遇。

class Solution {
   /**
     * @param A: An integer array.
     * @return an integer array
     */
    // SOLUTION 2: 判断正数多还是负数多。 
   public void rerange(int[] A) {
        // write your code here

        // Check the input parameter.
    if (A == null || A.length == 0) {
        return A;
    }

    int len = A.length;

    int left = -1;
    int right = A.length;

        // divide the negative and positive integers.
    while (true) {
        while (left < A.length - 1 && A[++left] < 0);

        while (left < right && A[--right] > 0);

        if (left >= right) {
            break;
        }

        swap(A, left, right);
    }

        // LEFT: point to the first positive number.
    int negNum = left;
    int posNum = len - left;

    int les = Math.min(negNum, posNum);
    int dif = Math.abs(negNum - posNum);

        // 如果负数比较多，把多的负数扔到后面去
    if (negNum > posNum) {
        int cnt = dif;
        int l = les;
        int r = len - 1;
        while (cnt > 0) {
            swap(A, l, r);
            l++;
            r--;
            cnt--;
        }

            // 负数多的时候，负数在前，反之，正数在前
        left = -1;
            // 跳过右边不需要交换的值
        right = A.length - dif;
    } else {
            // 正数在前
        left = -2;
            // 跳过右边不需要交换的值
        right = A.length - dif + 1;
    }

        /*
          -1 -2 -5 -6  3  4  les = 2;
          4  -2 -5 -6  3 -1
        */
        // swap the negative and the positive
          while (true) {
            left += 2;
            right -= 2;
            
            if (left >= les) {
                break;
            }
            swap(A, left, right);
        }

    }

    public static void swap(int[] A, int n1, int n2) {
     int tmp = A[n1];
     A[n1] = A[n2];
     A[n2] = tmp;
 }
}


/*
This is just brilliant but not easy to manipulate I guess
*/

// Solution #2
// 1. 扫一次确定是正数多还是负数多

// 2. 把奇数索引的所有的数字进行partition，如果是正数多，把正数放在后面，否则负数放在后面。

// 3. 令Index 1 = 奇数列，index 2 = 偶数列，扫描一次，遇到不符合正负条件的数字进行交换即可

class Solution {
    public void swap(int[] A, int n1, int n2) {
       int tmp = A[n1];
       A[n1] = A[n2];
       A[n2] = tmp;
   }

   public void rerange(int[] A) {
        // write your code here

        // Check the input parameter.
    if (A == null || A.length <= 2) {
        return;
    }

    int len = A.length;

    int cntPositive = 0;

    for (int num: A) {
        if (num > 0) {
            cntPositive++;    
        }
    }

        // If positive numbers are more than negative numbers,
        // Put the positive numbers at first.
    int posPointer = 1;
    int negPointer = 0;

        // means 
    boolean pos = false;

    if (cntPositive > A.length / 2) {
            // Have more Positive numbers;
        posPointer = 0;
        negPointer = 1;

        pos = true;
    }

    int i = 1;
    int j = len - 2;

    if (pos) {
        while (true) {
                // Put the positive numbers at the end.
            if (i < len && A[i] < 0) {
                i += 2;
            }

            if (j > i && A[j] > 0) {
                j -= 2;
            }

            if (i >= j) {
                break;
            }

            swap(A, i, j);
        }
    } else {
        while (true) {
                // Put the negative numbers at the end.
            if (i < len && A[i] > 0) {
                i += 2;
            }

            if (j > i && A[j] < 0) {
                j -= 2;
            }

            if (i >= j) {
                break;
            }

            swap(A, i, j);
        }
    }

        // Reorder the negative and the positive numbers.
    while (true) {
            // Should move if it is in the range.
        while (posPointer < len && A[posPointer] > 0) {
            posPointer += 2;
        }

            // Should move if it is in the range.
        while (negPointer < len && A[negPointer] < 0) {
            negPointer += 2;
        }

        if (posPointer >= len || negPointer >= len) {
            break;
        }

        swap(A, posPointer, negPointer);
    }

}
}