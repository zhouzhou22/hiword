package com.itaem.crazy.shirodemo.modules.shiro.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import lombok.ToString;

/**
 * @Author 大誌
 * @Date 2019/4/7 14:44
 * @Version 1.0
 */

@Data
@Entity
@ToString
public class Role {

    @Id
    private Integer roleId;
    private String roleName;
    private Integer deleteFlag;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "permissionId")})
    private Set<Permission> permissions;
}