package self.mq.bin.schedule;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import static self.mq.bin.common.ProjectCommon.SCHEDULE_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class ScheduledMessageProducer {

	public static void main(String[] args) throws Exception {
		// Instantiate a producer to send scheduled messages
		DefaultMQProducer producer = new DefaultMQProducer(SCHEDULE_GROUP_NAME);

		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");

		// Launch producer
		producer.start();

		int totalMessagesToSend = 10;

		for (int i = 0; i < totalMessagesToSend; i++) {
			Message message = new Message(
					"TestTopic",
					("Hello scheduled message " + i).getBytes()
			);

			// This message will be delivered to consumer 10 seconds later.
			message.setDelayTimeLevel(3);

			// Send the message
			producer.send(message);
		}

		// Shutdown producer after use.
		producer.shutdown();
	}
}
