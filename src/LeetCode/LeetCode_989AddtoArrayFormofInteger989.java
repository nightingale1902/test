package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_989AddtoArrayFormofInteger989 {
    /*对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。*/
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        int cur = K;
        List<Integer> res = new ArrayList<>();
        int i = length;
        while (--i >= 0 || cur > 0){
            if (i >= 0)
                cur += A[i];
            res.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int temp = 0;
        int i = A.length - 1;
        while (i >= 0 || K > 0) {
            int sum;
            if (i >= 0) {
                sum = A[i] + K % 10;
            } else {
                sum = K % 10;
            }
            temp = sum / 10;
            sum %= 10;
            list.addFirst(sum);
            K = K / 10 + temp;
            i--;
        }
        return list;
    }
}
