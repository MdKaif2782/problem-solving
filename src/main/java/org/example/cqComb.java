package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class cqComb {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] all = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};
        int[] b = {5, 6, 7};
        int[] c = {8, 9};
        int[] d = {10,11};

        ArrayList<int[]> combinations = new ArrayList<>();

        ArrayList<int[]> combA ;
        ArrayList<int[]> combB ;
        ArrayList<int[]> combC = new ArrayList<>();
        ArrayList<int[]> combD = new ArrayList<>();

        combA = calculateComb(a);
        combB = calculateComb(b);

        for (int i : c){
            int[] combC_array = new int[1];
            combC_array[0] = i;
            combC.add(combC_array);
        }
        for (int i : d){
            int[] combD_array = new int[1];
            combD_array[0] = i;
            combD.add(combD_array);
        }
        for (int[] element : combC){
            System.out.println(Arrays.toString(element));
        }
        for (int[] element : combD){
            System.out.println(Arrays.toString(element));
        }

        for (int[] element : combB){
            System.out.println(Arrays.toString(element));
        }

        for (int[] element : combA){
            int[] result = new int[7];
            result[0] = element[0];
            result[1] = element[1];
            for (int[] element2 : combB){
                result[2] = element2[0];
                result[3] = element2[1];
                for (int[] element3 : combC){
                    result[4] = element3[0];
                    for (int[] element4 : combD){
                        result[5] = element4[0];
                        for (int i : all){
                            if (!contains(result, i)){
                                result[6] = i;
                                int[] temp = orderArray(result);
                                if (!containsArrayInList(combinations, temp)){
                                    System.out.println(Arrays.toString(temp));
                                    combinations.add(temp);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\n"+combinations.size() + " combinations found");
    }
    public static boolean containsArrayInList(ArrayList<int[]> list, int[] array){
        for (int[] element : list){
            if (Arrays.equals(element, array)){
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] array, int element){
        for (int i : array){
            if (i == element){
                return true;
            }
        }
        return false;
    }
    public static int[] orderArray(int[] array){
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        Arrays.sort(result);
        return result;
    }

    public static ArrayList<int[]> calculateComb(int[] a) {
        ArrayList<int[]> combinations = new ArrayList<>();
        int i = 0;
        int p = 1;
        int q;
        while (true){
            int[] result = new int[2];
            q = i+p;
            if(q==(a.length*2)){
                break;
            }
            if ((q) >= a.length){
                q= (i+p)-a.length;
            }
            if (i>=a.length){
                i=i-a.length;
            }
            result[0] = a[i];
            result[1] = a[q];
            if (containsArrayInList(combinations, result)){
                p++;
                q = i+p;
                if ((q) > (a.length-1)){
                    q= (i+p)-a.length;
                }
                result[0] = a[i];
                result[1] = a[q];
                if (containsArrayInList(combinations, result)){
                    break;
                }else {
                    if (q>i) {
                        combinations.add(result);
                        System.out.println(result[0] + " " + result[1]);
                    }
                    i++;
                }
            } else {
                if (q>i) {
                    combinations.add(result);
                    System.out.println(result[0] + " " + result[1]);
                }
                i++;
            }
        }
        System.out.println("\n"+combinations.size() + " combinations found");
        return combinations;
    }

}
