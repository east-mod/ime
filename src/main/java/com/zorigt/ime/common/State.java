package com.zorigt.ime.common;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class State {
    public static State SUCCESS = new State(30200, "success");
    public static State INVALID_PARAM = new State(30420, "invalid param.");
    public static State NO_EXIST_RESOURCE = new State(30422, "no exist resource");
    public static State INTERNAL_SERVER_ERROR = new State(30423, "internal server error");
    public static State NO_ENUM_TYPE = new State(30425, "does not represent an enum type");

    private Integer code;
    private String message;

    protected State(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
