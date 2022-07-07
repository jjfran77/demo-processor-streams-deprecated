package es.atsistemas.poc.demo.mapper

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import es.atsistemas.poc.demo.model.Client
import es.atsistemas.poc.demo.model.Contact
import org.mapstruct.Mapper
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy
import org.springframework.stereotype.Component

/**
 * @author Juan Francisco Guerrero (jfguerrrero@atsistemas.com)
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class ClientMapper {

   val mapper = jacksonObjectMapper()

   @Mappings
   abstract fun mapContactToClient(b: Contact): Client

   fun toJson(client:Client) : String {
      return mapper.writeValueAsString(client)
   }


}