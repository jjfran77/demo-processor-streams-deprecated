package es.atsistemas.poc.demo.mapper

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import es.atsistemas.poc.demo.model.Contact
import org.springframework.stereotype.Component

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@Component
class ContactMapper {

    val mapper = jacksonObjectMapper()

    fun toJson(contact: Contact) : String {
        return mapper.writeValueAsString(contact)
    }

    fun toContact(contact: String): Contact {
        return mapper.readValue<Contact>(contact, Contact::class.java)
    }

}