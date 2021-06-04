package org.example.dto.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.example.Constant;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "字典删除参数", description = "多选删除及删除形式（注销/数据沉默）")
public class DicDeleteParams {

    @NotNull
    @ApiModelProperty(value = "字典编码列表", example = "[1,2,3]")
    private List<String> ids;

    @ApiModelProperty(value = "删除类型", example = "0")
    private String deleteType;

    public void setDeleteType(String deleteType) {
        this.deleteType = StringUtils.isBlank(deleteType) ?
                Constant.DELETE_TYPE.SOFT_0 : Constant.DELETE_TYPE.HARD_1;
    }
}
