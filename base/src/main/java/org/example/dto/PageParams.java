package org.example.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 章春波
 * @date 2021/5/31 14:13
 * @ClassName: PageParams
 * @Description: 分页参数
 */
@Data
public class PageParams implements Serializable {

    /**
     * 页码
     */
//    @NotNull(message = "页码不能为空")
    @Min(1)
    private Integer pageNo;

    /**
     * 单页数量
     */
//    @NotNull(message = "单页数量不能为空")
    @Min(1)
    private Integer pageSize;

    /**
     * 返回类型：1.单页返回（默认），2.全量返回
     */
    private Integer returnType = 1;

    public void setReturnType(Integer returnType) {
        this.returnType = returnType == null ? 1 : returnType;
    }
}
