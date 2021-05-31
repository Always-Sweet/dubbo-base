package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 章春波
 * @date 2021/5/31 14:13
 * @ClassName: PageParams
 * @Description: 分页参数
 */
@Data
public class PageParams {

    /**
     * 页码
     */
    @NotBlank(message = "页码不能为空")
    private Integer page;

    /**
     * 单页数量
     */
    @NotBlank(message = "单页数量不能为空")
    private Integer pageSize;

    /**
     * 返回类型：1.单页返回（默认），2.全量返回
     */
    private Integer returnType;

}
