package com.design.enums;

public enum MessageEnum {

    SUCCESS(1,"操作成功"),
    ADD_FAIL(2,"添加失败,添加不能为空"),
    DELETE_FAIL(3,"删除失败");

    private int state;
    private String stateInfo;

    MessageEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static MessageEnum stateOf(int index){
        for (MessageEnum state: values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }



}
