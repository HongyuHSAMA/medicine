package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Worker {

    @Getter @Setter private String workerName;
    @Getter @Setter private Integer workerId;
    @Getter @Setter  private String workerPassword;
}
