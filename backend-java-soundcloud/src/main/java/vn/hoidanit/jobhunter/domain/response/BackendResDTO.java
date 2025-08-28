package vn.hoidanit.jobhunter.domain.response;

import lombok.Data;

@Data
public class BackendResDTO<T> {
    private String message;
    private String statusCode;
    private T data;
    private String[] error;
}