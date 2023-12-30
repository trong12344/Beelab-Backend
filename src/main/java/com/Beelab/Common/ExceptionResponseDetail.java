package com.Beelab.Common;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponseDetail {

    private HttpStatus status;
    private String message;
    private Object data;

    public ExceptionResponseDetail(HttpStatus status, String message) {
        this.status = (status != null) ? status : HttpStatus.BAD_REQUEST;
        this.message = (message != null) ? message : "Dữ liệu không hợp lệ";
        this.data = (data != null) ? data : null;

    }

}
