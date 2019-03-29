package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * sessionFactory的封装、做到全局唯一
 */
public class MyBatisSessionFactoryUtils {

    /**
     * 优化SqlSessionFactory
     * 饿汉式单例模式 + 静态代码块
     */
    //全局唯一
    public static SqlSessionFactory sqlSessionFactory;
    //SqlSession放到ThreadLocal中、SqlSession就属于线程私有、如果线程销毁、线程中私有变量也会销毁
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    //方法封装
    public static void initSqlSessionFaction(){
        try {
            //配置文件全局只需加载一次
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            //SqlSessionFactory全局唯一(饿汉单例模式)
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //静态代码块
    static {
        initSqlSessionFaction();
    }
    //返回SqlSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            initSqlSessionFaction();
        }
        return sqlSessionFactory;
    }

    /**
     *优化SqlSession
     * 解决：频繁开启和关闭
     * ThreadLocal<SqlSession>将SqlSession线程私有化(无需手动关闭)
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
}
