package com.insmart.Training.bean;

import java.util.List;

public class ResponseData<T> {
    private String error;
    private String message;
    private List<T> data;
    private int status;

    public ResponseData(String error, String message, List<T> data, int status) {
        this.error = error;
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
