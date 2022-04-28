class CircularDequeue_641 {
    // https://leetcode.com/problems/design-circular-deque/discuss/149371/Java-doubly-LinkedList-solution-very-straightforward
    // https://leetcode.com/problems/design-circular-deque/discuss/161228/Straightforward-w-Array-in-Java(corner-cases)

    class DoublyLinkedList{
        DoublyLinkedList prev;
        DoublyLinkedList next;
        int val;
        DoublyLinkedList(int val){
            this.val = val;
        }
    }

    DoublyLinkedList head;
    DoublyLinkedList tail;
    int k;
    int size;

    public CircularDequeue_641(int k) {
        head = new DoublyLinkedList(-1);
        tail = new DoublyLinkedList(-1);
        head.next = tail;
        tail.prev = head;
        this.k = k;
        this.size = size;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == k) return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        DoublyLinkedList curr = head.next;
        head.next = temp;
        temp.prev = head;
        temp.next = curr;
        curr.prev = temp;
        size += 1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == k) return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        DoublyLinkedList curr = tail.prev;
        temp.next = tail;
        tail.prev = temp;
        curr.next = temp;
        temp.prev = curr;
        size += 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;

        DoublyLinkedList curr = head.next;
        head.next = curr.next;
        head.next.prev = head;
        size -= 1;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;

        DoublyLinkedList curr = tail.prev;
        tail.prev = curr.prev;
        tail.prev.next= tail;
        size -= 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) return -1;

        return head.next.val;

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) return -1;
        return tail.prev.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }

}

