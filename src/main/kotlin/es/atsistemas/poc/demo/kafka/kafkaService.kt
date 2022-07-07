package es.atsistemas.poc.demo.kafka

import es.atsistemas.poc.demo.logger
import es.atsistemas.poc.demo.mapper.ClientMapper
import es.atsistemas.poc.demo.mapper.ContactMapper
import es.atsistemas.poc.demo.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@Service
class kafkaService {

    @Autowired
    lateinit var producer: ClientProducer

    @Autowired
    lateinit var contactMapper: ContactMapper

    @Autowired
    lateinit var clientMapper: ClientMapper

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun process(key: String, contactJson: String) {

        var contact = contactMapper.toContact(contactJson)

        var client = clientMapper.mapContactToClient(contact)
        client.id = "client::" + client.nif
        client.bankAccount = "es12439043940"
        client.modality = "premium"

        clientRepository.save(client)

        if (key == null){
            logger().info("no key")
        }else {
            producer.produce(key, client)
        }
    }




}