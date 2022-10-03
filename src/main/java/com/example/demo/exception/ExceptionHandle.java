package com.example.demo.exception;

import com.example.demo.controller.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ControllerAdvice
//@Service
public class ExceptionHandle {
//    @ExceptionHandler(AccountRestApiException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<BaseResponse> handleBadRequestException(AccountRestApiException ex) {
//        return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.OK);
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<BaseResponse> handleUnAuthorizedRequestException(Exception ex) {
//        return new ResponseEntity<>(new BaseResponse(0, ex.getMessage()), HttpStatus.OK);
//    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<BaseResponse>handlerException(Exception ex) {
//        return new ResponseEntity<>(new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.OK);
//    }
}
