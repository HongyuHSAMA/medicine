package com.design.entity;

import lombok.Getter;
import lombok.Setter;

public enum  Message {

    ADD_SUCCESS("新增成功"),
    ADD_FAIL("新增失败"),
    DATE_ERROR("日期错误"),
    PICTURE_ERROR("图片上传错误");

    @Getter private String msg;

    public static final String statusMsg = "message";

    Message(String msg) {
        this.msg = msg;
    }
}
