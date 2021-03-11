/*
*
* 1079. Letter Tile Possibilities
*
* You have n  tiles, where each tile has one letter tiles[i] printed on it.
* Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
*
* */
public class LetterTilePossibilities {
    public static void main(String[] args) {
        LetterTilePossibilities ob  = new LetterTilePossibilities();
        int count = ob.numTilePossibilities("AAB");
        System.out.println(count);
    }

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) return 0;
        int [] count = new int[26];
        for (char c: tiles.toCharArray()) {
            count[c-'A']++;
        }
        return solve(count);

    }

    public int solve(int[] count) {
        int sum = 0;
        for (int i = 0; i< count.length; i++) {
            if  (count[i] <= 0) {
                continue;
            }
            sum++;
            count[i]--;
            sum += solve(count);
            count[i]++;

        }
        return sum;
    }
}