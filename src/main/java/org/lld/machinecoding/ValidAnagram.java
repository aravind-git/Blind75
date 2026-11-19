package org.lld.machinecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";


    }

    static boolean validAnagram(String s1, String s2) {
        /* Approach 1: Create a Map that counts the frequency of each character in both strings and then compare the two maps.
        If they are equal, then the strings are anagrams.
        This approach has a time complexity of O(n) and space complexity of O(n).
         */
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (Character c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (map1.equals(map2)) {
            return true;
        }
        return false;
    }

    static boolean validAnagramStream(String s1, String s2) {
        //Count the frequency of each character using streams and compare the maps. This approach has a time complexity of O(n log n) and space complexity of O(n).
        return Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(Arrays.stream(s2.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    }

    static boolean validAnagramStreamSortedList(String s1, String s2) {
        //Sort the character and convert to list.
        //Compare the lists. If they are equal, then the strings are anagrams.
        // This approach has a time complexity of O(n) and space complexity of O(n).
        return Arrays.stream(s1.split("")).sorted()
                .toList()
                .equals(Arrays.stream(s2.split("")).sorted()
                        .toList());

    }
}