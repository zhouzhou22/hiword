package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author 大誌
 * @Date 2019/4/7 14:45
 * @Version 1.0
 */
@Data
@Entity
public class Permission {

    @Id
    private Integer permissionId;
    private String permissionName;
    private String permission;
    private Integer type;
    private Integer parentPermissionId;
    private String icon;
}
