package vivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number1 {

    public  int[] arraySubtract(int[] array1, int[] array2){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            boolean isContained = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] ==array2[j]){
                    isContained = true;
                    break;
                }
            }
            if (!isContained){
                list.add(array1[i]);
            }
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        int[] res = Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
        return res;
    }



}
