package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.dao.IGoodsSkuDAO;
import com.qianfeng.fxmall.goods.mapper.IGoodsSkuMapper;
import org.apache.ibatis.session.SqlSession;

public class GoodsSkuDAOImpl implements IGoodsSkuDAO {

    SqlSession sqlSession = MyBatisSessionFactoryUtils.getSqlSession();
    IGoodsSkuMapper goodsSkuMapper = sqlSession.getMapper(IGoodsSkuMapper.class);

    @Override
    public void insertGoodsSku(WxbGoodSku wxbGoodSku) {
        goodsSkuMapper.insertGoodsSku(wxbGoodSku);
        sqlSession.commit();
    }
}
