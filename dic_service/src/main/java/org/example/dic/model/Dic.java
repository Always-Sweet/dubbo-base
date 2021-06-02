package org.example.dic.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 章春波
 * @date 2021/6/1 15:50
 * @ClassName: Dic
 * @Description: 字典模型
 */
@Data
@Entity
@Table(name = "dic")
@DynamicInsert
public class Dic implements Serializable {

    @Id
    @Column(name = "dic_id")
    private String dicId;

    @Column(name = "dic_code")
    private String dicCode;

    @Column(name = "dic_name")
    private String dicName;

    @Column(name = "fg_active")
    private Integer fgActive;

    @Column(name = "fg_delete")
    private Integer fgDelete;

}
