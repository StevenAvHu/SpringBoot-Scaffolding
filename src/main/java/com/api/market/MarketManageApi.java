package com.api.market;

import com.common.result.APIResult;
import com.request.market.MarketMgrRequest;
import com.service.market.MarketManageService;
import io.swagger.annotations.Api;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

/**
 * @program: springCloud
 * @description: 商品Api
 * @author: 胡宇鑫
 * @create: 2022-03-30 10:43
 **/
@RestController
@RequestMapping("/market")
@Slf4j
@Api(value = "商品")
public class MarketManageApi {
    /**
     * marketManageService
     */
    @Resource
    private MarketManageService marketManageService;

    /**
     * 查询商品基本信息接口
     * @param marketMgrRequest marketMgrRequest
     * @return APIResult
     */
    @PostMapping(value = "/queryGoodsInformation")
    public APIResult queryGoodsInformation(@RequestBody MarketMgrRequest marketMgrRequest){
       return marketManageService.queryGoodsInformation(marketMgrRequest);
    }
}
