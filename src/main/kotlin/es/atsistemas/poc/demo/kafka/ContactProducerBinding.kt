package es.atsistemas.poc.demo.kafka

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
interface ContactProducerBinding {

    companion object {
        const val BINDING_TARGET_NAME = "contact-out"
    }

    @Output(BINDING_TARGET_NAME)
    fun messageChannel(): MessageChannel
}
