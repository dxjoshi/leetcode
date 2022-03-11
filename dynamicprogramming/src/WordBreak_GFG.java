import java.util.ArrayList;

public class WordBreak_GFG {

    public static int wordBreak(String A, ArrayList<String> B )
    {
        boolean res = solve(A,B);
        return res==true ? 1 : 0;
    }

    static boolean dictionaryContains(String word, ArrayList<String> dictionary) {
        int size = dictionary.size();
        for (int i = 0; i < size; i++)
            if (dictionary.get(i).compareTo(word) == 0)
                return true;
        return false;
    }

    // Returns true if String can be segmented into space separated
// words, otherwise returns false
    static boolean solve(String str, ArrayList<String> dict)
    {
        int size = str.length();
        if (size == 0)   return true;

        // Create the DP table to store results of subproblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        boolean []wb = new boolean[size+1];

        for (int i=1; i<=size; i++)
        {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substring(0, i)"
            if (wb[i] == false && dictionaryContains( str.substring(0, i), dict))
                wb[i] = true;

            // wb[i] is true, then check for all subStrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true)
            {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // subString starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dictionaryContains(str.substring(i, j), dict))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"
     for (int i = 1; i <= size; i++)
        System.out.print(" " +  wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }

}
