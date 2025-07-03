package br.shiton.short_link.infrastructure.link.repository.mongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LinkRepository extends MongoRepository<LinkEntity, UUID> {
}

