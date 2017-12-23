package com.design.entity;

import lombok.Getter;
import lombok.Setter;

public enum  Message {

    ADD_SUCCESS("新增成功"),
    ADD_FAIL("新增失败"),
    DATE_ERROR("日期错误"),
    PICTURE_ERROR("图片上传错误"),
    DELETE_SUCCESS("删除成功"),
    DELETE_FAIL("删除失败,请再试一次"),
    DELETE_ERROR("禁止对存在库存记录的药品进行删除操作"),
    ERROR("未知错误，请再试一次");

    @Getter private String msg;

    public static final String statusMsg = "message";

    Message(String msg) {
        this.msg = msg;
    }
}
