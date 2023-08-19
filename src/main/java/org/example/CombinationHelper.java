package org.example;

import java.util.ArrayList;
import java.util.Arrays;


public class CombinationHelper {
    public static ArrayList<int[]> getArray(int[] set, int length) {
        ArrayList<int[]> combinations = new ArrayList<>();
        int[] iterator = new int[length];
        for (int i = 0; i < iterator.length; i++) {
            iterator[i] = i;
        }
        int[] result = new int[length];
        int pointer;
        while (true){
            for (int i = 0; i < iterator.length; i++) {
                result[i] = set[iterator[i]];
            }
            int[] temp = result.clone();
            Arrays.sort(temp);

            boolean contains = false;
            for (int[] element : combinations){
                if (Arrays.equals(element, temp)) {
                    contains = true;
                    break;
                }
            }
            for (int i = 0; i < temp.length - 1; i++) {
                for (int j = i + 1; j < temp.length; j++) {
                    if (temp[i] == temp[j]) {
                        contains = true; // Found a duplicate
                        break;
                    }
                }
            }
            if (!contains){combinations.add(temp);
                System.out.println(Arrays.toString(temp));
            }
            if (iterator[iterator.length-1] == set.length-1){
                iterator[iterator.length-1] = set[iterator.length-1];
                pointer = iterator.length-1;
                while (true) {
                    pointer--;
                    if (pointer == -1){
                        break;
                    }
                    iterator[pointer]++;

                    if (iterator[pointer] == set[set.length - iterator.length + pointer]) {
                        iterator[pointer] = set[pointer];
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
        System.out.println("Combinations found: "+combinations.size());
        return combinations;
    }

    public static void main(String[] args) {
        int[] set = {1,2,3,4,5,6,7,8,9,10,11};
        ArrayList<int[]> arrayList = getArray(set, 7);
    }
}
