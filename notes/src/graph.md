# Graph

- **Terminologies:**
    - A non-linear data structure consisting of vertices and edges.
    - **Vertex**: Nodes such as A, B, and C are called vertices of the graph.
    - **Edge**: The connection between two vertices are the edges of the graph. The connection between person A and B is an edge of the graph.
    - **Path**: the sequence of vertices to go through from one vertex to another. For ex., a path from A to C is [A, B, C], or [A, G, B, C], or [A, E, F, D, B, C]. **Note**: there can be multiple paths between two vertices.
    - **Path Length**: the number of edges in a path. For ex., the path lengths from person A to C are 2, 3, and 5, respectively.
    - **Cycle**: A path where the starting point and endpoint are the same vertex. For ex., [A, B, D, F, E] forms a cycle. Similarly, [A, G, B] forms another cycle.
    - **Negative Weight Cycle**: In a “weighted graph”, if the sum of the weights of all edges of a cycle is a negative value, it is a negative weight cycle. For ex., the sum of weights is -3.
    - **Connectivity**: if there exists at least one path between two vertices, these two vertices are connected. For ex., A and C are connected because there is at least one path connecting them.
    - **Degree of a Vertex**: the term “degree” applies to unweighted graphs. The degree of a vertex is the number of edges connecting the vertex. For ex., the degree of vertex A is 3 because three edges are connecting it.
    - **In-Degree**: “in-degree” is a concept in directed graphs. If the in-degree of a vertex is d, there are d directional edges incident to the vertex. For ex., A’s indegree is 1, i.e., the edge from F to A.
    - **Out-Degree**: “out-degree” is a concept in directed graphs. If the out-degree of a vertex is d, there are d edges incident from the vertex. For ex., A’s outdegree is 3, i,e, the edges A to B, A to C, and A to G.
    
    
- [Union Find Implementation + Optimizations](https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3844/)    

- **Minimum Spanning Tree:**
    - A **spanning tree** is a connected subgraph in an undirected graph where all vertices are connected with the minimum number of edges.     
    - A **minimum spanning tree** is a spanning tree with the minimum possible total edge weight in a “weighted undirected graph”.  
    - **[Cut property:](https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3855/)** 
        - **A cut** is a partition of vertices in a “graph” into two disjoint subsets.    
        - **A crossing edge** is an edge that connects a vertex in one set with a vertex in the other set.
        - The cut property provides theoretical support for Kruskal’s algorithm and Prim’s algorithm. The cut property refers to:  
        > For any cut C of the graph, if the weight of an edge E in the cut-set of C is strictly smaller than the weights of all other edges of the cut-set of C, then this edge belongs to all MSTs of the graph.  
    - Two algorithms for constructing a “minimum spanning tree”:
        - **Kruskal’s Algorithm**:   
        - **Prim’s algorithm**:  
    
- **Single Source Shortest Path:**     
    - Two single source shortest path algorithms:
        - **Dijkstra’s algorithm**: Can only be used to solve the “single source shortest path” problem in a weighted directed graph with non-negative weights. 
        - **Bellman-Ford algorithm**: Can solve the “single-source shortest path” in a weighted directed graph with any weights, including, of course, negative weights.    
        
- **Topological Sorting:**      
    - It provides a linear sorting based on the required ordering between vertices in directed acyclic graphs. To be specific, given vertices u and v, to reach vertex v, we must have reached vertex u first, u has to appear before v in the ordering. The most popular algorithm for “topological sorting” is **Kahn’s algorithm.**
    - **Limitations:**
        - It only works with graphs that are directed and acyclic.
        - There must be at least one vertex in the “graph” with an “in-degree” of 0. If all vertices in the “graph” have a non-zero “in-degree”, then all vertices need at least one vertex as a predecessor. In this case, no vertex can serve as the starting vertex.    

-           
      
      