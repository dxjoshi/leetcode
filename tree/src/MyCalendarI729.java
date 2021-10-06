import java.util.TreeSet;

/*
*
* 729. My Calendar I
*
* You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
* A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
* The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
*
* Implement the MyCalendar class:
*
* MyCalendar() Initializes the calendar object.
* boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
*
* */
public class MyCalendarI729 {

    public MyCalendarI729() {

    }

    TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);

    public boolean book(int s, int e) {
        int[] book = new int[] { s, e }, floor = books.floor(book), ceiling = books.ceiling(book);
        if (floor != null && s < floor[1]) return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < e) return false; // ceiling start within (s, e)
        books.add(book);
        return true;
    }
}
