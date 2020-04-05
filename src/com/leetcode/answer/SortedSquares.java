package com.leetcode.answer;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] A = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares1(A)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquares2(A)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquares3(A)));
    }

    private int[] sortedSquares1(int[] A) {
        return Arrays.stream(A).map(o -> (int) Math.pow(o, 2)).sorted().toArray();
    }

    /**
     * 时间复杂度：O(NlogN)，其中N 是数组 A 的长度。
     * <p>
     * 空间复杂度：O(N)。
     *
     * @param A array
     * @return
     */
    private int[] sortedSquares2(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < A.length; i++) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode/
     * 双指针
     *
     * @param A array
     * @return
     */
    private int[] sortedSquares3(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j - 1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }

        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
