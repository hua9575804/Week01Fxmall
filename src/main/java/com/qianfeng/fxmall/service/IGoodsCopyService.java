package com.qianfeng.fxmall.service;

import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;

import java.util.List;

public interface IGoodsCopyService {

    List<WxbGoodCopy> queryWxbGoodsCopyByPage(Integer page);
}
