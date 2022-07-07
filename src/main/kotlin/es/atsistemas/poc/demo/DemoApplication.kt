package es.atsistemas.poc.demo

import es.atsistemas.poc.demo.kafka.ContactProducerBinding
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

inline fun <reified R : Any> R.logger(): Logger =
	LoggerFactory.getLogger(this::class.java.name.substringBefore("\$Companion"))
