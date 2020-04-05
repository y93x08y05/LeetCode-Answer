package com.leetcode.answer;

/**
 * 1385. 两个数组间的距离值
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 * <p>
 * 给定两个整数数组arr1，arr2和一个整数d，请你返回两个数组直接的距离值
 * 「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 */
public class ArrayDistanceValue {
    public static void main(String[] args) {
        ArrayDistanceValue value = new ArrayDistanceValue();
        int[] arr1 = {1, 2, 100, 3};
        int[] arr2 = {-5, -2, -3, 10, 7};
        int d = 6;
        System.out.println(value.findTheDistanceValue(arr1, arr2, d));
    }

    private int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int a : arr1) {
            boolean have = false;
            for (int b : arr2) {
                int c = a - b;
                if (Math.abs(c) <= d) {
                    have = true;
                    break;
                }
            }
            if (!have)
                count++;
        }
        return count;
    }
}
