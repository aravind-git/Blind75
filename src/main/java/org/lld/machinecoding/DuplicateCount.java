package org.lld.machinecoding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateCount {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 1};

        duplicatePositions(a).stream()
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    /**
     * Returns [value, lastPosition] (1-based) for every value
     * that appears more than once, in first-seen order.
     */
    static List<int[]> duplicatePositions(int[] nums) {
        Map<Integer, List<Integer>> indicesByValue = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> nums[i],
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        return indicesByValue.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> new int[]{
                        entry.getKey(),
                        entry.getValue().getLast() + 1 // Use .get(entry.getValue().size() - 1) + 1 if below Java 21
                })
                .toList();
    }
}