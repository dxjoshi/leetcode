import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    List<Integer> result;

    List<Integer> result2 = new ArrayList<>();

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        obj.grayCode(2);
    }

    public List<Integer> grayCode(int n) {
        // n digits == 0 - 2^n-1
        result = new ArrayList<>();
        solve((int) Math.pow(2, n), 0);
        System.out.println(result);
        return result;
    }

    public void solve(int n, int size) {
        if (n == size) {
            result2 = new ArrayList<>(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(result.size() == 0 ||
                    (result.size() > 0  && !result.contains(i)
                            && isPowerOfTwo(result.get(result.size()-1)^i))) {
                result.add(i);
                solve(n, size+1);
            }
        }
    }

    private boolean isPowerOfTwo(int x)
    {
        return x!= 0 && ((x & (x - 1)) == 0);
    }
}
