package com.murilonerdx.challengebackendhit.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDataError {
    private String field;
    private String defaultMessage;
    private LocalDateTime timestamp;
}
