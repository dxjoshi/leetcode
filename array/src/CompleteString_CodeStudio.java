import java.util.HashSet;
import java.util.Set;

public class CompleteString_CodeStudio {

    public static String completeString(int n, String[] a) {
        Set<String> set = new HashSet<>();
        for(String each : a) {
            set.add(each);
        }

        String result = null;
        for(String each : a) {
            if (containsAll(each, set)) {
                if (result == null || result.length() < each.length()) result = each;
                else if (result.length() == each.length() && result.compareTo(each) > 0) result = each;
            }
        }

        if ( result == null) result = "None";
        return result;
    }

    public static boolean containsAll(String word, Set<String> set) {
        String prefix = "";
        for(char c : word.toCharArray()) {
            prefix += c;
            if (!set.contains(prefix)) {
                return false;
            }
        }
        return true;
    }
}
