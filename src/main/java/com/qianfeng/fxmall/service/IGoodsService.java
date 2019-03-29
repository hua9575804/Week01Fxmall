package com.qianfeng.fxmall.service;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsService {

    List<WxbGood> queryGoodsByPage(Integer page);

    void insertGoodsAndGoodsSku(WxbGood wxbGood);
}
