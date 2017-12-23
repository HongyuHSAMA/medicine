package com.design.enums;

public enum SupplierAddStateEnum {

    SUCCESS(1,"添加成功"),
    ADD_FAIL(2,"添加失败,添加不能为空");

    private int state;
    private String stateInfo;

    SupplierAddStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SupplierAddStateEnum stateOf(int index){
        for (SupplierAddStateEnum state: values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }



}
