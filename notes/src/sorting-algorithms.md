## Popular Sorting Algorithms

### Link to Source Code         
- [All Sorting Algos](https://betterexplained.com/articles/sorting-algorithms/)         
- [BubbleSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/BubbleSort.java)            
- [CyclicSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/CyclicSort.java)            
- [InsertionSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/InsertionSort.java)         
- [MergeSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/MergeSort.java)         
- [MergeSortedFiles_Algosec](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/MergeSortedFiles_Algosec.java)          
- [QuickSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/QuickSort.java)         
- [SelectionSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/SelectionSort.java)         
       
### Solutions     

- [MergeSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/MergeSort.java)                 


        //    Divide and conquer technique
        //    1. Find mid index
        //    2. sort the 2 halves, recursively
        //    3. Merge the subarrays
        
            @Override
            public void sort(int[] input) {
                long startTime = System.nanoTime();
                sort(input, 0, input.length-1);
        
                Util.print("Output Array: ", input);
                long endTime = System.nanoTime();
                System.out.println("[Merge Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
            }
        
            private void sort(int[] input, int start, int end) {
                if (start<end) {
                   int mid = start + (end - start)/2;
                   sort(input, start, mid);
                   sort(input, mid+1, end);
                   merge(input, start, mid, end);
                }
            }
        
            void merge(int arr[], int l, int m, int r)
            {
                // Find sizes of two subarrays to be merged
                int n1 = m - l + 1;
                int n2 = r - m;
        
                /* Create temp arrays */
                int L[] = new int[n1];
                int R[] = new int[n2];
        
                /*Copy data to temp arrays*/
                for (int i = 0; i < n1; ++i)
                    L[i] = arr[l + i];
                for (int j = 0; j < n2; ++j)
                    R[j] = arr[m + 1 + j];
        
                // Initial indexes of first and second subarrays
                int i = 0, j = 0;
        
                // Initial index of merged subarray array
                int k = l;
                while (i < n1 && j < n2) {
                    if (L[i] <= R[j]) {
                        arr[k] = L[i];
                        i++;
                    }
                    else {
                        arr[k] = R[j];
                        j++;
                    }
                    k++;
                }
        
                /* Copy remaining elements of L[] if any */
                while (i < n1) {
                    arr[k] = L[i];
                    i++;
                    k++;
                }
        
                /* Copy remaining elements of R[] if any */
                while (j < n2) {
                    arr[k] = R[j];
                    j++;
                    k++;
                }
            }

- [QuickSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/QuickSort.java)                 


        //    Divide and conquer technique
        //    1. Pick a pivot elements(1st/last/median/random)
        //    2. Implement partition(input, pivot) - put pivot at its correct location in the sorted array (smaller elements before pivot, greater elements after pivot)
        //    3. sort the 2 subarrays on either sides of pivot recursively
        
            @Override
            public void sort(int[] input) {
                long startTime = System.nanoTime();
                sort(input, 0, input.length-1);
        
                Util.print("Output Array: ", input);
                long endTime = System.nanoTime();
                System.out.println("[Quick Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
            }
        
            private void sort(int[] input, int start, int end) {
                if (start<end) {
                    //find partition index and sort remaining partitions (excluding partition element)
                   int idx = partition(input, start, end);
                   sort(input, start, idx-1);
                   sort(input, idx+1, end);
                }
            }
        
            private int partition(int[] input, int start, int end) {
                // mark end as pivot index and element
                // To find the partition index j, from start till end-1 check if elements are less than pivot element
                int pIdx = end;
                int pivot = input[pIdx];
                int j = start-1;
                for(int i=start; i<pIdx; i++) {
                    if (input[i] <= pivot) {
                        ++j;
                        Util.swap(input, i, j);
                    }
                }
                Util.swap(input, j+1, pIdx);
                return j+1;
            }

- [MergeSortedFiles_Algosec](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/MergeSortedFiles_Algosec.java)               


        // 0 p1 -> Eugene, Prakash,
        // 1 p2 -> Deepak, Ram, Shiva, Tarun ,Varun
        // 2 p3 -> Vohit
        // File -> List<String> -> 1 GB -> Sort -> 200 MB
    
        private static final String PATH = "C:\\code\\leetcode\\sorting\\src\\resources\\";
        public static void main(String[] args) {
            List<File> inputFiles = Arrays.asList(new File(PATH + "p1.txt"), new File( PATH + "p2.txt"), new File(PATH + "p3.txt"));
            File outputFile = new File("C:\\code\\leetcode\\sorting\\src\\resources\\output.txt");
            solve( inputFiles, outputFile);
        }
    
        static class Pair {
            String line;
            Integer fileId;
    
            public Pair(String line, Integer fileId) {
                this.line = line;
                this.fileId = fileId;
            }
        }
    
        public static void solve(List<File> sortedFiles, File outputFile) {
            // files sorted
            // until file has reached end check all for the smallest and add it to output
            PriorityQueue<Pair> pq  = new PriorityQueue<>(sortedFiles.size(), Comparator.comparing(a -> a.line));
            List<BufferedReader> readers = new ArrayList<>();
            BufferedWriter writer = null;
            try {
    
                for (int i=0; i < sortedFiles.size(); i++) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sortedFiles.get(i))));
                    readers.add(reader);
                }
    
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
    
                for (int i=0; i < readers.size(); i++) {
                    addToQueue(readers, i, pq);
                }
    
                while (!pq.isEmpty()){
                    Pair pair = pq.poll();
                    String line = pair.line;
                    Integer fileId = pair.fileId;
                    writer.write(line);
                    writer.newLine();
                    System.out.println(line);
                    addToQueue(readers, fileId, pq);
                }
                writer.close();
                close(readers);
            }catch (IOException ex) {
                ex.printStackTrace();
            } finally {
            }
        }
    
        private static void close(List<BufferedReader> readers) {
            readers.stream().forEach(bufferedReader -> {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        private static void addToQueue(List<BufferedReader> readers, int fileId, PriorityQueue<Pair> pq) throws IOException {
            BufferedReader reader = readers.get(fileId);
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                pq.offer(new Pair(line, fileId));
            }
        }

- [BubbleSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/BubbleSort.java)                   


           public void sort(int[] input) {
        /*
                Starting on the left, compare adjacent items and keep “bubbling” the larger one to the right (it’s in its final place).
                Bubble sort the remaining N -1 items.
        */
                long startTime = System.nanoTime();
                boolean isSwapped;
        
                for (int i=input.length-1; i>=1 ; i--) {
                    isSwapped = false;
                    for (int j = 0; j <i; j++) {
                        if(input[j] > input[j+1]) {
                            Util.swap(input, j, j+1);
                            isSwapped = true;
                        }
                    }
                    if (!isSwapped) break;
                }
        
                Util.print("Output Array: ", input);
                long endTime = System.nanoTime();
                System.out.println("[Bubble Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
            }
- [CyclicSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/CyclicSort.java)                   


        public void sort(int[] input) {
            long startTime = System.nanoTime();
            for (int i=0; i<=input.length-1;) {
                if (input[i]-1 != i) {
                    Util.swap(input, i, input[i]-1);
                } else {
                    i++;
                }
            }
    
            Util.print("Output Array: ", input);
            long endTime = System.nanoTime();
            System.out.println("[Selection Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
        }

- [InsertionSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/InsertionSort.java)                 


        //    Start with a sorted list of 1 element on the left, and N-1 unsorted items on the right.
        //    Take the first unsorted item (element #2) and insert it into the sorted list, moving elements as necessary.
        //    We now have a sorted list of size 2, and N -2 unsorted elements. Repeat for all elements.
            @Override
            public void sort(int[] input) {
                long startTime = System.nanoTime();
                for (int i=0; i<input.length-1; i++) {
                    for (int j = i+1; j>0; j--) {
                        if(input[j] < input[j-1]) {
                            Util.swap(input, j, j-1);
                        } else {
                            break;
                        }
                    }
                }
        
                Util.print("Output Array: ", input);
                long endTime = System.nanoTime();
                System.out.println("[Insertion Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
            }

- [SelectionSort](https://github.com/dxjoshi/leetcode/blob/55ac2045370626042b04da3182012b27e368a71a/sorting/src/SelectionSort.java)                 


        //    Scan all items and find the smallest. Swap it into position as the first item.
        //    Repeat the selection sort on the remaining N-1 items.
            @Override
            public void sort(int[] input) {
                long startTime = System.nanoTime();
                int idx;
        
                for (int i=input.length-1; i>=1 ; i--) {
                    idx = 0;
                    for (int j = 0; j <=i; j++) {
                        if(input[j] > input[idx]) {
                            idx = j;
                        }
                    }
                    Util.swap(input, i, idx);
                }
        
                Util.print("Output Array: ", input);
                long endTime = System.nanoTime();
                System.out.println("[Selection Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
            }