/*

	Time complexity: O(N * L)
        insert - O(N)
        countWordsEqualTo - O(N)
        countWordsStartingWith - O(N)
        erase - O(N)
	Space complexity: O(N * L)

	Where 'N' and 'L' represents the numbers of words
	and the longest word in words.

*/




public class ImplementTrie2_CodeStudio {
    class TrieNode{
        public TrieNode childern[];
        public int wordCount;
        public int prefixCount;

        TrieNode(){
            childern = new TrieNode[26];
            wordCount = 0;
            prefixCount = 0;
        }
    };

    // Declare a variable root that denotes the root of the Trie.
    public TrieNode root;

    // Initialize the Trie.
    public ImplementTrie2_CodeStudio() {
        root = new TrieNode();
    }


    // In this function we are inserting the word into our Trie.
    public void insert(String word){
        TrieNode curr = root;

        // Iterating through the string word.
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.childern[index] == null){
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index];
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word){
        TrieNode curr = root;

        // Iterating through the string word.
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.childern[index] == null){
                return 0;
            }
            curr = curr.childern[index];
        }
        return curr.wordCount;
    }

    public int countWordsStartingWith(String word){
        TrieNode curr = root;

        // Iterating through the string word.
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.childern[index] == null){
                return 0;
            }
            curr = curr.childern[index];
        }
        return curr.prefixCount;
    }

    // In this function we are removing the word from "TRIE".
    public void erase(String word){
        TrieNode curr = root;
        // Iterating through the string word.
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            // Store the parent of current character.
            TrieNode parent = curr;
            curr = curr.childern[index];
            curr.prefixCount--;
            // If the prefixCount of current node is 0 that means we have reached at the end of the word that has to be deleted.
            if(curr.prefixCount == 0){
                parent.childern[index] = null;
            }
        }
        curr.wordCount--;
    }

}

