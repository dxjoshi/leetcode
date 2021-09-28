/*
*
* 11. Container With Most Water
*
* Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
*
* */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int result = 0;
        int i=0;
        int j=height.length-1;
        while (j > i) {
            result = Math.max(result, (j-i)*Math.min(height[i],height[j]));
            if  (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
