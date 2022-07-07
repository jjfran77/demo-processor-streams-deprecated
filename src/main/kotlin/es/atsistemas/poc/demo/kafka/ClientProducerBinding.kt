package es.atsistemas.poc.demo.kafka

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
interface ClientProducerBinding {

    companion object {
        const val BINDING_TARGET_NAME = "client-out"
    }

    @Output(BINDING_TARGET_NAME)
    fun messageChannel(): MessageChannel
}
