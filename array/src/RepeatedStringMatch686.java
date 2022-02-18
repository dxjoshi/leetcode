/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
*/
public class RepeatedStringMatch686 {
    // https://leetcode.com/problems/repeated-string-match/discuss/108118/C%2B%2BJava-Clean-Code

//     public int repeatedStringMatch(String a, String b) {
//         int counter = 0;

//         String c= "";

//         while (c.length() < b.length()+ a.length()+1) {
//             c += a;
//             counter++;
//             if (c.contains(b)) return counter;
//         }
//         return -1;

//     }

//     public int repeatedStringMatch(String A, String B) {

//     int count = 0;
//     StringBuilder sb = new StringBuilder();
//     while (sb.length() < B.length()) {
//         sb.append(A);
//         count++;
//     }
//     if(sb.toString().contains(B)) return count;
//     if(sb.append(A).toString().contains(B)) return ++count;
//     return -1;
// }

    public int repeatedStringMatch(String A, String B) {
        StringBuilder as = new StringBuilder(A);
        for (int rep = 1; rep <= B.length() / A.length() + 2; rep++) {
            if (as.toString().contains(B)) {
                return rep;
            }
            as.append(new StringBuilder(A));
        }
        return -1;
    }
}
