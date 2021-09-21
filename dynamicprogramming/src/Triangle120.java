import java.util.List;

/*
*
* 120. Triangle
*
* Given a triangle array, return the minimum path sum from top to bottom.
* For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
*
* */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        Integer[][] cache = new Integer[triangle.size()][triangle.size()];
        return solve(triangle, 0, 0, cache);
    }

    public int solve(List<List<Integer>> triangle, int level, int pos, Integer[][] cache) {
        if (level == triangle.size()-1) {
            return triangle.get(level).get(pos);
        }

        if (cache[level][pos] != null ) return cache[level][pos];
        cache[level][pos] = triangle.get(level).get(pos) +
                Math.min(solve(triangle, level+1, pos, cache),
                        solve(triangle, level+1, pos+1, cache));

        return cache[level][pos];
    }
}
