Referred video
Java techie jms queue 27min video


# Steps to run rabbitmq

Download RabbitMQ

open rabbitmq

go to this path in terminal

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.11.10\sbin

run the below command 

rabbitmq-plugins enable rabbitmq_management

Then run the 

rabbitmq-service.bat start


To stop the service 

rabbitmq-service.bat stop

RabbitMQ dashboard

http://localhost:15672/

username and password: guest

# RabbitMQ
RabbitMQ:

RabbitMQ is an open-source general-purpose message-broker software – an intermediary for messaging, 
that initially implemented the Advanced Message Queuing Protocol

RabbitMQ can deal with some high-throughput use cases, such as online transactions or payment processing. 
It is generally used to handle background and cron jobs or as a message broker between microservices.

Apache Kafka is designed for publish-subscribe and streaming scenarios, 
while RabbitMQ is designed for message queuing and routing.

can send 4k-10k messages per second
acknowledgement based
smark publisher/dumb consumer

# Real time use case
RabbitMQ is often used for reliable message queuing and routing scenarios, such as:

Order processing: A company may use RabbitMQ to handle customer orders and route them to the appropriate 
department for processing.

Email delivery: Email providers can use RabbitMQ to queue outgoing emails and ensure that they are delivered reliably.

Chat applications: RabbitMQ can be used to handle real-time chat messages in applications, 
ensuring that messages are delivered in the correct order and without loss.
