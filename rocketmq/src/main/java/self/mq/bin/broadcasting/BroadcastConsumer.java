package self.mq.bin.broadcasting;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

import static self.mq.bin.common.ProjectCommon.BROADCAST_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class BroadcastConsumer {

	public static void main(String[] args) throws Exception {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(BROADCAST_GROUP_NAME);

		consumer.setNamesrvAddr("localhost:9876");

		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		//set to broadcast mode
		consumer.setMessageModel(MessageModel.BROADCASTING);

		consumer.subscribe("TopicTest", "TagA || TagC || TagD");

		consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
			System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");

			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		});

		consumer.start();

		System.out.printf("Broadcast Consumer Started.%n");
	}
}
