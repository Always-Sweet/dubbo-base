package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ResultCode;

@Data
@NoArgsConstructor
public class Result {

    private String code;
    private String msg;
    private Object data;

    public Result(ResultCode code, Object data) {
        this.code = code.getCode();
        this.msg = code.getName();
        this.data = data;
    }
}
