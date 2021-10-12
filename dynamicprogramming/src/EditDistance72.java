/*
*
* 72. Edit Distance
*
*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
* You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
* */

public class EditDistance72 {
/*
*
* Initialization!
* D(i,0) = i
* D(0,j) = j
*
* • Recurrence!Relation:#
*   For each i = 1…M
*    For each j = 1…N
*                   {  D(i-1,j) + 1
*    D(i,j)= min    {  D(i,j-1) + 1
*                   {  D(i-1,j-1) + 2; if X(i) ≠ Y(j)
*                                   0; if X(i) = Y(j)
*
* • Termination:#
* D(N,M) is distance
*
*
* */
}
