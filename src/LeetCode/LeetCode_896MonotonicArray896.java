package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_896MonotonicArray896 {
    public boolean isMonotonic(int[] A) {

       /* boolean inc = true, dec = true;
        for (int i = 1; i < A.length; i++) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;*/
       int inc = 1, dec = 1, n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i - 1] <= A[i]) inc++;
            if (A[i - 1] >= A[i]) dec++;
        }

        return inc == n || dec == n;

    }
}
