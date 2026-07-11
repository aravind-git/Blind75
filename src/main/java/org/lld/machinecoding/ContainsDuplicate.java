package org.lld.machinecoding;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3};
        Set<Integer> set = new HashSet<>();
        boolean containsDuplicate = false;
        for(int num: nums){
            if(!set.add(num)){  // The set.add Will return false if the element is already present. Then skip the loop and return as contains duplicate
                containsDuplicate = true;
                break;
            }

        }
        if(containsDuplicate){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
