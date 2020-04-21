package self.mq.bin.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import static self.mq.bin.common.ProjectCommon.ORDER_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class OrderedProducer {

	public static void main(String[] args) throws Exception {
		//Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer(ORDER_GROUP_NAME);

		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");

		//Launch the instance.
		producer.start();

		String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};

		for (int i = 0; i < 1; i++) {
			int orderId = i % 10;

			//Create a message instance, specifying topic, tag and message body.
			Message msg = new Message(
					"TopicTest",
					tags[i % tags.length],
					"KEY" + i,
					("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
			);

			SendResult sendResult = producer.send(msg, (mqs, msg1, arg) -> {
				Integer id = (Integer) arg;
				int index = id % mqs.size();
				return mqs.get(index);
			}, orderId);

			System.out.printf("%s%n", sendResult);
		}

		//server shutdown
		producer.shutdown();
	}
}
