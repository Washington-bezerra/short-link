package br.shiton.short_link.usecase.link.get;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record InputGetLinkDTO(
    @NotBlank(message = "id is required")
    UUID id
) {
    public InputGetLinkDTO(UUID id) {
        this.id = id;
    }
}
