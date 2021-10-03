import java.util.Random;

/*
* 278. First Bad Version
*
* You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
* Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
* You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*
* */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class L278 {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo)/2;     // use this insted of (hi + lo) to avoid overflow error
            if (!isBadVersion(mid)) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

}
