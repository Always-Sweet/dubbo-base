package org.example.dto.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "字典查询参数", description = "查询字典相关参数（可扩展）")
public class DicQuery {

    @ApiModelProperty(value = "字典编码", example = "dicCode")
    private String dicCode;

    @ApiModelProperty(value = "字典名称", example = "字典名称")
    private String dicName;

}
