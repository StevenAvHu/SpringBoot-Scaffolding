package com.entity.market;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: springCloud
 * @description: 商品实体类
 * @author: 胡宇鑫
 * @create: 2022-04-02 09:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MarketEntity {
    /**
     * ID
     */
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品编号
     */
    private String code;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private int num;
    /**
     * 统计日期
     */
    private Date inDate;
}
