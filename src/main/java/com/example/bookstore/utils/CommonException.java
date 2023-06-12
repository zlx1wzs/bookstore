package com.example.bookstore.utils;

public class CommonException extends Exception {
    private static final long serialVersionUID = 1L;
    private Result result;

    public CommonException(Result result) {
        this.result = result;
    }

    public CommonException(String s) {
        result.fail(s);
    }

    public CommonException() {
        result.fail();
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

