# Heap - Priority Queue(Java)

### Types:
- **Max Heap:**
    -   The value of parent node will always be greater than or equal to the value of child node across the tree and the node with highest value will be the root node of the tree.   
    -   **PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());**

- **Min Heap:**  
    -   The value of parent node will always be less than or equal to the value of child node across the tree and the node with lowest value will be the root node of tree. 
    -   By default PriorityQueue in Java implements a minHeap.    
    -   **PriorityQueue<Integer> minHeap = new PriorityQueue<>();**

- **Priority Queue:** 
    -   Priority Queue is similar to queue where we insert an element from the back and remove an element from front, but with a difference that the logical order of elements in the priority queue depends on the priority of the elements. 
    -   **PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));**
                
### Pattern:
1. If the question anyhow requires getting a kth smallest/largest element, we require a heap.
2. If needs kth smallest - **USE MAX HEAP**.
3. If needs kth largest - **USE MIN HEAP**.
