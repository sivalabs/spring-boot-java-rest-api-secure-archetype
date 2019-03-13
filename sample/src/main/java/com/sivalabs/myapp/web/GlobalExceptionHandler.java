package com.sivalabs.myapp.web;

import com.sivalabs.myapp.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleBindingErrors(HttpMessageNotReadableException ex) {
        throw ex;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationErrors(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errors = new ArrayList<>();

        for (Object object : ex.getBindingResult().getAllErrors()) {
            ErrorMessage e = null;
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                String msg = messageSource.getMessage(fieldError, Locale.getDefault());
                e = new ErrorMessage(fieldError.getField(), msg);
            } else if (object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;
                String msg = messageSource.getMessage(objectError, Locale.getDefault());
                e = new ErrorMessage(objectError.getObjectName(), msg);
            }
            errors.add(e);
        }
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }
}
