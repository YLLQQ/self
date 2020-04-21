package self.mq.bin.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;

import static self.mq.bin.common.ProjectCommon.SIMPLE_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class ConsumeMessage {

	public static void main(String[] args) {
		consumeMessages();
	}

	public static void consumeMessages() {
		// Instantiate with specified consumer group name.
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(SIMPLE_GROUP_NAME);

		// Specify name server addresses.
		consumer.setNamesrvAddr("localhost:9876");

		// Subscribe one more more topics to consume.
		try {
			consumer.subscribe("TopicTest", "*");
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		// Register callback to execute on arrival of messages fetched from brokers.
		consumer.registerMessageListener((MessageListenerConcurrently) (msg, context) -> {
			System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msg);

			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		});

		//Launch the consumer instance.
		try {
			consumer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		System.out.printf("Consumer Started.%n");
	}
}
