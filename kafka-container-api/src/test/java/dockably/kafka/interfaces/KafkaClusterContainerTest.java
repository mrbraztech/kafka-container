package dockably.kafka.interfaces;

import org.junit.Test;

public class KafkaClusterContainerTest {
  @Test
  public void givenContainerWhenStartThenStop() {
    KafkaClusterContainer container = new KafkaClusterContainer();
    System.out.println("Starting container...");
    container.start();
    System.out.println("Stopping container...");
    container.stop();
  }
}
