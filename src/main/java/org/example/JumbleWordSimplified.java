package org.example;

import java.util.ArrayList;

public class JumbleWordSimplified {
    public static void main(String[] args) {
        char[] set = {'u', 'k', 'f', 'c'};
        int[] iterator = new int[set.length];
        int pointer;
        char[] result = new char[set.length];
        int counter = 0;

        while (true) {
            for (int i = 0; i < set.length; i++) {
                result[i] = set[iterator[i]];
            }
            char[] temp = result.clone();

            boolean hasDuplicate = false;

            for (int i = 0; i < iterator.length - 1; i++) {
                for (int j = i + 1; j < iterator.length; j++) {
                    if (iterator[i] == iterator[j]) {
                        hasDuplicate = true; // Found a duplicate
                        break;
                    }
                }
            }
            if (!hasDuplicate) {
                System.out.println(temp);
                counter++;
            }

            if (iterator[iterator.length - 1] == set.length - 1) {
                iterator[iterator.length - 1] = 0;
                pointer = iterator.length - 1;
                while (true) {
                    pointer--;
                    if (pointer == -1) {
                        break;
                    }
                    iterator[pointer]++;
                    if (iterator[pointer] == set.length) {
                        iterator[pointer] = 0;
                    } else {
                        break;
                    }
                }
                if (pointer < 0) {
                    break;
                }
            } else {
                iterator[iterator.length - 1]++;
            }

        }
        System.out.println(counter + " permutations found.");
    }
}
