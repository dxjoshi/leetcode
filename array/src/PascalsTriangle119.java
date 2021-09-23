import java.util.Arrays;
import java.util.List;

/*
*
* 119. Pascal's Triangle II
*
* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
* In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*
* */
public class PascalsTriangle119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j>0; j--) {
                res[j] += res[j-1];
            }

        }
        return Arrays.asList(res);
    }
}
