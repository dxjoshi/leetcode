/*
*
* 118. Pascal's Triangle
*
* Given an integer numRows, return the first numRows of Pascal's triangle.
* In Pascal's triangle, each number is the sum of the two numbers directly above it:
*
*
* */
import java.util.ArrayList;
import java.util.List;

public class L118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }

            }
            result.add(row);
        }
        return result;
    }

}
