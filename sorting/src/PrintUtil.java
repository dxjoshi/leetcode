public class PrintUtil {
    static void print(String text, int[] input) {
        System.out.print(text);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }
}
