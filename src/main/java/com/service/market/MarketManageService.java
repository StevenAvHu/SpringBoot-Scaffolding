package com.service.market;

import com.common.exception.BusinessException;
import com.common.result.APIResult;
import com.domain.market.MarketDomainService;
import com.entity.market.MarketEntity;
import com.request.market.MarketMgrRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description: 商品管理Service
 * @author: 胡宇鑫
 * @create: 2022-03-30 10:47
 **/
@Service
@Slf4j
public class MarketManageService {

    /**
     * MarketDomainService
     */
    @Resource
    private MarketDomainService marketDomainService;

    /**
     * 查询商品基本信息service
     * @param  marketMgrRequest marketMgrRequest
     * @return APIResult
     */
    public APIResult queryGoodsInformation(MarketMgrRequest marketMgrRequest) {
        try {
            MarketEntity marketMgrResponse = marketDomainService.queryGoodsInformation(marketMgrRequest);
            return APIResult.success(marketMgrResponse);
        }catch (Exception e){
            log.info("商品查询出错：",e);
            throw new BusinessException("商品查询报错:",e);
        }
    }

}
