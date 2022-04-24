import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues_225 {
//Just use a queue where you "push to front" by pushing to back and then rotating the queue until the new element is at the front(i.e., size-1 times move the front element to the back).
// https://leetcode.com/problems/implement-stack-using-queues/discuss/62516/Concise-1-Queue-Java-C%2B%2B-Python
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
