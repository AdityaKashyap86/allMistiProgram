package MistiProgram.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerCustomEcxeption.class)

    public ResponseEntity<ExceptionResponse> RecNotFound(CustomerCustomEcxeption customEcxeption) {
        ExceptionResponse exResponse = new ExceptionResponse();
        exResponse.setMsg("RECORD NOT FOUND");
        exResponse.setLocalDateTime(LocalDateTime.now());
        ResponseEntity<ExceptionResponse> entity =new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
        return entity;

        /*public ResponseEntity<ExceptionResponce> recordNotFound(RecordNotFoundException recNotFound) {

        ExceptionResponce exResponce   = new ExceptionResponce();
        exResponce.setMsg("RECORD NOT FOUND");
        exResponce.setLocalDateTime(LocalDateTime.now());
        ResponseEntity<ExceptionResponce> entity  = new ResponseEntity<>(exResponce, HttpStatus.NOT_FOUND);
        return entity;*/



    }

}
