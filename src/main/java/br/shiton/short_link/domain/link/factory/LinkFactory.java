package br.shiton.short_link.domain.link.factory;

import br.shiton.short_link.domain.link.entity.Link;

import java.util.UUID;

public class LinkFactory {
    public static Link create(String url, String shortUrl) {
        return new Link(
            UUID.randomUUID(),
            url,
            shortUrl
        );
    }
}
