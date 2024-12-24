package gfs.webp.pesme.exceptions.handler;

import gfs.webp.pesme.exceptions.ApiException;
import gfs.webp.pesme.exceptions.SysException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiHandler {

    @ExceptionHandler(SysException.class)
    ResponseEntity<ApiException> handleUserExceptions(SysException ex){
        return ResponseEntity
                .status(ex.getCode())
                .body(new ApiException(ex.getMessage(), LocalDateTime.now()));
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiException> handleSystemExceptions(Exception ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiException(ex.getMessage(), LocalDateTime.now()));
    }

}
