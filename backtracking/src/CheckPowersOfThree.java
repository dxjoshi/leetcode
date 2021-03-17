/*
*
* 1780. Check if Number is a Sum of Powers of Three
*
* Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
* An integer y is a power of three if there exists an integer x such that y == 3x.
*
* Base Cases:
* n < 0 --> false
* n == 0 --> true
*
* find the largest power of 3^p <= n using last = Math.pow(3, (int)(Log10(n) / Log10(3)))
* check if remaining n >= 2 * last --> false another base case where we will using two time same power of 3.
* else recursively call n - last
* */
public class CheckPowersOfThree {

    public static void main(String[] args) {
        CheckPowersOfThree obj  =new CheckPowersOfThree();
        obj.checkPowersOfThree(31);
    }
    public boolean checkPowersOfThree(int n) {
        if(n < 0)
            return false;
        if(n == 0)
            return true;
        int last = (int)Math.pow(3, (int) (Math.log10(n) / Math.log10(3)));
        if(n >= 2 * last)
            return false;
        return checkPowersOfThree(n - last);
    }
}
