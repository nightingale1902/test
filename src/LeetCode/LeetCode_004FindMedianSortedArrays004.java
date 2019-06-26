package LeetCode;

/*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:
    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0*/

public class LeetCode_004FindMedianSortedArrays004 {

    //该方法时间复杂度为O(log(min(m,n))) --> log 二分法
    //参考地址：https://blog.csdn.net/chen_xinjia/article/details/69258706
    /*
    *  index: 0 1 2 3 4 5
    *          L1  R1
    *  num1: 3 5 | 8 9         cut1:左有几个元素
    *            L2  R2
    *  num2: 1 2 7 | 10 11 12   cut2: 左有几个元素
    *
    *  num3: 1 2 3 5 7 8 9 10 11 12
    *  num3 -> num1 + num2 -> num1 num3切一半的长度已知了，已知num1的一半切，就同时得到num2的一半切
    *
    *  L1 <= R2
    *  L2 <= R1
    *
    *  在这个(cutL, cutR)范围里面二分
    *  对于cut1来说的
    *  L1 > R2  cut1 << (cutL, cut1-1)
    *  L2 > R1  cut1 >> (cut1+1, cutR)
    *  L2 > R1  cut2 >> (cut1, cutR)
    *
    *
    *
    * */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length){
            cut1 = (cutR - cutL) / 2 + cutL; //对于num1砍一刀的位置
            cut2 = len / 2 - cut1;            //根据num1砍一刀的位置，得出num2砍一刀的位置
            //L1，R1分别位于cut1的左右；L2，R2分别位于cut2的左右
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1]; //index从0开始的，cut1是等于R1的。
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2){
                cutR = cut1 - 1;
            }else if (L2 > R1){
                cutL = cut1 + 1;
            }else {
                if (len % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                }else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }

}
