package org.example.dto.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.valid.dic.DicSaveCheck;
import org.example.valid.dic.DicUpdateCheck;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@ApiModel(value = "字典DO", description = "字典领域对象")
public class DicDo implements Serializable {

    @ApiModelProperty(value = "字典", example = "UUID")
    @NotEmpty(message = "字典主键不能为空", groups = DicUpdateCheck.class)
    private String dicId;

    @ApiModelProperty(value = "字典编码", example = "dicCode")
    @NotEmpty(message = "字典编码不能为空", groups = {DicSaveCheck.class, DicUpdateCheck.class})
    private String dicCode;

    @ApiModelProperty(value = "字典名称", example = "dicName")
    @NotEmpty(message = "字典名称不能为空", groups = {DicSaveCheck.class, DicUpdateCheck.class})
    private String dicName;

}
