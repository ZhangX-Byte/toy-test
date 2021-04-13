package com.toy.dto;

import lombok.Data;

/**
 * 用于封装返回结果
 * <p>
 * T 代表任意返回结果类型
 *
 * @author Zhang_Xiang
 * @since 2021/4/9 13:59:35
 */
@Data
public class Result<T> {

    private Boolean succeeded;

    private String msg;

    private T data;

    public Result(T data, Boolean succeeded, String msg) {
        this.data = data;
        this.succeeded = succeeded;
        this.msg = msg;
    }

    public static <T> Result<T> failure(String msg) {
        return new Result<>(null, false, msg);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data, true, "");
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(null, true, msg);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result<>(data, true, msg);
    }

}
