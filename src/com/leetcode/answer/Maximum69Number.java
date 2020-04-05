package com.leetcode.answer;

/**
 * 1323. 6和9组成的最大数字
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * <p>
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * <p>
 * 请返回你可以得到的最大数字。
 * 链接：https://leetcode-cn.com/problems/maximum-69-number/
 */
public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number number = new Maximum69Number();
        int a = 69669;
        System.out.println(number.maximum69Number(a));
    }

    /**
     * @param num input
     * @return
     */
    private int maximum69Number(int num) {
        String s = String.valueOf(num);
        if (!s.contains("6"))
            return num;
        StringBuilder res = new StringBuilder();
        boolean first = false;
        for (char a : s.toCharArray()) {
            if (a == '6' && !first) {
                first = true;
                res.append('9');
            } else {
                res.append(a);
            }
        }
        return Integer.parseInt(res.toString());
    }
}
