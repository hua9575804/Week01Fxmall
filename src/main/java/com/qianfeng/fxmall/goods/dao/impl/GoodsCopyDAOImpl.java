package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstatsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;
import com.qianfeng.fxmall.goods.dao.IGoodsCopyDAO;
import com.qianfeng.fxmall.goods.mapper.IGoodsCopyMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GoodsCopyDAOImpl implements IGoodsCopyDAO {

    SqlSession sqlSession = MyBatisSessionFactoryUtils.getSqlSession();
    IGoodsCopyMapper goodsCopyMapper = sqlSession.getMapper(IGoodsCopyMapper.class);

    @Override
    public List<WxbGoodCopy> queryWxbGoodsCopyByPage(Integer page) {
        List<WxbGoodCopy> wxbGoodCopies = goodsCopyMapper.queryWxbGoodsCopyByPage(page, SystemConstatsUtils.Page.PAGE_SIZE);
        return wxbGoodCopies;
    }
}
