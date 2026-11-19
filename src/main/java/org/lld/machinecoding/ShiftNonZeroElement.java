package org.lld.machinecoding;

import java.util.Arrays;

public class ShiftNonZeroElement {

        public static void main(String[] args) {
            int[] arr = {0, 1, 0, 3, 12, 0, 5};

            moveZerosToRight(arr);

            System.out.println("Result: " + Arrays.toString(arr));
            // Output: Result: [1, 3, 12, 5, 0, 0, 0]
        }

        public static void moveZerosToRight(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }

            int insertPos = 0; // Tracks the next position for a non-zero element

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    // Swap current non-zero element with the element at insertPos
                    int temp = arr[insertPos];
                    arr[insertPos] = arr[i];
                    arr[i] = temp;
                    insertPos++;
                }
            }
        }
    }


