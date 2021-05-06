package org.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dic")
@ApiModel(value = "字典", description = "字典模型")
public class Dic implements Serializable {

    @Id
    @Column(name = "dic_id")
    @ApiModelProperty(value = "字典", example = "UUID")
    private String dicId;

    @Column(name = "dic_code")
    @ApiModelProperty(value = "字典编码", example = "dicCode")
    @NotBlank(message = "字典编码不能为空")
    private String dicCode;

    @Column(name = "dic_name")
    @ApiModelProperty(value = "字典名称", example = "dicName")
    @NotBlank(message = "字典名称不能为空")
    private String dicName;

    @Column(name = "fg_delete")
    @ApiModelProperty(value = "删除标识", example = "0")
    private Integer fgDelete;

}
