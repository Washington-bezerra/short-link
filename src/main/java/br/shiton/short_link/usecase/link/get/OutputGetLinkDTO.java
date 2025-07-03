package br.shiton.short_link.usecase.link.get;

import java.time.LocalDateTime;
import java.util.UUID;

public record OutputGetLinkDTO(
        UUID id,
        String url,
        String shortUrl,
        LocalDateTime createdAt
){}
