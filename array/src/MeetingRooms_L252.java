import java.util.Arrays;
import java.util.Comparator;
/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
*/
public class MeetingRooms_L252 {
    // https://leetcode.com/problems/meeting-rooms/
    // https://leetcode.com/problems/meeting-rooms/discuss/67786/AC-clean-Java-solution

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i+1][0]<intervals[i][1]){
                return false;
            }
        }
        return true;
    }
}
