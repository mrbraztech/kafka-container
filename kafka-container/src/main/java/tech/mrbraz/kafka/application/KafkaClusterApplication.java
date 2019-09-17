package tech.mrbraz.kafka.application;

import java.io.File;
import java.io.IOException;
import io.debezium.kafka.KafkaCluster;
import io.debezium.util.Testing;

public class KafkaClusterApplication {
  public static void main(String[] args) throws IOException {
    File dataDir = Testing.Files.createTestingDirectory("kafka-cluster");
    
    if(valueOf("DELETE_ON_EXIT", Boolean.TRUE)) {
      dataDir.deleteOnExit();
    }
    
    Integer numberOfNodes = valueOf("NODES", 1);
    
    Integer zookeeperPort = valueOf("ZOOKEEPER_PORT", 2181);
    
    Integer kafkaPort = valueOf("KAFKA_PORT", 9092);
    
    KafkaCluster kafkaCluster = new KafkaCluster().usingDirectory(dataDir).withPorts(zookeeperPort, kafkaPort)
        .addBrokers(numberOfNodes).deleteDataPriorToStartup(true);
    kafkaCluster.startup();
  }
  
  private static Boolean valueOf(String variable, Boolean defaultValue) {
    String value = System.getenv(variable);
    if(value == null) {
      return defaultValue;
    }
    
    return Boolean.valueOf(value);
  }
  
  private static Integer valueOf(String variable, Integer defaultValue) {
    String value = System.getenv(variable);
    if(value == null) {
      return defaultValue;
    }
    
    return Integer.valueOf(value);
  }
}
