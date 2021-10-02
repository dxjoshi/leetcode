/*
*
* 55. Jump Game
*
* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
* Return true if you can reach the last index, or false otherwise.
*
* */
public class JumpGame55 {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }
}
