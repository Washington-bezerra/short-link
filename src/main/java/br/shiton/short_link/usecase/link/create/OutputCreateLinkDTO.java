package br.shiton.short_link.usecase.link.create;

import java.time.LocalDateTime;
import java.util.UUID;

public record OutputCreateLinkDTO(UUID id, String url, String shortUrl, LocalDateTime createdAt) {

}
