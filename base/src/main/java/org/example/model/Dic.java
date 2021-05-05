package org.example.model;

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
public class Dic implements Serializable {

    @Id
    @Column(name = "dic_id")
    private String dicId;

    @Column(name = "dic_code")
    @NotBlank(message = "字典编码不能为空")
    private String dicCode;

    @Column(name = "dic_name")
    @NotBlank(message = "字典名称不能为空")
    private String dicName;

    @Column(name = "fg_delete")
    private Integer fgDelete;

}
