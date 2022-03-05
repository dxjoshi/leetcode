/*
You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
*/

import java.util.Arrays;

public class MaxXORWithAnElementFromArray1707 {
    // https://leetcode.com/problems/maximum-xor-with-an-element-from-array/discuss/1080060/Java-oror-Trie-%2B-Sort-%2B-Bit-Manipulation-oror-O(n*logn-%2B-k*logk)

    // O(nums.length*log(nums.length) + queries.length*log(queries.length))
    public int[] maximizeXor(int[] nums, int[][] queries) {

        Trie trie = new Trie();
        int len = queries.length;
        int len2 = nums.length;
        int[] ans = new int[len];

        int[][] temp = new int[len][3];
        for (int i = 0; i < len; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(temp, (a,b) -> a[1]-b[1]);

        int index = 0;
        for (int[] query : temp) {
            while (index < len2 && nums[index] <= query[1]) {
                trie.addWord(nums[index]);
                index++;
            }

            ans[query[2]] = trie.searchWord(query[0]);
        }
        return ans;
    }

}

class Trie {

    private class Node {

        int data;
        Node[] children;

        public Node(int data) {
            this.data = data;
            this.children = new Node[2];
        }

    }

    private Node root;
    int count;

    // O(1)
    public Trie() {
        this.root = new Node(-1);
        this.count = 0;
    }

    // O(32)
    public void addWord(int num) {
        this.count++;
        Node curr = root;
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            int bit = num & mask;
            bit = (bit != 0) ? 1 : 0;
            Node temp = curr.children[bit];
            if (temp == null) {
                temp = new Node(bit);
                curr.children[bit] = temp;
            }
            curr = temp;
        }
    }

    // O(32)
    public int searchWord(int num) {

        if (count == 0)
            return -1;

        Node curr = root;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            int bit = num & mask;
            bit = (bit != 0) ? 1 : 0;
            int toggle = bit ^ 1;
            Node temp = curr.children[toggle];
            if (temp != null) {
                curr = temp;
                ans |= mask;
            } else
                curr = curr.children[bit];
        }
        return ans;
    }

}

