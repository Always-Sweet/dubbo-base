package org.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 章春波
 * @date 2021/6/25 9:30
 * @ClassName: PageResponse
 * @Description: 分页返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "分页查询结果", description = "页码超最大分页时默认降级为最后一页")
public class PageResponse<T> implements Serializable {

    @ApiModelProperty(value = "实际页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "总页数", example = "10")
    private Integer totalPageNum;

    @ApiModelProperty(value = "总页数", example = "10")
    private List<T> pageItems;

    public PageResponse(List<T> pageItems) {
        this.pageItems = pageItems;
    }
}
