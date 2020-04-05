package com.leetcode.answer;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 * 链接：https://leetcode-cn.com/problems/relative-sort-array/
 * <p>
 * arr2中的元素各不相同
 * arr2中的每个元素都出现在arr1中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        RelativeSortArray sortArray = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(sortArray.relativeSortArray(arr1, arr2)));
    }

    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        int[] ref = new int[arr1.length];
        for (int val : arr1)
            m[val]++;
        int cnt = 0;
        for (int val : arr2) {
            while (m[val] > 0) {
                ref[cnt++] = val;
                m[val]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;

    }
}
