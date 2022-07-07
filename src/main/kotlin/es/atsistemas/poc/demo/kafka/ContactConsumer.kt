package es.atsistemas.poc.demo.kafka

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import es.atsistemas.poc.demo.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@EnableBinding(ContactConsumerBinding::class)
@Service
class ContactConsumer() {

    @Autowired
    lateinit var kafkaService: kafkaService

    @StreamListener(target = ContactConsumerBinding.BINDING_TARGET_NAME)
    fun process(
        @Payload message: Map<String, Any?>,
        @Header(value = KafkaHeaders.OFFSET, required = false) offset: Int?,
        @Header(value = "kafka_receivedMessageKey", required = false) key: String?
    ) {

        logger().debug("consumed message <{}>",message)

        val mapper = jacksonObjectMapper()
        val contactJSON = mapper.writeValueAsString(message)

        if (key == null){
            logger().info("no key for contact consumer")
        }else {
            kafkaService.process(key, contactJSON)
        }

    }
}
