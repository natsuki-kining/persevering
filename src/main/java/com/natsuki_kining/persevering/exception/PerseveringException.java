package com.natsuki_kining.persevering.exception;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 11:18
 **/
public class PerseveringException extends RuntimeException{

    public PerseveringException(String message){
        super(message);
    }

    public PerseveringException(String message,Exception e){
        super(message,e);
    }
}
