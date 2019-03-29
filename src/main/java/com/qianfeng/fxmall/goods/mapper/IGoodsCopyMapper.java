package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsCopyMapper {

    List<WxbGoodCopy> queryWxbGoodsCopyByPage(@Param("index")Integer index,@Param("size")Integer size);
}
