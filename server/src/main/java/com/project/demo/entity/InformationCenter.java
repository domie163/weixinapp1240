package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 信息中心：(InformationCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "InformationCenter")
public class InformationCenter implements Serializable {

    // InformationCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_center_id")
    private Integer information_center_id;

    // 发送用户
    @Basic
    private Integer send_user;
    // 接收用户
    @Basic
    private Integer receiving_user;
    // 信息标题
    @Basic
    private String message_header;
    // 发送日期
    @Basic
    private Timestamp send_date;
    // 信息内容
    @Basic
    private String information_content;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
