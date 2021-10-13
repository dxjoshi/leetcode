/*
*
* 50. Pow(x, n)
*
* Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*
* */
public class Pow_x_n_50 {

    public static void main(String[] args) {
        System.out.println(modularExponentiation(2, 2022, 7));
        System.out.println(modPow(2, 2022, 7));
    }

    public static int modPow(int x, int n, int m) {
        if (n == 0) return 1;
        if (n < 0){
            x = 1/x;
            x %= m;
            return (n %2 == 0) ? modPow((x*x)%m, -(n/2), m) : (x*modPow((x*x)%m, -(n/2), m))%m;
        }
        return (n %2 == 0) ? modPow((x*x)%m, n/2, m) : (x*modPow((x*x)%m, n/2, m))%m;
    }

    static int modularExponentiation(int x,int n,int M)
    {
        if(n==0) {
            return 1;
        } else if(n%2 == 0)        //n is even
        {
            return modularExponentiation((x*x)%M,n/2,M);
        } else                             //n is odd
        {
            return (x*modularExponentiation((x*x)%M,(n-1)/2,M))%M;
        }

    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0){
            x = 1/x;
            return (n %2 == 0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        return (n %2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
