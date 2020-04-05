package com.leetcode.answer;

/**
 * 判断一个字符串是否是标准的Ipv4地址
 */
public class Ipv4Check {

    public static void main(String[] args) {
        String regex = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
        String str1 = "1.1.1.0";
        boolean flag1 = str1.matches(regex);
        System.out.println(flag1);

        String str2 = "222";
        boolean flag2 = str2.matches(regex);
        System.out.println(flag2);
    }
}
