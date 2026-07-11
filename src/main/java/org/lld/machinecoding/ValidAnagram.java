package org.lld.machinecoding;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";


    }

    static boolean validAnagram(String s1, String s2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(Character c: s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(Character c: s2.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }
        return false;
    }
}
