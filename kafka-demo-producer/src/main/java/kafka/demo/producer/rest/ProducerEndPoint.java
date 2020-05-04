/**
 * 
 */
package kafka.demo.producer.rest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kafka.demo.common.message.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping("/producer")
@Slf4j
public class ProducerEndPoint {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	
	@PostConstruct
	public void activate() {
		log.debug("Producer Activated");
	}
	
	
	@PostMapping("/post")
	public ResponseEntity<String> postMessage(@RequestBody Message message){
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		
		kafkaTemplate.send(new GenericMessage<Message>(message, headers));
		
		//Uncomment below to send plain text (string value) through kafka
		//kafkaTemplate.send(topicName, "Some String value");
		
		log.debug("Message snet to kafka: {}", message.toString());
		
		return ResponseEntity.ok("Message snet to kafka");
	}
}
