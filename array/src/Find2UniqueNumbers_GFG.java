public class Find2UniqueNumbers_GFG {
//    https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
    public static void UniqueNumbers2(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
           sum = (sum ^ arr[i]);
        }

        // sum & sum's 2's Complement gives the RIGHTMOST SET BIT
        sum = (sum & -sum);

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.length; i++) {
            // sum & the arr[i] has 2 possibilities either result == 0 or result > 0
            if ((arr[i] & sum) > 0) {
                sum1 = (sum1 ^ arr[i]);
            } else {
                sum2 = (sum2 ^ arr[i]);
            }
        }

        System.out.println("The non-repeating elements are " + sum1 + " and " + sum2);
    }
}
