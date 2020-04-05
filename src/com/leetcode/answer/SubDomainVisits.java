package com.leetcode.answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * <p>
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * <p>
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * <p>
 */
public class SubDomainVisits {
    public static void main(String[] args) {
        SubDomainVisits subDomainVisits = new SubDomainVisits();
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        System.out.println(subDomainVisits.subdomainVisits(cpdomains));
    }

    /**
     * 时间复杂度：O(N)，其中N是数组 cpdomains 的长度，这里假设 cpdomains 中每个元素的长度都是常数级别的。
     * <p>
     * 空间复杂度：O(N)，用于存储哈希映射。
     * 链接：https://leetcode-cn.com/problems/subdomain-visit-count/solution/zi-yu-ming-fang-wen-ji-shu-by-leetcode/
     *
     * @param cpdomains domain list
     * @return
     */
    private List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.parseInt(cpinfo[0]);
            String current = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                current = frags[i] + (i < frags.length - 1 ? "." : "") + current;
                counts.put(current, counts.getOrDefault(current, 0) + count);
            }
        }
        List<String> list = new ArrayList<>();
        for (String key : counts.keySet()) {
            list.add("" + counts.get(key) + " " + key);
        }
        return list;
    }
}
