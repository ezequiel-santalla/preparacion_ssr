package com.ezequiel.preparacion_ssr.s1_streams_tenis.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resource, Object id) {
        super("%s no encontrado: %s".formatted(resource, id));
    }
}
