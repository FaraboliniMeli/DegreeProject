package br.com.marcello.DegreeProject.exceptionsHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionResponse> constraintViolationException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        e.getBindingResult().getAllErrors()
                .forEach(objectError -> sb.append(objectError.getDefaultMessage() + ". "));

        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setDate(LocalDate.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setExceptionMessage(sb.toString());
        response.setMessage("Invalid JSON format, please check doc.");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionResponse> globalExceptionHandler(Exception e) {

        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setDate(LocalDate.now());
        response.setExceptionMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Internal Server Error. Please read exception message.");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
