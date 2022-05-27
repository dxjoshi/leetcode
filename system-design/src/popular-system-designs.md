## Popular System Designs available over internet
       
### Useful Links            
- [Scalable Logging Architecture](https://www.elastic.co/guide/en/logstash/current/deploying-and-scaling.html)           
- [Scalable Metrics Aggregation & Monitoring System - Video](https://www.youtube.com/watch?v=UEJ6xq4frEw)                     
- [High-Throughput Metrics System - Two Sigma](https://www.twosigma.com/articles/building-a-high-throughput-metrics-system-using-open-source-software/)                    
- [Design a Search Engine - Video](https://www.youtube.com/watch?v=xqzyXicFrTA) 
- [Search System - Video](https://www.youtube.com/watch?v=CeGtqouT8eA)        
- [Distributed Web Crawler - Video](https://www.youtube.com/watch?v=BKZxZwUgL3Y)       
- [AutoComplete/ TypeAhead System - Tushar Roy Video](https://www.youtube.com/watch?v=us0qySiUsGU)             
- [TAO Distributed Graph Data Store - Video](https://www.youtube.com/watch?v=5RfFhMwRAic)       
- [Memcached by Mark - Video](https://www.youtube.com/watch?v=UH7wkvcf0ys)          
- [In-Memory Cache - Video](https://www.youtube.com/watch?v=kz5D6gToUck)        
- [Distributed Cache - Video](https://www.youtube.com/watch?v=tHO2groauZk)          
- [Replicated (in-process) Cache - Video](https://www.youtube.com/watch?v=Ov2q8VdyrM0&list=PLdsOZAx8I5umhnn5LLTNJbFgwA3xbycar&index=59)          
- [Near Cache Hybrid - Video](https://www.youtube.com/watch?v=uBqysgyyquk&list=PLdsOZAx8I5umhnn5LLTNJbFgwA3xbycar&index=58)    
- [Choosing Right Caching Topology - Video](https://www.youtube.com/watch?v=vo8-HZjXjvc&list=PLdsOZAx8I5umhnn5LLTNJbFgwA3xbycar&index=57)
- [Kafka vs Messaging Queues - Video](https://www.youtube.com/watch?v=lwMjjTT1Q-Q&list=PLdsOZAx8I5umhnn5LLTNJbFgwA3xbycar&index=135)                  
- [Bloom Filter](https://medium.com/system-design-blog/bloom-filter-a-probabilistic-data-structure-12e4e5cf0638)            
- [Introduction to architecting systems for scale](https://lethain.com/introduction-to-architecting-systems-for-scale/)         

### Topics          
- [System Design Template](#system-design-template)             
- [Terminologies](#terminologies)       
- [Latency Comparison Numbers](#latency-comparison-numbers)     
- [Back of the envelope estimations](#back-of-the-envelope-estimations)     
- [Load Balancer](#load-balancer)           
- [Caching](#caching)           
- [Data Partitioning](#data-partitioning)       
- [Indexes](#indexes)           
- [Proxy](#proxy)           
- [Reverse Proxy](#reverse-proxy)           
- [NoSQL DBs](#nosql-dbs)       
- [CAP Theorem](#cap-theorem)           
- [PACELC Theorem](#pacelc-theorem)         
- [Consistent Hashing](#consistent-hashing)             
- [Communication Protocols](#communication-protocols)       
- [Bloom Filters](#bloom-filters)           
- [Quorum](#quorum)             
- [Dos](#dos)       
- [Dont's](#donts)      
                       
### Leetcode                
- Credit: [_Spook_](https://leetcode.com/discuss/interview-question/system-design?currentPage=1&orderBy=most_relevant&query=_spook_)        
        
- **Bidding/Auction System(Ebay)**              
[Bidding/Auction System(Ebay)](https://github.com/dxjoshi/leetcode/blob/0897790bc981577a1715e1dff5b24787265398ad/system-design/resources/leetcode_spook_designs/Auction.png)      
![Bidding System](https://github.com/dxjoshi/leetcode/blob/0897790bc981577a1715e1dff5b24787265398ad/system-design/resources/leetcode_spook_designs/Auction.png)     
        
- **Storage System(Dropbox)**               
[Storage System](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Dropbox.png)      
![Storage System](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Dropbox.png)     
        
- **Social Media System(Instagram/Snap)**               
[Instagram](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Instagram.png)     
![Instagram](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Instagram.png)        
        
- **Video Streaming System(Netflix/Amazon Prime)**              
[Netflix](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Netflix.png)     
![Netflix](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Netflix.png)        
        
- **Tinder System Design**              
[Tinder](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Tinder.png)       
![Tinder](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Tinder.png)      
        
- **Ride Sharing System(Uber/Lyft)**                
[Uber](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Uber.png)       
![Uber](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/leetcode_spook_designs/Uber.png)      
        
- **Messaging/Chat System(Whatsapp)**               
[Whatsapp](https://github.com/dxjoshi/leetcode/blob/master/system-design/resources/leetcode_spook_designs/WhatsApp.png)     
![Whatsapp](https://github.com/dxjoshi/leetcode/blob/master/system-design/resources/leetcode_spook_designs/WhatsApp.png)        
        
### Exponent Youtube Channel        
        
- **Analytics Platform(Metrics & Logging)**     
[Analytics Platform](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/analytics-platform-exponent.png)     
![Analytics Platform](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/analytics-platform-exponent.png)        
        
- **Instagram**     
[Instagram](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/instagram-exponent.png)       
![Instagram](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/instagram-exponent.png)      
        
- **Parking Garage DB Schema**      
[Parking Garage-1](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-2.png)     
![Parking Garage-1](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-2.png)        
        
- **Parking Garage APIs**       
[Parking Garage-2](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-3.png)     
![Parking Garage-2](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-3.png)        
        
- **Parking Garage**        
[Parking Garage-3](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-1.png)     
![Parking Garage-3](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/parking-garage-exponent-1.png)        
        
- **Twitter**       
[Twitter](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/twitter-exponent.png)       
![Twitter](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/twitter-exponent.png)      
        
- **Youtube**       
[Youtube](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/youtube-exponent.png)       
![Youtube](https://github.com/dxjoshi/leetcode/blob/4c5e7ce6041d064b5f82682d677aaccb13255c65/system-design/resources/youtube-exponent.png)      
        


### System Design Template 
- [Topcat Article](https://leetcode.com/topcat/)

- **FEATURE EXPECTATIONS:** Functional & Non Functional Requirements [5 min]            
    - Use cases   
    - Scenarios that will not be covered  
    - Who will use    
    - How many will use   
    - Usage patterns  
    
- **ESTIMATIONS:** [5 min] (Ask if needed to do the estimations) 
    - Throughput (QPS for read and write queries) 
    - Latency expected from the system (for read and write queries)   
    - Read/Write ratio    
    - Traffic estimates   
        - Write (QPS, Volume of data)   
        - Read  (QPS, Volume of data)   
    - Storage estimates   
    - Memory estimates    
        - If we are using a cache, what is the kind of data we want to store in cache   
        - How much RAM and how many machines do we need for us to achieve this ?    
        - Amount of data you want to store in disk/ssd  
        
- **DESIGN GOALS:** [5 min]    
    - Latency and Throughput requirements 
    - Consistency vs Availability  [Weak/strong/eventual => consistency | Failover/replication => availability]
       
- **HIGH LEVEL DESIGN:** [5-10 min]    
    - APIs for Read/Write scenarios for crucial components    
    - Database schema 
    - Basic algorithm 
    - High level design for Read/Write scenario   
    
- **DEEP DIVE:** [15-20 min]   
    - Scaling the algorithm   
    - Scaling individual components:  
        - Availability, Consistency and Scale story for each component 
        - Consistency and availability patterns     
    - Think about the following components, how they would fit in and how it would help   
        - DNS  
        - CDN [Push vs Pull]   
        - Load Balancers [Active-Passive, Active-Active, Layer 4, Layer 7] 
        - Reverse Proxy    
        - Application layer scaling [Microservices, Service Discovery] 
        - DB [RDBMS, NoSQL]    
            - RDBMS     
                - Master-slave, Master-master, Federation, Sharding, Denormalization, SQL Tuning   
            - NoSQL 
                - Key-Value, Wide-Column, Graph, Document  
                - Fast-lookups:   
                    - RAM [Bounded size] => Redis, Memcached 
                    - AP [Unbounded size] => Cassandra, RIAK, Voldemort   
                    - CP [Unbounded size] => HBase, MongoDB, Couchbase, DynamoDB  
        - Caches   
            - Client caching, CDN caching, Webserver caching, Database caching, Application caching, Cache @Query level, Cache @Object level    
            - Eviction policies:    
                - Cache aside  
                - Write through    
                - Write behind 
                - Refresh ahead    
        - Asynchronism 
            - Message queues    
            - Task queues   
            - Back pressure 
        - Communication    
            - TCP   
            - UDP   
            - REST  
            - RPC   
        
- **JUSTIFY:** [5 min] 
    - Throughput of each layer    
    - Latency caused between each layer   
    - Overall latency justification   
	
### Terminologies:  
    - Domain Name System (DNS): 
    - Relational Databases (RDBMS) and NoSQL Databases:
    - Database Sharding
    - Vertical and Horizontal Scaling:
    - Load Balancer
    - Database Replication
    - Cache
    - CDN (Content Delivery Network)
    - Multi Region Setup
    - Message Queue
    - Logging
    - Metrics - CPU, memory, disk I/o
    - Automation
    - CAP Theorem
    

### Latency Comparison Numbers:    
    L1 cache reference                           0.5 ns
    Branch mispredict                            5   ns
    L2 cache reference                           7   ns                      14x L1 cache
    Mutex lock/unlock                           25   ns
    Main memory reference                      100   ns                      20x L2 cache, 200x L1 cache
    Compress 1K bytes with Zippy            10,000   ns       10 us
    Send 1 KB bytes over 1 Gbps network     10,000   ns       10 us
    Read 4 KB randomly from SSD*           150,000   ns      150 us          ~1GB/sec SSD
    Read 1 MB sequentially from memory     250,000   ns      250 us
    Round trip within same datacenter      500,000   ns      500 us
    Read 1 MB sequentially from SSD*     1,000,000   ns    1,000 us    1 ms  ~1GB/sec SSD, 4X memory
    HDD seek                            10,000,000   ns   10,000 us   10 ms  20x datacenter roundtrip
    Read 1 MB sequentially from 1 Gbps  10,000,000   ns   10,000 us   10 ms  40x memory, 10X SSD
    Read 1 MB sequentially from HDD     30,000,000   ns   30,000 us   30 ms 120x memory, 30X SSD
    Send packet CA->Netherlands->CA    150,000,000   ns  150,000 us  150 ms
    
    Notes
    -----
    1 ns = 10^-9 seconds
    1 us = 10^-6 seconds = 1,000 ns
    1 ms = 10^-3 seconds = 1,000 us = 1,000,000 ns


### Back of the envelope estimations:
    Example: Estimate Twitter QPS and storage requirements
    Please note the following numbers are for this exercise only as they are not real numbers
    from Twitter.
    Assumptions:
    • 300 million monthly active users.
    • 50% of users use Twitter daily.
    • Users post 2 tweets per day on average.
    • 10% of tweets contain media.
    • Data is stored for 5 years.
    Estimations:
    Query per second (QPS) estimate:
    • Daily active users (DAU) = 300 million * 50% = 150 million
    • Tweets QPS = 150 million * 2 tweets / 24 hour / 3600 seconds = ~3500
    • Peek QPS = 2 * QPS = ~7000
    We will only estimate media storage here.
    • Average tweet size:
    • tweet_id 64 bytes
    • text 140 bytes
    • media 1 MB
    • Media storage: 150 million * 2 * 10% * 1 MB = 30 TB per day
    • 5-year media storage: 30 TB * 365 * 5 = ~55 PB
    
  
### Load Balancer      
    - It helps to spread the traffic across a cluster of servers to improve responsiveness and availability of applications, websites or databases.     
    - A load balancer sits between the client and the server accepting incoming network and application traffic and distributing the traffic across multiple backend servers using various algorithms.      
    - It prevents any one application server from becoming a single point of failure.       
    - We can add LBs at three places:   
        - Between the user and the web server.      
        - Between web servers and an internal platform layer, like application servers or cache servers.
        - Between internal platform layer and database.

### Caching    
    - Caches take advantage of the locality of reference principle: recently requested data is likely to be requested again.    
    - Types of Caches:  
        - **Write-through cache:** Data is written into the cache and the corresponding database simultaneously. The cached data allows for fast retrieval and, since the same data gets written in the permanent storage, we will have complete data consistency between the cache and the storage. Also, this scheme ensures that nothing will get lost in case of a crash, power failure, or other system disruptions.   
        - **Write-around cache:** Similar to write-through cache, but data is written directly to permanent storage, bypassing the cache. This can reduce the cache being flooded with write operations that will not subsequently be re-read, but has the disadvantage that a read request for recently written data will create a “cache miss” and must be read from slower back-end storage and experience higher latency.   
        - **Write-back cache:** Data is written to cache alone, and completion is immediately confirmed to the client. The write to the permanent storage is done after specified intervals or under certain conditions. This results in low-latency and high-throughput for write-intensive applications; however, this speed comes with the risk of data loss in case of a crash or other adverse event because the only copy of the written data is in the cache.    
    - **Content Delivery (or Distribution) Network (CDN):**
        - CDNs are a kind of cache that comes into play for sites serving large amounts of static media. 
        - In a typical CDN setup, a request will first ask the CDN for a piece of static media; the CDN will serve that content if it has it locally available. 
        - If it isn’t available, the CDN will query the back-end servers for the file, cache it locally, and serve it to the requesting user.  
      
### Data Partitioning  
    - Data partitioning is a technique to break a big database (DB) into many smaller parts.    
    - **Horizontal Partitioning(Sharding):** In this scheme, we put different rows into different tables. eg. if we store different places in a table, we can decide that locations with ZIP codes less than 10000 are stored in one table and places with ZIP codes greater than 10000 are stored in a separate table.      
    - **Vertical Partitioning:** We divide our data to store tables related to a specific feature in their own server. eg. if we are building an Instagram-like application - where we need to store data related to users, photos they upload, and people they follow - we can decide to place user profile information on one DB server, friend lists on another, and photos on a third server.   
    
### Indexes    
    - The goal of creating an index on a particular table in a database is to make it faster to search through the table and find the row or rows that we want.  
    - **Disadvantage:** An index can dramatically speed up data retrieval but may itself be large due to the additional keys, **which slow down data insertion & update.**      

### Proxy   
    - A proxy server is an intermediate server between the client and the back-end server.   
    - Clients connect to proxy servers to make a request for a service like a web page, file, connection, etc.   
    - In short, a proxy server is a piece of software or hardware that acts as an intermediary for requests from clients seeking resources from other servers.      

### Reverse Proxy      
    - A reverse proxy retrieves resources on behalf of a client from one or more servers. These resources are then returned to the client, appearing as if they originated from the proxy server itself.    
    
### NoSQL DBs  
    - **Key-Value Stores:** Data is stored in an array of key-value pairs. The ‘key’ is an attribute name which is linked to a ‘value’. ex. Redis, Voldemort, and Dynamo.   
    - **Document Databases:** In these databases, data is stored in documents (instead of rows and columns in a table) and these documents are grouped together in collections. Each document can have an entirely different structure. ex. CouchDB and MongoDB.    
    - **Wide-Column Databases:** Instead of ‘tables,’ in columnar databases we have column families, which are containers for rows. Unlike relational databases, we don’t need to know all the columns up front and each row doesn’t have to have the same number of columns. Columnar databases are best suited for analyzing large datasets - ex. Cassandra and HBase.    
    - **Graph Databases:** These databases are used to store data whose relations are best represented in a graph. Data is saved in graph structures with nodes (entities), properties (information about the entities), and lines (connections between the entities). ex. Neo4J and InfiniteGraph.    
    
### CAP Theorem    
    - In the presence of a network partition, a distributed system must choose either Consistency(chosen by RDBMS) or Availability(chosen by NoSQL DBs).    
    - **Consistency (C):** All nodes see the same data at the same time. This means users can read or write from/to any node in the system and will receive the same data. It is equivalent to having a single up-to-date copy of the data.  
    - **Availability (A):** Availability means every request received by a non-failing node in the system must result in a response. Even when severe network failures occur, every request must terminate. In simple terms, availability refers to a system’s ability to remain accessible even if one or more nodes in the system go down.        
    - **Partition tolerance (P):** A partition is a communication break (or a network failure) between any two nodes in the system, i.e., both nodes are up but cannot communicate with each other. A partition-tolerant system continues to operate even if there are partitions in the system. Such a system can sustain any network failure that does not result in the failure of the entire network.       

### PACELC Theorem 
    - The PACELC theorem states that in a system that replicates data:  
        - If there is a partition (‘P’), a distributed system can tradeoff between availability and consistency (i.e., ‘A’ and ‘C’);    
        - **ELSE (‘E’)**, when the system is running normally in the absence of partitions, the system can tradeoff between latency (‘L’) and consistency (‘C’).    
    - The whole thesis is assuming we maintain high availability by replication.    
    - Dynamo and Cassandra are **PA/EL**    
    - BigTable and HBase are **PC/EC**      
    - MongoDB can be considered **PA/EC**:  In the case of a network partition, MongoDB chooses availability(as replication is done asynchronously from primary to secondary), but otherwise guarantees consistency.    

### Consistent Hashing      
    - It maps data to physical nodes and ensures that only a small set of keys move when servers are added or removed.      
    - Consistent Hashing stores the data managed by a distributed system in a ring. Each node in the ring is assigned a range of data.  
    - When a node is removed, the next node becomes responsible for all of the keys stored on the outgoing node. However, this scheme can result in non-uniform data and load distribution. This problem can be solved with the help of Virtual nodes.      
    
### Communication Protocols  
- **Ajax Polling:**  
    - The basic idea is that the client repeatedly polls (or requests) a server for data. The client makes a request and waits for the server to respond with data. If no data is available, an empty response is returned.  
    - The problem with Polling is that the client has to keep asking the server for any new data. As a result, a lot of responses are empty, creating HTTP overhead.         
- **HTTP Long-Polling:**        
    - the client requests information from the server exactly as in normal polling, but with the expectation that the server may not respond immediately. That’s why this technique is sometimes referred to as a “Hanging GET”.        
    - If the server does not have any data available for the client, instead of sending an empty response, the server holds the request and waits until some data becomes available a timeout has occurred.     
    - Each Long-Poll request has a timeout. The client has to reconnect periodically after the connection is closed due to timeouts.        
- **WebSockets:**
    - WebSocket provides Full duplex(bi-directional) communication channels over a single TCP connection.   
    - It provides a persistent connection between a client and a server that both parties can use to start sending data at any time.     
    - The client establishes a WebSocket connection through a process known as the WebSocket handshake. If the process succeeds, then the server and client can exchange data in real-time with lower overheads.     
    - This is made possible by providing a standardized way for the server to send content to the browser without being asked by the client and allowing for messages to be passed back and forth while keeping the connection open.         
- **Server-Sent Events(SSEs):**     
    - The client establishes a persistent and long-term connection with the server. The server uses this connection to send data to a client.    
    - If the client wants to send data to the server, it would require the use of another technology/protocol to do so.     
        
### Bloom Filters      
    -  Bloom filter data structure tells whether an element may be in a set, or definitely is not. The only possible errors are false positives.    
        
### Quorum     
    - Once a system decides to maintain multiple copies of data, another problem arises: how to make sure that all replicas are consistent, i.e., if they all have the latest copy of the data and that all clients see the same view of the data?  
    - **A Quorum** is the minimum number of servers on which a distributed operation needs to be performed successfully before declaring the operation’s overall success.   
    - Quorum enforces the consistency requirement needed for distributed operations.    
    - Quorum is achieved when nodes follow the below protocol: R + W > N, where:    
        - N = nodes in the quorum group     
        - W = minimum write nodes   
        - R = minimum read nodes                
    
### Dos:
    • Always ask for clarification. Do not assume your assumption is correct.
    • Understand the requirements of the problem.
    • Given the time constraints, we should clarify what parts of the system we will be focusing on.
    • There is neither the right answer nor the best answer. A solution designed to solve the problems of a young startup is different from that of an established company with millions of users. Make sure you understand the requirements.
    • Let the interviewer know what you are thinking. Communicate with your interview.
    • Suggest multiple approaches if possible.
    • Once you agree with your interviewer on the blueprint, go into details on each component. Design the most critical components first.
    • Bounce ideas off the interviewer. A good interviewer works with you as a teammate.
    • Never give up.

### Dont's:
    • Don't be unprepared for typical interview questions.
    • Don’t jump into a solution without clarifying the requirements and assumptions.
    • Don’t go into too much detail on a single component in the beginning. Give the highlevel design first then drills down.
    • If you get stuck, don't hesitate to ask for hints.
    • Again, communicate. Don't think in silence.
    • Don’t think your interview is done once you give the design. You are not done until your interviewer says you are done. Ask for feedback early and often.
