package org.lld.machinecoding;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3};
        Set<Integer> set = new HashSet<>();
        boolean containsDuplicate = false;
        for (int num : nums) {
            // The set.add Will return false if the element is already present. Then skip the loop and return as contains duplicate

            if (!set.add(num)) {
                containsDuplicate = true;
                break;
            }
            // Alternate Solution
            // The set.contains Will return true if the element is already present. Then skip the loop and return as contains duplicate

            if (set.contains(num)) {
                containsDuplicate = true;
                break;
            }


        }
        if (containsDuplicate) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
