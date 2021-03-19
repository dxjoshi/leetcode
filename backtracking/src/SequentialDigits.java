/*
*
* 1291. Sequential Digits
*
* An integer has sequential digits if and only if each digit in the number is
* one more than the previous digit.
* Return a sorted list of all the integers in the range [low, high] inclusive that
* have sequential digits.
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        SequentialDigits obj = new SequentialDigits();
        obj.sequentialDigits(1000, 13000);
    }


    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        solve(low, high, result, 1, 0, 0);
        Collections.sort(result);
        System.out.println(result);
        return result;
    }

    public void solve(int low, int high, List<Integer> result, int curr, int sum, int digit){
        if (sum > high) {
            return;
        }

        if ( sum >= low) {
            result.add(new Integer(sum));
        }


        for(int i=digit; i<=9; i++) {
            if (curr == 1 & i == 0 || (sum >0 && i-(sum%10) >1)) {
                continue;
            }
            sum = i + sum*10;
            solve(low, high, result, curr+1, sum, i+1);
            sum = (sum - i)/10;
        }
    }
}