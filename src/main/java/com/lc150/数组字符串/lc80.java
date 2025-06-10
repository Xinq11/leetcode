package com.lc150.数组字符串;

public class lc80 {
    public int removeDuplicates(int[] nums) {
        int cap = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cap - 2]){
                nums[cap++] = nums[i];
            }
        }
        return cap;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3};
        lc80 lc80 = new lc80();
        int len = lc80.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
