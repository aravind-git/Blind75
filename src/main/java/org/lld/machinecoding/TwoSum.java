package org.lld.machinecoding;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    // Optimal: HashMap approach - O(n) time, O(n) space
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    // Alternative: Two-pointer approach with sorting - O(n log n) time, O(1) space
    static int[] twoSumTwoPointer(int[] nums, int target) {
        int[][] indexed = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            indexed[i] = new int[]{nums[i], i};
        }

        java.util.Arrays.sort(indexed, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = indexed[left][0] + indexed[right][0];
            if(sum == target) {
                int idx1 = indexed[left][1];
                int idx2 = indexed[right][1];
                return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
            }
            else if(sum < target) left++;
            else right--;
        }

        return new int[]{};
    }
}