package pl.com.pjatk.mpr.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.com.pjatk.mpr.model.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Course found")
public class CourseException extends RuntimeException {
    public CourseException(String message){
        super(message);
    }
}
