import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAvailableTimes_BloombergKarat {

    /*
    We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.

    Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).

    Sample input:


    p1_meetings = [
      (1230, 1300), -- 12:30pm to 1:00pm
      ( 845, 900),
      (1300, 1500),
    ]

    p2_meetings = [
      ( 0, 844),
      ( 930, 1200),
      (1515, 1546),
      (1600, 2400),
    ]

    p3_meetings = [
      ( 845, 915),
      (1515, 1545),
      (1235, 1245),
    ]

    p4_meetings = [
      ( 1, 5),
      (844, 900),
      (1515, 1600)
    ]

    schedules1 = [p1_meetings, p2_meetings, p3_meetings]
    schedules2 = [p1_meetings, p3_meetings]
    schedules3 = [p2_meetings, p4_meetings]

    Expected output:

    findAvailableTimes(schedules1)
     => [  844,  845 ],
        [  915,  930 ],
        [ 1200, 1230 ],
        [ 1500, 1515 ],
        [ 1546, 1600 ]

    findAvailableTimes(schedules2)
     => [    0,  845 ],
        [  915, 1230 ],
        [ 1500, 1515 ],
        [ 1545, 2400 ]

    findAvailableTimes(schedules3)
        [  900,  930 ],
        [ 1200, 1515 ]

    n = number of meetings
    s = number of schedules
    */
    public static void main(String[] argv) {
        int[][] p1Meetings = {
                {1230, 1300},
                { 845,  900},
                {1300, 1500}
        };
        int[][] p2Meetings = {
                { 0, 844},
                { 930, 1200},
                {1515, 1546},
                {1600, 2400}
        };
        int[][] p3Meetings = {
                { 845,  915},
                {1515, 1545},
                {1235, 1245}
        };
        int[][] p4Meetings = {
                {   1,  5},
                { 844, 900},
                {1515, 1600}
        };

        List<int[][]> schedules1 = Arrays.asList(p1Meetings, p2Meetings, p3Meetings);
        List<int[][]> schedules2 = Arrays.asList(p1Meetings, p3Meetings);
        List<int[][]> schedules3 = Arrays.asList(p2Meetings, p4Meetings);
        int[][] result1 = findAvailableTimes(schedules1);
        int[][] result2 = findAvailableTimes(schedules2);
        int[][] result3 = findAvailableTimes(schedules3);

    }

    class Entry {
        int startTime;
        int[] sched;
        Entry(int[] schedule) {
            startTime = schedule[0];
            sched = schedule;
        }
    }
    public static int[][] findAvailableTimes(List<int[][]> schedules) {

        List<int[]> list = new ArrayList<>();
        for(int[][] schedule : schedules) {
            for(int[] interval : schedule) {
                list.add(interval);
            }
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(list.get(0));

        for(int i=1; i<list.size(); i++) {
            int[] curr = list.get(i);
            int[] selected = result.get(result.size()-1);
            if  (curr[0] < selected[1]) {
                selected[0] = Math.max(curr[0], selected[0]);
                selected[1] = Math.min(curr[1], selected[1]);
            } else {
                result.add(curr);
            }
        }

        int[][] res = new int[result.size()][2];
        int i =0;
        for(int[] val : result) {
            res[i++] = val;
        }
        System.out.println("===");
        print(res);

        return res;

    }

    public static void print(int[][] arr) {
        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i][0] +", "+arr[i][1]);
        }
    }

}

