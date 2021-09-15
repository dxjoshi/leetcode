import java.util.Stack;

/*
*
* 232. Implement Queue using Stacks
*
* Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
* Implement the MyQueue class:
* void push(int x) Pushes element x to the back of the queue.
* int pop() Removes the element from the front of the queue and returns it.
* int peek() Returns the element at the front of the queue.
* boolean empty() Returns true if the queue is empty, false otherwise.
*
* */
public class ImplementQueueusingStacks232 {

    Stack<Integer> s1, s2;
    /** Initialize your data structure here. */
    public ImplementQueueusingStacks232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(s1.size() != 0) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while(s2.size() != 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while(s1.size() != 0) {
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while(s2.size() != 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
