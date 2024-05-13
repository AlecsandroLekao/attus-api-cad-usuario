package com.attus.attusservice.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrosExcecao {
    private LocalDateTime timestamp;
    private  int status;
    private String exception;

    public ErrosExcecao() {
    }

    public ErrosExcecao(LocalDateTime timestamp, int status, String exception) {
        this.timestamp = timestamp;
        this.status = status;
        this.exception = exception;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
