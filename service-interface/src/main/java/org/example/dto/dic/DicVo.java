package org.example.dto.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "字典VO", description = "字典视图对象")
public class DicVo implements Serializable {

    @ApiModelProperty(value = "字典", example = "UUID")
    private String dicId;

    @ApiModelProperty(value = "字典编码", example = "dicCode")
    private String dicCode;

    @ApiModelProperty(value = "字典名称", example = "dicName")
    private String dicName;

    @ApiModelProperty(value = "注销状态", example = "0")
    private Integer fgActive;

}
