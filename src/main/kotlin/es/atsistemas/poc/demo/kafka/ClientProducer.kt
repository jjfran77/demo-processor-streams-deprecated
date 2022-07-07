package es.atsistemas.poc.demo.kafka

import es.atsistemas.poc.demo.mapper.ClientMapper
import es.atsistemas.poc.demo.model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@EnableBinding(ClientProducerBinding::class)
@Service
class ClientProducer (val producerBinding: ClientProducerBinding)  {

    @Autowired
    lateinit var clientMapper: ClientMapper

    fun produce(key: String, client: Client) {

        var clientJson = clientMapper.toJson(client)

        val msg = MessageBuilder
            .withPayload(clientJson.toByteArray())
            .setHeader(KafkaHeaders.MESSAGE_KEY,key.toByteArray())
            .build()
        producerBinding.messageChannel().send(msg)
    }

}