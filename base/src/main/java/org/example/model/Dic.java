package org.example.model;

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
    private String dicCode;

    @Column(name = "dic_name")
    private String dicName;

    @Column(name = "fg_delete")
    private Integer fgDelete;

}
