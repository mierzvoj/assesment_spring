package pl.com.pjatk.mpr.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception){
        return new ResponseEntity<>("Entity does not exist", HttpStatus.BAD_REQUEST);
    }

}