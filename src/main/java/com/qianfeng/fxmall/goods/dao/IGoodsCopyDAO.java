package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;

import java.util.List;

/**
 * 商品文案管理
 */
public interface IGoodsCopyDAO {

    List<WxbGoodCopy> queryWxbGoodsCopyByPage(Integer page);
}
