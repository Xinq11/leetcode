package com.lc150.数组字符串;

public class lc274 {
    /**
     * 空间换时间，但这个空间要如何设计
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length, res = 0;
        // 为什么是 n + 1 的长度？
        // 表示 被引用i次的文章有几篇 对应0次到n次
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                nums[n]++;
            } else {
                nums[citations[i]]++;
            }
        }
        // 从被引用5次开始，计算对应的文章数量
        for (int i = n; i >=0; i--){
            res += nums[i];
            if (res >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new lc274().hIndex(new int[]{0, 1, 3, 5, 6});
    }
}
