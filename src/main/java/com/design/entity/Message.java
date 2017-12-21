package com.design.entity;

import lombok.Getter;
import lombok.Setter;

public enum  Message {

    ADD_SUCCESS("新增成功"),
    ADD_FAIL("新增失败");

    @Getter private String msg;

    public static final String statusMsg = "message";

    Message(String msg) {
        this.msg = msg;
    }
}
