package com.lc150.双指针;

public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int tag = target - numbers[i];
            //int index = middleFind(i + 1, numbers.length - 1, numbers, tag);
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (numbers[middle] == tag) {
                    return new int[] { i + 1, middle + 1 };
                } else if (numbers[middle] > tag) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public int middleFind(int left, int right, int[] numbers, int target) {
        if (left > right)
            return -1;
        int middle = left + (right - left) / 2;
        if (numbers[middle] == target) {
            return middle;
        } else if (numbers[middle] > target) {
            return middleFind(left, middle - 1, numbers, target);
        } else {
            return middleFind(middle + 1, right, numbers, target);
        }

    }
}
