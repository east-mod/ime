package com.zorigt.ime.common.result;

import com.zorigt.ime.common.State;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GenericResult<T> extends ResultBase {
    T data;

    public GenericResult(T data) {
        this.ret = true;
        this.retCode = State.SUCCESS.getCode();
        this.data = data;
    }

    public static <T> GenericResult<T> get(T data) {
        return new GenericResult<>(data);
    }
}
