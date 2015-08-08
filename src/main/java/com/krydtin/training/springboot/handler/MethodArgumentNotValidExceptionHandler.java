package com.krydtin.training.springboot.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author krydtin
 */
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handler(final MethodArgumentNotValidException ex) {
        final Map<String, Object> map = new HashMap<>();
        final List<Map<String, Object>> mapErrors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            final Map<String, Object> mapError = new HashMap<>();
            mapError.put("field", error.getField());
            mapError.put("message", error.getDefaultMessage());
            mapErrors.add(mapError);
        }
        map.put("error", mapErrors);
        return map;
    }
}
