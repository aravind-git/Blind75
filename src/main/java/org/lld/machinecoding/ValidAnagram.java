package org.lld.machinecoding;

import java.util.HashMap;
import java.util.stream.Collectors;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        System.out.println("validAnagram: " + validAnagram(s, t));
        System.out.println("validAnagramStream: " + validAnagramStream(s, t));
        System.out.println("validAnagramStreamSortedList: " + validAnagramStreamSortedList(s, t));
    }

    static boolean validAnagram(String s1, String s2) {
        /* Approach 1: Create a Map that counts the frequency of each character in both strings and then compare the two maps.
        If they are equal, then the strings are anagrams.
        This approach has a time complexity of O(n) and space complexity of O(n).
         */
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (Character c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }

    static boolean validAnagramStream(String s1, String s2) {
        //Count the frequency of each character using streams and compare the maps. This approach has a time complexity of O(n) and space complexity of O(n).
        if (s1.length() != s2.length()) {
            return false;
        }
        return s1.chars().boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .equals(s2.chars().boxed()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    static boolean validAnagramStreamSortedList(String s1, String s2) {
        //Sort the characters and convert to list.
        //Compare the lists. If they are equal, then the strings are anagrams.
        // This approach has a time complexity of O(n log n) and space complexity of O(n).
        if (s1.length() != s2.length()) {
            return false;
        }
        return s1.chars().sorted().boxed()
                .toList()
                .equals(s2.chars().sorted().boxed()
                        .toList());
    }
}
