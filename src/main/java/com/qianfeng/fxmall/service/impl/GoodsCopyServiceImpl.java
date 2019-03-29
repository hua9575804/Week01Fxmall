package com.qianfeng.fxmall.service.impl;

import com.qianfeng.fxmall.commons.info.SystemConstatsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;
import com.qianfeng.fxmall.goods.dao.IGoodsCopyDAO;
import com.qianfeng.fxmall.goods.dao.impl.GoodsCopyDAOImpl;
import com.qianfeng.fxmall.service.IGoodsCopyService;

import java.util.List;

public class GoodsCopyServiceImpl implements IGoodsCopyService {

    private IGoodsCopyDAO goodsCopyDAO = new GoodsCopyDAOImpl();

    @Override
    public List<WxbGoodCopy> queryWxbGoodsCopyByPage(Integer page) {
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        int index = (page - 1) * SystemConstatsUtils.Page.PAGE_SIZE;
        List<WxbGoodCopy> wxbGoodCopies = goodsCopyDAO.queryWxbGoodsCopyByPage(index);
        return wxbGoodCopies;
    }
}
