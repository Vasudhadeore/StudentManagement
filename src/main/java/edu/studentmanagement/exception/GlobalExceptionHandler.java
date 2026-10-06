package edu.studentmanagement.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(
            NotFoundException ex,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(
                        ErrorResponse.error(
                                "NOT_FOUND",
                                ex.getMessage(),
                                HttpStatus.NOT_FOUND.value(),
                                request.getRequestURI()
                        )
                );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleGenericException(
            RuntimeException ex,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(
                        ErrorResponse.error(
                                "INTERNAL_SERVER_ERROR",
                                ex.getMessage(),
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                request.getRequestURI()
                        )
                );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .body(
                        ErrorResponse.error(
                                "VALIDATION_ERROR",
                                message,
                                HttpStatus.BAD_REQUEST.value(),
                                request.getRequestURI()
                        )
                );
    }
}