package com.example.restfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    //Xử lý exception NotFoundException mà ta đã tạo
    @ExceptionHandler(NotFoundException.class) //Chỉ cho rõ method này ta xử l exception nào
    @ResponseStatus(HttpStatus.NOT_FOUND) // Định nghĩa status trả về cho người dùng
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }


}
