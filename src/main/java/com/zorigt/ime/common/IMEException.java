package com.zorigt.ime.common;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IMEException extends RuntimeException {

    private static final long serialVersionUID = -4328512807639556120L;

    private Integer code;

    public IMEException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public IMEException(State state) {
        super(state.getMessage());
        this.code = state.getCode();
    }
}
