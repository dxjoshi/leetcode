import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NMeetingsInOneRoom_GFG {
    static class Meeting {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(int start[], int end[], int n) {
        Meeting[] arr = new Meeting[n];
        for(int i=0; i<start.length; i++) {
            arr[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.end));
        Meeting curr = arr[0];
        int count = 1;
        for(int i=1; i<n; i++) {
            if (arr[i].start > curr.end) {
                count++;
                curr = arr[i];
            }
        }

        return count;

    }

    public static int maxMeetings2(int start[], int end[], int n) {
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

        for(int i=0; i<start.length; i++) {
            pq.add(new Meeting(start[i], end[i]));
        }

        Meeting curr = new Meeting(0, 0);
        int count = 0;
        while(!pq.isEmpty()) {
            Meeting next = pq.poll();
            if (next.start > curr.end) {
                count++;
                curr = next;
            }
        }

        return count;
    }
}
