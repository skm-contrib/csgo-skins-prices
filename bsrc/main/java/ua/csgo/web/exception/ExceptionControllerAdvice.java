package ua.csgo.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({UserAlreadyRegisteredException.class})
    public ResponseEntity<String> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(e.getMessage());
    }
}
