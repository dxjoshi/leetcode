# Advanced Data Structures:



### Trie: Prefix tree
- Tries are used to represent the “Retrieval” of data and thus the name Trie.
- For ex: the word “abacaba” has the following prefixes: **a, ab, aba, abac, abaca, abacab**    
- A Trie is a special data structure used to store strings that can be visualized like a graph. It consists of nodes and edges. 
- Strings are stored in a top to bottom manner on the basis of their prefix in a trie. All prefixes of length 1 are stored at until level 1, all prefixes of length 2 are sorted at until level 2 and so on.        
- A Trie consists of a special node called the root node. It doesn't have any incoming edges and can contain max. 26 nodes.    
- Each node consists of at max 26 children and edges connect each parent node to its children, each being a pointer to English alphabet letters(a-z). A separate edge is maintained for every edge.

### Suffix Trees
- Suffix tree is a compressed trie of all the suffixes of a given string.   
- Suffix trees help in solving a lot of string related problems like pattern matching, finding distinct substrings in a given string, finding longest palindrome etc.
- **Compressed Trie:**
    - All edges of a trie that direct to a node having single child are combined together to form a single edge and their edge labels are concatenated.  
    - Also it has atmost 'N' leaves, where 'N' is the number of strings inserted in the compressed trie.    
    - Now both the facts: Each internal node having atleast two children, and that there are N leaves, implies that there are atmost (2N-1) nodes in the trie. So the space complexity of a compressed trie is O(N) as compared to the O(N^2) of a normal trie. 
- **Suffix Tree:**      
    - A Suffix Tree for a given text is a compressed trie for all suffixes of the given text.   

## Segement Tree    
- A Segment Tree (ST) is a binary tree that is build on top of an (usually integer) array so that we can solve the Range Min/Max/Sum Query as well as any Range Update Query of this array in O(log N) time instead of the naive O(N) time. 
- Given an array A of N (usually integer) elements, we can build the corresponding RMinQ/RMaxQ/RSumQ Segment Tree in O(N) time.
