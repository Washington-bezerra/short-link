package br.shiton.short_link.infrastructure.api.controller;

import lombok.Getter;

@Getter
public class ResponseError {
    private final String message;

    public ResponseError(String message) {
        this.message = message;
    }
}
