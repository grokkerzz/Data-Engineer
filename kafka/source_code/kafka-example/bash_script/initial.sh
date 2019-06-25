#!/bin/bash

# run zookeeper & kafka server
# exec ${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties
# exec ${KAFKA_HOME}/bin/kakfa-server-start.sh ${KAKFA_HOME}/config/server.properties

# create the topics manually using the kafka cli
# exec ${KAFKA_HOME}/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic old
exec ${KAFKA_HOME}/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic even
