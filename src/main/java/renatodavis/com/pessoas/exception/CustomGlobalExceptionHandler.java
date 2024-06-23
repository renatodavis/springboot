package renatodavis.com.pessoas.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.SignatureException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleException(ResponseStatusException exception,
                                                  HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hora", new Date());
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        body.put("status", badRequest.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, badRequest);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Object> handleException(RegraDeNegocioException exception,
                                                  HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hora", new Date());
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        body.put("status", badRequest.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, badRequest);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<Object> handleException(SignatureException exception,
                                                  HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hora", new Date());
        final HttpStatus badRequest = HttpStatus.FORBIDDEN;
        body.put("status", badRequest.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, badRequest);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception,
                                                  HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hora", new Date());
        final HttpStatus badRequest = HttpStatus.FORBIDDEN;
        body.put("status", badRequest.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, badRequest);
    }
}
