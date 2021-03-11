/*
 *
 * 401. Binary Watch
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right. For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 *
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryWatch {
    int[] hoursArr = new int[]{1, 2, 4, 8};
    int[] minsArr = new int[]{1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
        // path
        // selection list
        // end condition

        List<String> result = new ArrayList<>();
        readBinaryWatch(num, result, 0, 0, 0);
        Collections.sort(result);
        return result;
    }

    public void readBinaryWatch(int nums, List<String> result, int hours, int mins, int start) {
        // end condition
        if  (nums <= 0 ){
            if ((hours < 12) && (mins < 60)) {
                if  (mins < 10) {
                    result.add(hours + ":0" + mins);
                } else {
                    result.add(hours + ":"+ mins);
                }
            }
        } else {
            // selection list
            for(int i = start; i<hoursArr.length + minsArr.length; i++) {
                // increase hours
                if (i < 4) readBinaryWatch(nums-1, result, hours + hoursArr[i], mins, i+1);
                else {
                    // increase mins
                    readBinaryWatch(nums-1, result, hours, mins + minsArr[i-4], i+1);
                }
            }
        }
    }
}