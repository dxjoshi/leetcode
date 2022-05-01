public class GetNthRoot {

    // TC: N x log(M x 10^d)
    public static void main (String[] args) {
        int n = 3, m = 27;
        getNthRoot(n, m);
    }

    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans;
    }

    private static void getNthRoot(int n, int m) {
        double lo = 1, hi = m, mid = 0;
        double eps = 1e-6;

        while(hi-lo > eps) {
            mid = lo + (hi-lo)/2.0;
            double prod = multiply(mid, n);

            if (prod > m) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(n+"th root of "+m+" is "+lo);
    }
}
