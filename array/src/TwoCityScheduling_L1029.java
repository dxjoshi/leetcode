import java.util.Arrays;

public class TwoCityScheduling_L1029 {
    // https://leetcode.com/problems/two-city-scheduling/discuss/1881240/JavaC%2B%2B-THE-EASIEST-EXPLANATION

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0]-a[1]) - (b[0]-b[1]));
        int cost = 0;
        for(int i = 0; i< costs.length; i++) {
            if (i<costs.length/2) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}
