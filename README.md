This repository contains the test code for Spark Streaming via the Direct API with checkpointing

Following are the steps to build and run this project
NOTE: Using SBT for this project. 

##Clone the repo
1. git clone git@github.com:marilynwaldman/SparkStreamingDIrectWithCheckpoint.git


##Compile
This command cleans output and compiles the application 

##Note 
- the lasted version of sbt was used.  This meant getting rid of the imported plugins.  

sbt assembly
jar tf target/scala-2.10/my-project-assembly.jar

##Note
- this is the spark-submit for local development

- the checkpoint directory is the last parameter.  test is the Kafka topic

To run locally:

1.  Download Kafka

2. start new shell windows for each of the tasks below and execute


	bin/zookeeper-server-start.sh config/zookeeper.properties
	bin/kafka-server-start.sh config/server.properties
	bin/kafka-console-producer.sh --broker-list localhost:9092
	bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
	bin/kafka-topics.sh --list --zookeeper localhost:2181
	bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test 
	bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
	
3.  git clone 
    open a terminal window and cd  
    issue the following from the command line	

	/Users/marilynwaldman/spark-1.3.0-bin-hadoop2.4/bin/spark-submit \
	 --class "DirectKafkaWordCount" \
	 --master local[4] \
	 target/scala-2.10/streaming-with-recovery.jar localhost:9092 myTopic ./checkpoint





