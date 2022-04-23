## Popular Java LLD questions solution

### Link to Custom Java Implementation              
- [Custom Connection Pool](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/customConnectionPool/BasicConnectionPool.java)                              
- [Custom ThreadPool](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomThreadPool.java)             
- [Custom ThreadPoolExecutor](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomThreadPoolExecutor.java)             
- [Custom CountDownLatch](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CountdownLatchCustom.java)             
- [Custom CyclicBarrier](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CyclicBarrierCustom.java)              
- [Custom Semaphore](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/SemaphoreCustom.java)                  
- [Custom ReentrantLock](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/ReentrantLockCustom.java)              
- [Custom ReentrantReadWriteLock](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/ReentrantReadWriteLock.java)                     
- [Producer Consumer BlockingQueue](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/ProducerConsumerBlockingQueue.java)               
- [Producer Consumer WaitNotify](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/ProducerConsumerWaitNotify.java)                  

               
### Link to Custom Data Structures Implementations        
- [LRU Cache](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/data-structures/src/LRUCache146_V2.java)                         
- [HashMap](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/data-structures/src/DesignHashMap706.java)                           
- [LFU Cache](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/data-structures/src/LFUCache460_V2.java)         
- [Min Stack](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/data-structures/src/MinStack155.java)         
- [Stack Using Queues]()            
- [Queues Using Stack]()                
- [Custom ArrayList](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/ArrayListCustom.java)                          
- [Custom BlockingQueue](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/BlockingQueueCustomTest.java)          
- [Custom Dequeue](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomDequeue.java)            
- [Custom HashSet](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomHashSet.java)                
- [Custom LinkedHashMap](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomLinkedHashMap.java)                          
- [Custom LinkedHashSet](https://github.com/dxjoshi/leetcode/blob/0653ff88be0c51b9e2b6337b271caad0c1e54415/custom-implementation/src/CustomLinkedHashSet.java)                          
       
### Solutions     

- [Custom Connection Pool]()               



- [Custom ThreadPool]()



- [Custom ThreadPoolExecutor]()



- [Custom CountDownLatch]()



- [Custom CyclicBarrier]()



- [Custom Semaphore]()     



- [Custom ReentrantLock]()



- [Custom ReentrantReadWriteLock]()     



- [Producer Consumer BlockingQueue]()



- [Producer Consumer WaitNotify]()     


               
- [LRU Cache]()               



- [HashMap]()               


        class Node {
            int key;
            int val;
            Node next;
            Node (int key, int value) {
                this.key = key;
                this.val = value;
                this.next = null;
            }
        }
        Node[] nodes;
        int length;
    
        /** Initialize your data structure here. */
        public DesignHashMap706() {
            nodes = new Node[10000];
            length = nodes.length;
        }
    
        int hashCode(int key) {
            return key % length;
        }
    
        Node find(Node bucket, int key) {
            Node curr = bucket, prev = null;
            while (curr != null) {
                if (curr.key == key) {
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }
    
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = hashCode(key);
            if (nodes[idx] == null) {
                nodes[idx] = new Node(-1, -1);
            }
            Node prev = find(nodes[idx], key);
    
            if (prev.next == null) {
                prev.next = new Node(key, value);
            } else {
                prev.next.val = value;
            }
        }
    
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = hashCode(key);
            if (nodes[idx] == null) {
                return -1;
            }
            Node prev = find(nodes[idx], key);
    
            if (prev.next != null) {
                return prev.next.val;
            }
            return -1;
    
        }
    
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = hashCode(key);
            if (nodes[idx] == null) {
                return;
            }
            Node prev = find(nodes[idx], key);
    
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }

- [LFU Cache]()



- [Min Stack]()



- [Stack Using Queues]()



- [Queues Using Stack]()     



- [Custom ArrayList]()               



- [Custom BlockingQueue]()



- [Custom Dequeue]()



- [Custom HashSet]()     



- [Custom LinkedHashMap]()               



- [Custom LinkedHashSet]()               



