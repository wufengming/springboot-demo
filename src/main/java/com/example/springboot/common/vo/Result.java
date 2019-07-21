package com.example.springboot.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wfm
 * @title: Result
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1314:32
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
