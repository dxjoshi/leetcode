public class Util {
    static void print(String text, int[] input) {
        System.out.print(text);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }

    static void swap(int[] input, int i, int j) {
        if (i != j) {
            int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
        }
    }

}
