package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsMapper {

    List<WxbGood> queryGoodsByPage(@Param("index")Integer index,@Param("size")Integer size);//分页查询

    void insertGoodsAndGoodsSku(WxbGood wxbGood);//增
}
