
### Links
- [Hbase vs Cassandra vs MongoDB](https://logz.io/blog/nosql-database-comparison/)                  
- [NoSql Common Misconceptions](https://www.mongodb.com/nosql-explained)               
- [Sql vs NoSql](https://www.mongodb.com/nosql-explained/nosql-vs-sql)           
- [DynamoDB concepts](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html)      
- [What is Timeseries Data?](https://www.influxdata.com/what-is-time-series-data/)              

### Types of NoSQL databases
    
  - **Document databases**
      - A document database stores data in JSON, BSON , or XML documents (not Word documents or Google docs, of course). In a document database, documents can be nested. Particular elements can be indexed for faster querying.
      - Documents can be stored and retrieved in a form that is much closer to the data objects used in applications, which means less translation is required to use the data in an application. SQL data must often be assembled and disassembled when moving back and forth between applications and storage.
      - Use cases include ecommerce platforms, trading platforms, and mobile app development across industries.
      - eg. MongoDB, CouchBase              
      
  - **Key-value stores**
      - Every data element in the database is stored as a key value pair consisting of an attribute name (or "key") and a value. In a sense, a key-value store is like a relational database with only two columns: the key or attribute name (such as state) and the value (such as Alaska).
      - Use cases include shopping carts, user preferences, and user profiles(Caching, Message Queuing, Session Management).
      - eg. MemcacheDB, Redis, DynamoDB, Riak, Voldemort             
       
  - **Column-oriented databases**
      - While a relational database stores data in rows and reads data row by row, a column store is organized as a set of columns. This means that when you want to run analytics on a small number of columns, you can read those columns directly without consuming memory with the unwanted data. 
      - Columns are often of the same type and benefit from more efficient compression, making reads even faster. Columnar databases can quickly aggregate the value of a given column (adding up the total sales for the year, for example). 
      - Use cases include analytics.            
      - eg. Cassandra, HBase, Google BigTable                
      
  - **Graph databases**
      - A graph database focuses on the relationship between data elements. Each element is stored as a node (such as a person in a social media graph). 
      - The connections between elements are called links or relationships. In a graph database, connections are first-class elements of the database, stored directly.
      - A graph database is optimized to capture and search the connections between data elements, overcoming the overhead associated with JOINing multiple tables in SQL.
      - Use cases include fraud detection, social networks, and knowledge graphs.           
      - eg. Neo4j, OrientDB, Amazon Neptune                 
      
### Cassandra
  - **Advantages**          
      - Uses a masterless “ring” architecture, means that all nodes in a cluster are treated equally, and a majority of nodes can be used to achieve quorum.                        
      - It allows rows to have different columns, and even allows a change in the format of the columns(Columnar or Wide column).                       
      - It can provide a highly available architecture if a quorum of nodes is maintained and the replication factor is tuned accordingly.          
      - Most common use cases include **messaging systems** (for its superior read and write performance), real-time sensor data, and e-commerce websites.              
                                
  - **Disadvantages**           
      - As the architecture is distributed, replicas can become inconsistent.           
      - **Hinted Handoff:** If a node in a cluster goes down, its coordinator node tries to preserve the data in the form of hints. When the failed node is brought online, the coordinator node hands off the hints to aid in the repair.          
        This, however, can prove to be a burden for the coordinator node and overload it. As a result, you will see a loss of data replicas and refusal of writes from the coordinator node.            
      - While scanning data, Cassandra handles itself well if the primary key is known, but suffers severely if it is not. This is because it has to scan all its nodes in the cluster, resulting in high read time penalties.          
     
  - **Cassandra Keys**
      - More fields can be added in type-ID pairs, Examples of valid keys are:
      
            /<Database>/<Table>/<Id>/<Type1>/<SubId1>                  
            /<Database>/<Table>/<Id>/<Type1>/<SubId1>/<Type2>/<SubId2>                    
      
      - Value corresponding to a key can contains some data(can be encoded like using Avro serialization) and a schema id. The schema id represents the schema used to encode the data, it is mandatory - it cannot be null.        
      - CQL is an abstraction layer in Cassandra which presents data arranged tables, with support for SQL-like queries.        
      - However, internally in Cassandra data is arranged into a set of Column Families (CF). Column Families have many similarities with tables in an SQL database.            
      - For example, a CF have a Row Key (similar to primary index) as well as a set of named columns. The number of columns and their names are dynamic, and different rows can have different columns.            
      - Column families are then stored in a Key Space (similar to a DB schema). Key Spaces are important to Cassandra when distributing data internally in the Cassandra cluster.          
      - Data Segment distribution in CIL is not necessarily aligned with how Key Spaces are distributed in Cassandra. These concepts are similar, but not related to one another. Visit the official Cassandra site for more details.                              
      - Before CIL store an entity into Cassandra, the Entity Key is broken down into a few specific parts. Consider the following Entity Key:                  
                          
              /cpm/customers/56                   
              /cpm/customers/56/agreements/23                 
              /cpm/customers/56/agreements/23/products/12                 
              /cpm/customers/56/agreements/23/products/17                 
              /cpm/customers/56/agreements/24                 
              /cpm/customers/56/agreements/24/products/19
              /cpm/customers/78                   
              /cpm/customers/78/agreements/28                 
              /cpm/customers/78/agreements/28/products/15     
              /cha/customers/78     
              /cil/customers_location/78                  
                                     
      - These would be mapped into Cassandra as follows (the data is not shown here):                   

              *Note that different rows in Cassandra can have different column names, and a varying number of columns per row.
              *As the Entity Key is associated with another Database like cha and cil, it will end up in another Key Space:                 
                 
              Key Space: cpm                  
                Column Family: customers                  
                  56 -> /, agreements/23, agreements/23/products/12, agreements/23/products/17, agreements/24, agreements/24/products/19                  
                  78 -> /, agreements/28, agreements/28/products/15                   
                                  
              Key Space: cha                 
                Column Family: customers                  
                  78 -> /                 
                                  
              Key Space: cil                  
                Column Family: customers_location                 
                  78 -> /                  

      - Several things can be observed here. 
        - The Key Space in Cassandra has the same name as the first field in the Entity Key. 
        - Also the Column Family used has its name derived from the second field in the Entity Key. 
        - The third field in the Entity Key is used as the Row Key in Cassandra.                    
        - As all these Entity Keys have the same Entity Base Key, that means that all Entity Keys will be mapped to the same Row Key. 
        - Once the three first fields in the Entity Key have been mapped to Key Space, Column Family and Row Key, the remainder of the Entity Key is simply used as the name of the column in Cassandra. 
        - There is one special case though. The first Entity Key which have only three sections, will be mapped into a column named "/".                   
               
### Mongo DB            
  - **Advantages**          
      - A schema-less database and stores data as JSON-like documents (binary JSON).            
      - The embedded documents provide support for faster queries through indexes and vastly reduce the I/O overload generally associated with database systems.            
      - Common use cases include a real-time view of your data, mobile applications, IoT applications, and content management systems.                                  
      - High availability and horizontal scalability.                   
      - High availability is achieved through replica sets which boast features like data redundancy and automatic failover.                            
                                
  - **Disadvantages**           
      - Management operations like patching are manual and time-consuming processes.            
      - Suffers from memory hog issues as the databases start scaling.              
                
### HBase           
  - **Advantages**          
      - An open-source wide column store distributed database.          
      - Built on top of HDFS, it borrows several features from Bigtable, like in-memory operation, compression, and Bloom filters. Built on Java, HBase provides support for external APIs like Thrift, Avro, REST.         
      - Use of HDFS as the distributed file system allows HBase to store large data sets, even billions of rows,            
        and provide analysis in a short period. This support for sparse data, along with the fact that it can be            
        hosted/distributed across commodity server hardware, ensures that the solution is very cost-effective when          
        the data is scaled to gigabytes or petabytes.           
        That distribution contributes to one of its big pros: failover support includes automatic recovery.         
      - Batter than Cassandra when it comes to consistency, **as the reads and writes adhere to immediate consistency**, compared to the eventual consistency in Cassandra.                             
      - Common use cases include online log analytics, Hadoop distributions, write-heavy applications, and applications in need of large volume (like Tweets, Facebook posts, etc.).            
                                            
  - **Disadvantages**           
      - **Not Highly Available:** It has a master-slave architecture. This also proves to be a single point of failure, as failing from one HMaster to another can take time, which can also be a performance bottleneck.           
      - HBase does not have a query language.                   
      - It has some high hardware requirements, mainly because of its dependency on HDFS, which would require five DataNodes and one NameNode as a minimum. This, in turn, translates to high running and maintenance costs.            
      - It is dependent on other systems, like HDFS, for storage, and Apache ZooKeeper for status management and metadata.              
                
### DynamoDB       
  - **Concepts**            
      - A **table** is a collection of data. Each table contains zero or more items. 
      - An **item** is a group of attributes that is uniquely identifiable among all of the other items. Each item is composed of one or more attributes. 
      - An **attribute** is a fundamental data element, something that does not need to be broken down any further.
      - **Primary Key** DynamoDB supports two different kinds of primary keys:  
            - **Partition key**             
                – A simple primary key, composed of one attribute known as the partition key. DynamoDB uses the partition key's value as input to an internal hash function. The output from the hash function determines the partition (physical storage internal to DynamoDB) in which the item will be stored.                  
                - The partition key of an item is also known as its **hash attribute**. The term hash attribute derives from the use of an internal hash function in DynamoDB that evenly distributes data items across partitions, based on their partition key values.            
            - **Partition key and sort key**              
                - Referred to as a composite primary key, this type of key is composed of two attributes. The first attribute is the partition key, and the second attribute is the sort key.       
                - All items with the same partition key value are stored together, in sorted order by sort key value.
                - The sort key of an item is also known as its **range attribute**. The term range attribute derives from the way DynamoDB stores items with the same partition key physically close together, in sorted order by the sort key value.           
      - **Secondary Indexes**       
            - A secondary index lets you query the data in the table using an alternate key, in addition to queries against the primary key. You can create one or more secondary indexes on a table. 
            - DynamoDB supports two kinds of indexes:                  
                - **Global secondary index** – An index with a partition key and sort key that can be different from those on the table.        
                - **Local secondary index** – An index that has the same partition key as the table, but a different sort key.            
      - **DynamoDB Streams** is an optional feature that captures data modification events in DynamoDB tables. The data about these events appear in the stream in near-real time, and in the order that the events occurred. Each event is represented by a stream record. If you enable a stream on a table, DynamoDB Streams writes a stream record a new item is added/updated/deleted to the table.        
                  
  - **Advantages**          
      - A fully managed NoSQL database service that provides fast and predictable performance with seamless scalability.    
      - Also offers encryption at rest, which eliminates the operational burden and complexity involved in protecting sensitive data.   
      - You can create on-demand backups and enable point-in-time recovery for your Amazon DynamoDB tables. Point-in-time recovery helps protect your tables from accidental write or delete operations.        
      - DynamoDB allows you to delete expired items from tables automatically to help you reduce storage usage and the cost of storing data that is no longer relevant.         
      - Data is stored on solid-state disks (SSDs) and is automatically replicated across multiple Availability Zones in an AWS Region, providing built-in high availability and data durability.                 
      - We can use global tables to keep DynamoDB tables in sync across AWS Regions.   
                                            
  - **Disadvantages**           
      - Table Joins – Joins are impossible.         
      - No Triggers.            
      - No foreign keys concept to refer to other table items.          
      - No server side scripts.                     


### Neo4j           
  - Fully ACID compliant, scalable to billions of nodes, distributed options. Graph queries using Neo4j’s Cypher language can be orders of magnitude faster than a relational database modeling the same data. With its extensive framework support and REST API, it is simple to integrate with existing applications and architectures.             
  - Information is organized as nodes, relationships, and properties.       
  - **Nodes** are the entities in the graph. It can be tagged with labels, representing their different roles in your domain. (For example, Person). It can hold any number of key-value pairs, or **properties**, for example: name. Its labels may also attach **metadata** (such as index or constraint information) to certain nodes.
  - **Relationships** provide directed, named, connections between two node entities (e.g. Person LOVES Person). It always have a direction, a type, a start node, and an end node, and they can have properties, just like nodes. Nodes can have any number or type of relationships without sacrificing performance. Although relationships are always directed, they can be navigated efficiently in any direction.      
  - Common use case: Social Networks, Recommendation Engines, Geo Routing(routing inventory, scheduling tours and geospatial analysis)                 
                
### InfluxDB                
  - A time series database (TSDB) is optimized for time-stamped or time series data.  
  - Time series data, also referred to as time-stamped data, is a sequence of data points indexed in time order. Time-stamped is data collected at different points in time. Time series data are simply measurements or events that are tracked, monitored, downsampled, and aggregated over time.                 
  - Time series data can be classified into two types:      
    - Measurements gathered at regular time intervals (metrics)                 
    - Measurements gathered at irregular time intervals (events)            
  - This could be server metrics, application performance monitoring, network data, sensor data, events, clicks, trades in a market, and many other types of analytics data.                
                
### ELK Stack
  - **Elasticsearch**                 
      - Elasticsearch is a distributed, RESTful, JSON based search and analytics engine capable of addressing a growing number of use cases.    
      - It is based on the Apache Lucene search engine.            
      - As the heart of the Elastic Stack, it centrally stores your data for lightning fast search, fine‑tuned relevancy, and powerful analytics that scale with ease.      
      - **Basic Elasticsearch Concepts**    
        - Index                 
            - Elasticsearch Indices are logical partitions of documents and can be compared to a database.                          
            - You can have as many indices defined in Elasticsearch as you want but this can affect performance. These, in turn, will hold documents that are unique to each index.                 
        - Documents                 
            - Documents are JSON objects that are stored within an Elasticsearch index and are considered the base unit of storage. In the world of relational databases, documents can be compared to a row in a table.                    
        - Shards                    
            - Index size is a common cause of Elasticsearch crashes.Since there is no limit to how many documents you can store on each index, an index may take up an amount of disk space that exceeds the limits of the hosting server. As soon as an index approaches this limit, indexing will begin to fail.                  
            - One way to counter this problem is to split up indices horizontally into pieces called shards. This allows you to distribute operations across shards and nodes to improve performance.                       
        - Elasticsearch Queries                 
            - Boolean Operators                 
                - jack AND jill — Will return events that contain both jack and jill                    
                - ahab NOT moby — Will return events that contain ahab but not moby                 
                - tom OR jerry — Will return events that contain tom or jerry, or both                      
            - Fields                    
                - You might be looking for events where a specific field contains certain terms. You specify that as follows: name:”Ned Stark”                  
            - Ranges                    
                - age:[3 TO 10] — Will return events with age between 3 and 10                  
                - price:{100 TO 400} — Will return events with prices between 101 and 399                   
                - name:[Adam TO Ziggy] — Will return names between and including Adam and Ziggy                 
            - Wildcards, Regexes and Fuzzy Searching                                
                                                                                            
  - **Logstash**                                        
      - Logstash is a log aggregator that collects data from various input sources, executes different transformations and enhancements and then ships the data to various supported output destinations.                   
      - It processes the log messages, enhancing them and massaging them and then dispatching them to a defined destination for storage (stashing).                         
      - Logstash has a simple configuration DSL that enables you to specify the inputs, outputs, and filters described above, along with their specific options.                        
        - Input: input { file { path => "/var/log/apache/access.log" start_position => "beginning" } }                  
        - Filter: filter { grok { match => { "message" => "%{COMBINEDAPACHELOG}" } } date { match => [ "timestamp" , "dd/MMM/yyyy:HH:mm:ss Z" ] } geoip { source => "clientip" } }                  
        - Output: output { elasticsearch { hosts => ["localhost:9200"] } }                  
                                    
  - **Kibana**                                  
      - Kibana is a visualization layer that works on top of Elasticsearch, providing a user interface to analyze and visualize the data stored in Elasticsearch indices.                   
      - By default, users now use a new querying language called KQL (Kibana Querying Language) to search their data.                   
      - Here are some of the most common search types:                  
        - **Free text searches** – used for quickly searching for a specific string.                    
        - **Field-level searches** – used for searching for a string within a specific field.                   
        - **Logical statements** – used to combine searches into a logical statement.                   
        - **Proximity searches** – used for searching terms within a specific character proximity.                  
      - Kibana visualizations are built on top of Elasticsearch queries. Using Elasticsearch aggregations (e.g. sum, average, min, mac, etc.), you can perform various processing actions to make your visualizations depict trends in the data.
                          
  - **Beats**                                       
      - Beats are lightweight agents that are installed on edge hosts to collect different types of data for forwarding into the stack.                     
      - It is a family of log shippers for different use cases containing Filebeat, Metricbeat, Packetbeat, Auditbeat, Heartbeat and Winlogbeat.                        
                                                            