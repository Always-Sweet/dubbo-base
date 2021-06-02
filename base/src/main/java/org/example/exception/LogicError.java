package org.example.exception;

import lombok.Getter;
import org.example.ResultCode;

/**
 * @author 章春波
 * @date 2021/6/1 15:58
 * @ClassName: LogicError
 * @Description: 逻辑异常
 */
@Getter
public class LogicError extends Exception {

    private ResultCode resultCode;

    public LogicError(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

}
