package xyz.lidaning.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorEnum {

    ERROR_USER(500100, "error username or password")
    ;
    int code;
    String message;
}
