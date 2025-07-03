package br.shiton.short_link.infrastructure.link.repository.mongoDB;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "links")
public class LinkEntity {
    @Id
    private UUID id;
    @NotBlank
    @URL
    private String url;
    @NotBlank
    private String shortUrl;
    @NotBlank
    private LocalDateTime createdAt;

    public LinkEntity(UUID id, String url, String shortUrl, LocalDateTime createdAt) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
    }

}
