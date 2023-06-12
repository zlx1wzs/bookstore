package com.example.bookstore.utils;

public class AgainLoginException extends Exception {
    private static final long serialVersionUID = 1L;

    public AgainLoginException(String s) {
        Result result = new Result();
        result.againLogins(s);
    }

    public AgainLoginException() {
        Result result = new Result();
        result.againLogins();
    }

}