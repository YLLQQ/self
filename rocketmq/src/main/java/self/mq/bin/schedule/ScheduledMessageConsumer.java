package self.mq.bin.schedule;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import static self.mq.bin.common.ProjectCommon.SCHEDULE_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class ScheduledMessageConsumer {

	public static void main(String[] args) throws Exception {
		// Instantiate message consumer
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(SCHEDULE_GROUP_NAME);

		consumer.setNamesrvAddr("localhost:9876");

		// Subscribe topics
		consumer.subscribe("TestTopic", "*");

		// Register message listener
		consumer.registerMessageListener((MessageListenerConcurrently) (messages, context) -> {
			for (MessageExt message : messages) {
				// Print approximate delay time period
				System.out.println(
						"Receive message[msgId=" + message.getMsgId() + "] " + (System.currentTimeMillis() - message.getStoreTimestamp()) + "ms later"
				);
			}

			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		});

		// Launch consumer
		consumer.start();
	}
}
