package self.mq.bin.simple;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.stream.IntStream;

import static self.mq.bin.common.ProjectCommon.SIMPLE_GROUP_NAME;

/**
 * @author yangguoqing
 */
public class SendMessage {

	public static void main(String[] args) {

		sendMessagesSynchronously();
//		sendMessagesAsynchronously();
//		sendMessagesInOneWayMode();

	}


	/**
	 * One-way transmission is used for cases requiring moderate reliability, such as log collection.
	 */
	public static void sendMessagesInOneWayMode() {

		//Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer(SIMPLE_GROUP_NAME);

		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");

		//Launch the instance.
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		try {
			for (int i = 0; i < 100; i++) {
				//Create a message instance, specifying topic, tag and message body.
				Message msg = new Message(
						"TopicTest" /* Topic */,
						"TagA" /* Tag */,
						("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
				);

				//Call send message to deliver message to one of brokers.
				producer.sendOneway(msg);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Shut down once the producer instance is not longer in use.
		producer.shutdown();

	}

	/**
	 * Asynchronous transmission is generally used in response time sensitive business scenarios.
	 */
	public static void sendMessagesAsynchronously() {
		//Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer(SIMPLE_GROUP_NAME);

		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");

		//Launch the instance.
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		producer.setRetryTimesWhenSendAsyncFailed(0);

		IntStream.range(0, 100).forEach(
				i -> {
					//Create a message instance, specifying topic, tag and message body.
					Message msg = null;

					try {
						msg = new Message("TopicTest",
								"TagA",
								"OrderID188",
								"Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					try {
						producer.send(msg, new SendCallback() {
							@Override
							public void onSuccess(SendResult sendResult) {
								System.out.printf("%-10d OK %s %n", i, sendResult.getMsgId());
							}

							@Override
							public void onException(Throwable e) {
								System.out.printf("%-10d Exception %s %n", i, e);
								e.printStackTrace();
							}
						});
					} catch (MQClientException | RemotingException | InterruptedException e) {
						e.printStackTrace();
					}
				});

		//Shut down once the producer instance is not longer in use.
//		producer.shutdown();
	}

	/**
	 * Reliable synchronous transmission is used in extensive scenes, such as important notification messages, SMS
	 * notification, SMS marketing system, etc..
	 */
	public static void sendMessagesSynchronously() {
		//Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer(SIMPLE_GROUP_NAME);

		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");

		//Launch the instance.
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		IntStream.range(0, 100).forEach(
				i -> {
					try {
						//Create a message instance, specifying topic, tag and message body.
						Message msg = new Message(
								"TopicTest" /* Topic */,
								"TagA" /* Tag */,
								("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
						);
						//Call send message to deliver message to one of brokers.
						SendResult sendResult = producer.send(msg);

						System.out.printf("%s%n", sendResult);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		);

		//Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}
}
