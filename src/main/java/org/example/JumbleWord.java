package org.example;

import java.util.ArrayList;

public class JumbleWord {
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c', 'd'};
        ArrayList<char[]> permutations = new ArrayList<>();
        int[] iterator = new int[set.length];
        int pointer;
        char[] result = new char[set.length];

        while (true){
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
            if (!hasDuplicate) permutations.add(temp);

            if (iterator[iterator.length-1]==set.length-1){
                iterator[iterator.length-1] = 0;
                pointer = iterator.length-1;
                while (true) {
                    pointer--;
                    if (pointer == -1){
                        break;
                    }
                    iterator[pointer]++;
                    if (iterator[pointer] == set.length) {
                        iterator[pointer] = 0;
                    } else {
                        break;
                    }
                }
                if (pointer<0){
                    break;
                }
            }else {
                iterator[iterator.length-1]++;
            }

        }
        for (char[] element : permutations){
            System.out.println(element);
        }
        System.out.println(permutations.size());
    }
}
