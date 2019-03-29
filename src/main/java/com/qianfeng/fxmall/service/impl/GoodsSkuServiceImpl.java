package com.qianfeng.fxmall.service.impl;

import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.dao.IGoodsSkuDAO;
import com.qianfeng.fxmall.goods.dao.impl.GoodsSkuDAOImpl;
import com.qianfeng.fxmall.service.IGoodsSkuService;

public class GoodsSkuServiceImpl implements IGoodsSkuService {

    private IGoodsSkuDAO goodsSkuDAO = new GoodsSkuDAOImpl();

    @Override
    public void insertGoodsSku(WxbGoodSku wxbGoodSku) {
        goodsSkuDAO.insertGoodsSku(wxbGoodSku);
    }
}
