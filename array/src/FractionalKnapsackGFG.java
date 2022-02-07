import java.util.Arrays;

/*
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item.
*/

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsackGFG {
    double fractionalKnapsack(int W, Item arr[], int n) {
        // find most profitable items

        Arrays.sort(arr, (a, b) -> Double.valueOf(((double) a.value) / a.weight).compareTo(((double) b.value) / b.weight));
        double res = 0, val = 0;
        int weight = 0, value = 0;

        for (int i = n - 1; i >= 0 && W > 0; i--) {
            weight = arr[i].weight;
            value = arr[i].value;
            val = ((double) value) / weight;
            if (W >= weight) {
                res += val * weight;
                W -= weight;
            } else {
                res += val * W;
                W = 0;
            }
        }
        return res;

    }
}
