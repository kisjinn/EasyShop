package dev.sakshi.easyshop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ExceptionDto{
    private HttpStatus errorCode;
    private String msg;

    public ExceptionDto(HttpStatus s, String m){
        errorCode=s;
        msg=m;
    }
}
