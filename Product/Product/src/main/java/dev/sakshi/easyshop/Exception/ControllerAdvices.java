package dev.sakshi.easyshop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {
    //below method is exceptional handler.
    //When NotFoundException thrown by any other method then below method will get triggered and it will print msg
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleException(NotFoundException notFoundException){
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
        return response;
    }
}
