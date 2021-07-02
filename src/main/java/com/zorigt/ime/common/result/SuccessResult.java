package com.zorigt.ime.common.result;

import com.zorigt.ime.common.State;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SuccessResult extends ResultBase {
    public SuccessResult() {
        this.ret = true;
        this.retCode = State.success.getCode();
    }

    public static SuccessResult get() {
        return new SuccessResult();
    }
}
