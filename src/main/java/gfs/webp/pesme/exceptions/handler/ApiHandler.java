package gfs.webp.pesme.exceptions.handler;

import gfs.webp.pesme.exceptions.ApiException;
import gfs.webp.pesme.exceptions.SysException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ApiHandler {

    @ExceptionHandler(SysException.class)
    ResponseEntity<ApiException> handleUserExceptions(SysException ex){
        return ResponseEntity
                .status(ex.getCode())
                .body(new ApiException(ex.getMessage(), LocalDateTime.now()));
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiException> handleSystemExceptions(Exception ex){
        log.error("Server error!", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiException(ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiException> handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage) // Samo poruka greške
                .toList();

        String userFriendlyMessage = String.join(", ", errorMessages);

        ApiException apiException = new ApiException(userFriendlyMessage, LocalDateTime.now());

        log.info("Invalid arguments: {}", userFriendlyMessage, ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

}
