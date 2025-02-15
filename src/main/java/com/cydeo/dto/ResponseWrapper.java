package com.cydeo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
//@NoArgsConstructor
@Builder
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

//    public ResponseWrapper(String message){
//        this.message = message;
//        this.code = HttpStatus.OK.value();
//        this.success = true;
//    }
//
//    public ResponseWrapper(String message, Object data){
//        this.message = message;
//        this.data = data;
//        this.code = HttpStatus.OK.value();
//        this.success = true;
//    }
//
//    public ResponseWrapper(String message, Object data, HttpStatus httpStatus){
//        this.message = message;
//        this.data = data;
//        this.code = httpStatus.value();
//        this.success = true;
//    }


}
