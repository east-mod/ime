package com.zorigt.ime.common;

import com.zorigt.ime.common.result.ErrorResult;
import com.zorigt.ime.common.result.ResultBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


@ControllerAdvice
public class IMEExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(IMEExceptionAdvice.class);


    @ExceptionHandler(IMEException.class)
    @ResponseBody
    public ResultBase eastModExceptionHandler(IMEException e) {
        logger.warn("code:" + e.getCode() + ",message:" + e.getMessage());
        return ErrorResult.get(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBase ExceptionHandler(Exception e) {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(errorStream));
        logger.error(errorStream.toString());
        return ErrorResult.get(State.INTERNAL_SERVER_ERROR);
    }
}
