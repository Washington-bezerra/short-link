package br.shiton.short_link.domain.link.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Link {
    @NotBlank(message = "id is required")
    private final UUID id;
    @NotBlank(message = "url is required")
    @URL
    private final String url;
    @NotBlank(message = "shortUrl is required")
    private final String shortUrl;
    @NotBlank(message = "createdAt is required")
    private final LocalDateTime createdAt;

    public Link(UUID id, String url, String shortUrl) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
        this.createdAt = LocalDateTime.now();
    }

}
