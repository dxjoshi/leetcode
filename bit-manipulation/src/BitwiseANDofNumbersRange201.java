/*
*
* 201. Bitwise AND of Numbers Range
*
* Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
*
* */
public class BitwiseANDofNumbersRange201 {
    public int rangeBitwiseAnd(int m, int n) {
        while(n>m) {
            n = n & n-1;
        }
        return m&n;
    }
}
