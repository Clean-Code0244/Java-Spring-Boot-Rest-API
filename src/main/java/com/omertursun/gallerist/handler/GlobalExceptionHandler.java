package com.omertursun.gallerist.handler;

import com.omertursun.gallerist.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
       return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> errors = new HashMap<>();
        for(ObjectError objectError  : ex.getBindingResult().getFieldErrors()) {
            String fieldName = ((FieldError) objectError).getField();

            if(errors.containsKey(fieldName)) {
                errors.put(fieldName, addError(errors.get(fieldName),objectError.getDefaultMessage()));
            }
            else {
                errors.put(fieldName, addError(new ArrayList<>(),objectError.getDefaultMessage()));
            }
        }


         return ResponseEntity.badRequest().body(createApiError(errors,request));
    }
    private List<String> addError(List<String> list,String message) {
        list.add(message);
        return list;
    }
    private String getHostName() {
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }
    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();
        exception.setPath(request.getDescription(false));
        exception.setMessage(message);
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        apiError.setException(exception);

        return apiError;
    }
}
