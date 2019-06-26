package LeetCode;

public class LeetCode_278FirstBadVersion278 {
    private static int FIRST_BAD = 4;
    boolean isBadVersion(int version){
        if (version >= FIRST_BAD){
            return true;
        }
        return false;
    }
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high){
            int mid = low + (high - low) / 2;//防止overflow
            if (isBadVersion(mid)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
