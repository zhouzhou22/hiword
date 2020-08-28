package com.itaem.crazy.shirodemo.modules.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ProjectName ：com.yangjy.demo.entity
 * @Description:
 * @MClassName: Charts
 * @Authur: yangjianyi
 * @Date: 2020/4/1 17:13
 */
@Entity
@Data
@ToString
public class Charts {

    @Id
    private long id;

    private String stockName;

    private double price;

    private String date;

}
