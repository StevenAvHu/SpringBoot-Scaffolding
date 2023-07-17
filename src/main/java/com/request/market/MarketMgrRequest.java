package com.request.market;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: springCloud
 * @description: MarketManagerRequest
 * @author: 胡宇鑫
 * @create: 2022-03-30 10:51
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MarketMgrRequest {
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
    private int number;
    /**
     * 统计日期
     */
    private Date date;
}
