package tech.mrbraz.kafka.interfaces;

import org.testcontainers.containers.GenericContainer;

public class KafkaClusterContainer extends GenericContainer<KafkaClusterContainer> {
  private static final String NAMESPACE = "dockably/kafka-container:%s";
  public static final int KAFKA_PORT = 9093;
  public static final int ZOOKEEPER_PORT = 2181;

  public KafkaClusterContainer() {
    this("2.2.1");
  }
  
  public KafkaClusterContainer(String version) {
    super(String.format(NAMESPACE, version));
  }
  
  public KafkaClusterContainer withNodes(Integer nodes) {
    this.addEnv("NODES", nodes.toString());
    return this;
  }
  
  public KafkaClusterContainer withKafkaPort(Integer port) {
    this.addEnv("KAFKA_PORT", port.toString());
    return this;
  }
  
  public KafkaClusterContainer withZookeeperPort(Integer port) {
    this.addEnv("ZOOKEEPER_PORT", port.toString());
    return this;
  }
  
  public KafkaClusterContainer deleteOnExit(Boolean delete) {
    this.addEnv("DELETE_ON_EXIT", delete.toString());
    return this;
  }
}
