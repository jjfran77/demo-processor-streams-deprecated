package es.atsistemas.poc.demo.repository

import es.atsistemas.poc.demo.model.Client
import org.springframework.data.couchbase.repository.CouchbaseRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : CouchbaseRepository<Client?, String?> {
    fun findByEmailLike(email: String?): List<Client?>?
}