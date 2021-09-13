/*
*
* 344. Reverse String
*
* Write a function that reverses a string. The input string is given as an array of characters s.
*
* */
public class L344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            --j;++i;
        }
    }
}
