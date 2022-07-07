package es.atsistemas.poc.demo.kafka

import es.atsistemas.poc.demo.mapper.ContactMapper
import es.atsistemas.poc.demo.model.Contact
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@EnableBinding(ContactProducerBinding::class)
@Service
class ContactProducer (val producerBinding: ContactProducerBinding, val contactMapper: ContactMapper)  {

    fun produce(contact: Contact) {

        var contactJson = contactMapper.toJson(contact)

        val msg = MessageBuilder
            .withPayload(contactJson.toByteArray())
            .setHeader(KafkaHeaders.MESSAGE_KEY, contact.nif.toByteArray())
            .build()
        producerBinding.messageChannel().send(msg)
    }

}