package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstatsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.IGoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis的商品数据访问层
 * 注意：异常在dao层不要捕获
 */
public class GoodsDAOImpl implements IGoodsDAO {

    SqlSession sqlSession = MyBatisSessionFactoryUtils.getSqlSession();
    IGoodsMapper goodsMapper = sqlSession.getMapper(IGoodsMapper.class);

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page){
//        //配置文件全局只需加载一次
//        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
//        //SqlSessionFactory全局唯一(饿汉单例模式)
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = MyBatisSessionFactoryUtils.getSqlSessionFactory().openSession();
        List<WxbGood> wxbGoods = goodsMapper.queryGoodsByPage(page, SystemConstatsUtils.Page.PAGE_SIZE);
//        sqlSession.close();//ThreadLocal<SqlSession>
        return wxbGoods;
    }

    @Override
    public void insertGoodsAndGoodsSku(WxbGood wxbGood) {
        goodsMapper.insertGoodsAndGoodsSku(wxbGood);
        sqlSession.commit();
    }
}
