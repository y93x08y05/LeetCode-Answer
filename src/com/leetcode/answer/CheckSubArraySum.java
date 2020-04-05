package com.leetcode.answer;

import java.util.HashMap;

/**
 * 523. 连续的子数组和
 * 给定一个包含非负数的数组和一个目标整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，
 * 即总和为 n*k，其中 n 也是一个整数
 * <p>
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 */
public class CheckSubArraySum {
    public static void main(String[] args) {
        CheckSubArraySum subArraySum = new CheckSubArraySum();
        int[] nums = {2, 5, 33, 6, 7, 25, 15};
        int k = 13;
        System.out.println(subArraySum.checkSubarraySum1(nums, k));
        System.out.println(subArraySum.checkSubarraySum2(nums, k));
        System.out.println(subArraySum.checkSubarraySum3(nums, k));
    }

    /**
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode/
     * <p>
     * 时间复杂度：O(n3) 3重嵌套的for循环遍历数组。
     * 空间复杂度：O(1) 只用了常数个额外变量。
     *
     * @param nums array
     * @param k    destination int
     * @return
     */
    private boolean checkSubarraySum1(int[] nums, int k) {

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++)
                    sum += nums[i];
                if (sum == k || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(n2) 。为了考虑每一个子数组，我们需要一个 2 重嵌套的循环。
     * 空间复杂度：O(n) 。 使用了长度为n的sum 数组。
     *
     * @param nums array
     * @param k    destination int
     * @return
     */
    private boolean checkSubarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int summ = sum[end] - sum[start] + nums[start];
                if (summ == k || (k != 0 && summ % k == 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(n) 。仅需要遍历nums 数组一遍。
     * 空间复杂度：O(min(n,k)) 。 HashMap 最多包含min(n,k) 个不同的元素。。
     *
     * @param nums array
     * @param k    destination int
     * @return
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
