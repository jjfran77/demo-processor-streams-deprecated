package es.atsistemas.poc.demo.web

import es.atsistemas.poc.demo.model.Contact
import es.atsistemas.poc.demo.kafka.ContactProducer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@RestController
class MessageController() {

    @Autowired
    lateinit var contactProducer: ContactProducer

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping(path = ["/contact"], consumes = ["application/json"])
    fun send(@RequestBody contact: Contact) {
        logger.info("send() {}", contact)
        contactProducer.produce(contact)
    }

}
