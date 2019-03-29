package com.qianfeng.fxmall.service.impl;

import com.qianfeng.fxmall.commons.info.SystemConstatsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.impl.GoodsDAOImpl;
import com.qianfeng.fxmall.service.IGoodsService;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    private IGoodsDAO goodsDAO = new GoodsDAOImpl();

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) {
        //业务逻辑代码写在service层、自定义异常
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        //计算起始下标
        int index = (page - 1) * SystemConstatsUtils.Page.PAGE_SIZE;
        List<WxbGood> wxbGoods = goodsDAO.queryGoodsByPage(index);
        return wxbGoods;
    }

    @Override
    public void insertGoodsAndGoodsSku(WxbGood wxbGood) {
        if (wxbGood == null) {
            throw new IndexOutOfBoundsException("不能插入空值");
        }
        goodsDAO.insertGoodsAndGoodsSku(wxbGood);
    }
}
