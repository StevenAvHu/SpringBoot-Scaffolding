package com.domain.market;

import com.domain.repository.MarketMgrRepository;
import com.entity.market.MarketEntity;
import com.request.market.MarketMgrRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description: 商品管理domain层
 * @author: 胡宇鑫
 * @create: 2022-03-30 10:48
 **/
@Service
@Slf4j
public class MarketDomainService {
    @Resource
    private MarketMgrRepository marketMgrRepository;

    /**
     * 查询商品基本信息
     *
     * @param marketMgrRequest marketMgrRequest
     * @return MarketEntity
     */
    public MarketEntity queryGoodsInformation(MarketMgrRequest marketMgrRequest) {
        return marketMgrRepository.queryGoodsInformation(marketMgrRequest);
    }

}
