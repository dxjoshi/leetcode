/*
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
*/


import java.util.HashSet;

public class MaximumXOROfTwoNumbersInAnArray421 {
// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap

// example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
// Since the MSB is 3, I'll start from i = 3 to make it simplify.

// i = 3, set = {1000, 0000}, max = 1000
// i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
// i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
// i = 0, set = {1110, 1011, 0111, 0010}, max = 1100

    public int findMaximumXOR1(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }


    // https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                }else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}

