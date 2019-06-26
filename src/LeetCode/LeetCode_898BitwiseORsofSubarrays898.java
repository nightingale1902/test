package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_898BitwiseORsofSubarrays898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            Set<Integer> cur = new HashSet<>();
            res.add(A[i]);
            cur.add(A[i]);
            for(int num : pre) {
                int tmp = A[i] | num;
                res.add(tmp);
                cur.add(tmp);
            }
            pre = cur;

        }
        return res.size();
    }

    public int subarrayBitwiseORs2(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int i : A){
            Set<Integer> temp = new HashSet<>();
            temp.add(i);
            for(int j : cur){
                temp.add(i | j);
            }
            cur = temp;
            for (int j : cur){
                res.add(j);
            }
        }
        return res.size();

    }

}
