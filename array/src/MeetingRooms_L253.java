import java.util.Arrays;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
*/

public class MeetingRooms_L253 {
    // https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        int [] start = new int [n];
        int [] end = new int [n];

        for(int i=0;i<n;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int j = 0;
        for(int i=0; i<n; i++) {
            if(start[i]<end[j]) {
                count++;
            } else {
                j++;
            }
        }
        return count;
    }

}
