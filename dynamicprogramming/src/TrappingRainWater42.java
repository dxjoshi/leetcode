/*
*
* 42. Trapping Rain Water
*
* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*
* */
public class TrappingRainWater42 {
    public int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                max+=(leftmax-A[a]);
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
}