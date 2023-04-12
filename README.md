# Apache Kafka:

# Steps to run kafka in local:
STEP 1: DOWNLOAD AND INSTALL KAFKA
https://dlcdn.apache.org/kafka/3.2.0/...

STEP 2: START THE KAFKA ENVIRONMENT
this step is mandatory even if you want to run kafka  producer consumer in rest API in local.

Start the ZooKeeper service
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start the Kafka broker service
.\bin\windows\kafka-server-start.bat .\config\server.properties

STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
.\bin\windows\kafka-topics.bat --create --topic topic_demo --bootstrap-server localhost:9092

STEP 4: WRITE SOME EVENTS INTO THE TOPIC
.\bin\windows\kafka-console-producer.bat --topic topic_demo --bootstrap-server localhost:9092
enter the messages

STEP 5:  READ THE EVENTS
.\bin\windows\kafka-console-consumer.bat --topic topic_demo --from-beginning --bootstrap-server localhost:9092
hello world
topic demo

# Definition
Apache Kafka is an open-source distributed event streaming platform used for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications. 

Apache Kafka is designed for publish-subscribe and streaming scenarios, 
while RabbitMQ is designed for message queuing and routing.

# Advantages
High Throughput

Capable of handling high-velocity and high-volume data, Kafka can handle millions of messages per second.

High Scalability

Scale Kafka clusters up to a thousand brokers, trillions of messages per day, petabytes of data, hundreds of thousands of partitions. Elastically expand and contract storage and processing.

Low Latency

Can deliver these high volume of messages using a cluster of machines with latencies as low as 2ms

Permanent Storage

Safely, securely store streams of data in a distributed, durable, reliable, fault-tolerant cluster

High Availability

Extend clusters efficiently over availability zones or connect clusters across geographic regions, making Kafka highly available and fault tolerant with no risk of data loss.




# Real time use case:
Apache Kafka is commonly used for real-time data streaming scenarios, such as:

Social media sentiment analysis: A company may use Apache Kafka to stream social media data in real-time 
to analyze customer sentiment towards their products.

IoT data processing: Devices connected to the Internet of Things (IoT) can generate a massive amount of data, 
which can be ingested and processed in real-time using Apache Kafka.
