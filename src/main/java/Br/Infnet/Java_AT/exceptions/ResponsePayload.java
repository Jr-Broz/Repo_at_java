package Br.Infnet.Java_AT.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponsePayload {


     String msg;
    LocalDateTime dateTime;

    public ResponsePayload(String msg) {

        this.msg = msg;
        this.dateTime = LocalDateTime.now();
    }




}
