package edu.studentmanagement.exception;

import java.time.Instant;

public record ErrorResponse(
        String code,
        String message,
        int status,
        Instant timestamp,
        String path
) {

    public static ErrorResponse error(
            String code,
            String message,
            int status,
            String path
    ) {
        return new ErrorResponse(
                code,
                message,
                status,
                Instant.now(),
                path
        );
    }
}