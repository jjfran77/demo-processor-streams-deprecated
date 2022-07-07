package es.atsistemas.poc.demo.kafka

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.MessageChannel

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
interface ContactConsumerBinding {

    companion object {
        const val BINDING_TARGET_NAME = "contact-in"
    }

    @Input(BINDING_TARGET_NAME)
    fun messageChannel(): MessageChannel
}
