package self.mq.bin.broadcasting;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author yangguoqing
 */
public class BroadcastProducer {

	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException,
			RemotingException, MQClientException, MQBrokerException {
		DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

		producer.setNamesrvAddr("localhost:9876");

		producer.start();

		for (int i = 0; i < 10; i++) {
			Message msg = new Message("TopicTest",
					"TagA",
					"OrderID188",
					"Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET)
			);

			SendResult sendResult = producer.send(msg);

			System.out.printf("%s%n", sendResult);
		}

		producer.shutdown();
	}
}
