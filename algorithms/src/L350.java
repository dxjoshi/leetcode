import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* 350. Intersection of Two Arrays II
*
* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
*
* */
public class L350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] smallArr = nums1.length<nums2.length ? nums1 : nums2;
        int[] bigArr = nums1.length<nums2.length ? nums2 : nums1;
        int i = smallArr.length-1;
        int j = bigArr.length-1;

        List<Integer> list = new ArrayList<>();
        while (i>=0 && j>=0) {
            if (smallArr[i] == bigArr[j]) {
                list.add(smallArr[i]);
                --i;--j;
            } else if (smallArr[i] > bigArr[j]) {
                --i;
            } else {
                --j;
            }
        }

        int[] array = new int[list.size()];
        for(int k = 0; k < list.size(); k++) {
            array[k] = list.get(k);
        }
        return array;
    }

}

