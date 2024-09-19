package com.wp.reservas.domain.models.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@Getter
public class HttpGenericException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public HttpGenericException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Map<String, Object> getErrorData() {
        return Map.of(
                "type", "error",
                "message", getMessage());
    }

}
