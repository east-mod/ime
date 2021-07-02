package com.zorigt.ime.common;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class State {
    public static State success = new State(30200, "success");
    public static State INVALID_PARAM = new State(30420, "Invalid param.");
    public static State DATA_CHANGED = new State(30421, "Data changed.");
    public static State noExistResource = new State(30422, "no exist resource");
    public static State internalServerError = new State(30423, "Internal server error");
    public static State notFound = new State(30424, "This interface is not found");
    public static State NO_ENUM_TYPE = new State(30425, "does not represent an enum type");
    public static State INVALID_PAGE_PARAM = new State(30426, "Invalid page param.");

    private Integer code;
    private String message;

    protected State(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
