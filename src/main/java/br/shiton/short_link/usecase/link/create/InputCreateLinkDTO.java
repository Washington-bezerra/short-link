package br.shiton.short_link.usecase.link.create;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record InputCreateLinkDTO(
    @NotBlank(message = "url is required")
    @URL
    String url
) {
    public InputCreateLinkDTO(String url) {
        this.url = url;
    }

}
