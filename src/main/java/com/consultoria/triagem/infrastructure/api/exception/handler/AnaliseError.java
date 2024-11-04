package com.consultoria.triagem.infrastructure.api.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AnaliseError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
