package org.example;

import org.apache.commons.lang3.StringUtils;

public enum ResultCode {
    SUCCESS("100", "调用成功"),
    SEARCH_MISS("101", "未查询到数据"),
    FAILURE("200", "请求失败");

    private String code;
    private String name;

    ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public ResultCode getCode(String code) {
        if (StringUtils.isEmpty(code)) return null;

        ResultCode result = null;
        ResultCode[] codes = ResultCode.values();
        for (ResultCode c : codes) {
            if (code.equals(c.getCode())) {
                if (result == null) {
                    result = c;
                } else {
                    // CODE重复
                }
            }
        }
        return result;
    }

}
