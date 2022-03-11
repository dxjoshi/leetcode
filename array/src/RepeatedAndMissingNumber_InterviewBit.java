public class RepeatedAndMissingNumber_InterviewBit {
    public int[] repeatedNumber(final int[] A) {
        int[] res = new int[2];
        int i = 0;

        //swap sort
        for(i=0; i<A.length; i++) {
            if(A[i] != i+1 && A[A[i]-1] != A[i]) {
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }

        }
        //find repeating and missing
        for(i=0; i<A.length; i++) {
            if(A[i] != i+1) {
                res[0] = A[i]; //repeating
                res[1] = i+1;  //missing
                break;
            }
        }
        //System.out.println(res[0] + " " + res[1]);
        return res;
    }

}
