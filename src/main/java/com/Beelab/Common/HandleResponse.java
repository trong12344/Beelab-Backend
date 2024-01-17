package com.Beelab.Common;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
public class HandleResponse<T>{
    private T data= null;
    @Getter
    private String ErrorMessage, SuccesMessage;
    private HttpStatus httpStatus = HttpStatus.OK;

    public  T get(){
        return data;
    }
    public boolean isOk(){
        return ErrorMessage == null || ErrorMessage.isEmpty();
    }

    public boolean hasError(){
        return ErrorMessage != null && !ErrorMessage.isEmpty();
    }

    public static <T>HandleResponse<T> ok( T data){

        return HandleResponse.<T>builder().data(data).build();
    }

    public static <T>HandleResponse<T> ok( ){
        return HandleResponse.<T>builder().build();
    }

    public static <T>HandleResponse<T> error(String error){
        return HandleResponse.<T>builder().ErrorMessage(error).httpStatus(HttpStatus.BAD_REQUEST).build();
    }
    public static <T>HandleResponse<T> SuccesMessage(String mes){

        return HandleResponse.<T>builder().SuccesMessage(mes).httpStatus(HttpStatus.OK).build();
    }
    public static <T>HandleResponse<T> error(String error, HttpStatus httpStatus){
        return HandleResponse.<T>builder().ErrorMessage(error).httpStatus(httpStatus).build();
    }
    public static <T>HandleResponse<T> SuccesMessage(String mes, HttpStatus status){

        return HandleResponse.<T>builder().SuccesMessage(mes).httpStatus(status).build();
    }
    public T orThrow(){
        if (ErrorMessage != null && !ErrorMessage.isEmpty()){
            throw new ResponseStatusException(httpStatus, ErrorMessage);
        }
        return data;
    }

}
