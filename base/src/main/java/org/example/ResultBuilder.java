package org.example;

import org.example.dto.Result;

/**
 * @author 章春波
 * @date 2021/5/31 13:41
 * @ClassName: ResultBuilder
 * @Description: 返回对象构造器
 */
public class ResultBuilder {

    /**
     * @author 章春波
     * @date 2021/5/31 13:49
     * @Description: 请求成功（有数据返回）
     * @param data 返回数据
     * @return org.example.dto.Result
     */
    public static Result successWithData(Object data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    /**
     * @author 章春波
     * @date 2021/5/31 13:50
     * @Description: 请求成功（无数据返回）
     * @param
     * @return org.example.dto.Result
     */
    public static Result successWithoutData() {
        return new Result(ResultCode.SUCCESS, null);
    }

    /**
     * @author 章春波
     * @date 2021/5/31 13:50
     * @Description: 请求拒绝
     * @param code 错误信息
     * @return org.example.dto.Result
     */
    public static Result failure(ResultCode code) {
        return new Result(code, null);
    }

    public static Result failure(ResultCode code, String msg) {
        return new Result(code, msg);
    }
}
