package com.test;


import com.entity.market.MarketEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：输入输出测试
 */
public class Main {


    public static void main(String[] args) {
        MarketEntity market = new MarketEntity();
        Class a = market.getClass();
        List<String> list = new ArrayList<>();
        Class b = list.getClass();
        System.out.println(a.isSynthetic());
        System.out.println(b.isSynthetic());
    }


}
