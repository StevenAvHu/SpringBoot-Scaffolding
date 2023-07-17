package com.domain.repository;

import com.entity.market.MarketEntity;
import com.request.market.MarketMgrRequest;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 项目管理查询Repository
 */
@Mapper
@Repository
public interface MarketMgrRepository {
    MarketEntity queryGoodsInformation(@RequestBody MarketMgrRequest marketMgrRequest);
}
