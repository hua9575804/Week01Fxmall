package com.qianfeng.fxmall;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.dao.impl.GoodsDAOImpl;
import com.qianfeng.fxmall.service.IGoodsService;
import com.qianfeng.fxmall.service.IGoodsSkuService;
import com.qianfeng.fxmall.service.impl.GoodsServiceImpl;
import com.qianfeng.fxmall.service.impl.GoodsSkuServiceImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 中国提交
 */
public class TestAn {

    /**
     * @param args
     */
//    public static void main(String[] args) {
//        //线程1
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                GoodsDAOImpl goodsDAO = new GoodsDAOImpl();
//                try {
//                    List<WxbGood> wxbGoods = goodsDAO.queryGoodsByPage(0);
//                    wxbGoods.get(0).setGoodName("优化");
//                    System.out.println("------线程1-----"+wxbGoods.get(0).getGoodName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                //线程1的二次执行
//                GoodsDAOImpl goodsDAO1 = new GoodsDAOImpl();
//                try {
//                    List<WxbGood> goods = goodsDAO1.queryGoodsByPage(0);
//                    System.out.println("线程1的二次执行：" +goods.get(0).getGoodName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                //线程2
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        GoodsDAOImpl goodsDAO = new GoodsDAOImpl();
//                        try {
//                            List<WxbGood> wxbGoods = goodsDAO.queryGoodsByPage(0);
//                            System.out.println("------线程2-----"+wxbGoods.get(0).getGoodName());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//            }
//        }).start();
//    }
    public static void main(String[] args) {
        WxbGood wxbGood = new WxbGood();
        String goodId = UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        wxbGood.setGoodId(goodId);
        wxbGood.setGoodName("测试商品006");
        wxbGood.setCustomerId("商户ID");
        wxbGood.setGoodPic("E:\\java_advanced\\workspace\\MerchantSystem");
        wxbGood.setGoodPic1("E:\\java_advanced\\workspace\\MerchantSystem");
        wxbGood.setGoodPic2("E:\\java_advanced\\workspace\\MerchantSystem");
        wxbGood.setPromoteDesc("推广说明");
        wxbGood.setSkuTitle("sku描述");
        wxbGood.setSkuCost("成本");
        wxbGood.setSkuPrice("价格");
        wxbGood.setSkuPmoney("分成");
        wxbGood.setCopyIds("文案ID");
        wxbGood.setCopyDesc("文案说明");
        wxbGood.setForwardLink("跳转链接");
        wxbGood.setOrderNo(001);
        wxbGood.setTypeId("商品分类");
        wxbGood.setTags("标签信息");
        wxbGood.setState(012);
        wxbGood.setCreateTime(timestamp);
        wxbGood.setToped(01);
        wxbGood.setRecomed(10);
        wxbGood.setTopedTime(timestamp);
        wxbGood.setRecomedTime(timestamp);
        wxbGood.setSpcId("站内文案ID");
        wxbGood.setZonId("空间文案ID");
        wxbGood.setSellNum(0);
        wxbGood.setWebsite("产品网址");
        wxbGood.setIswxpay(0);
        wxbGood.setIsfdfk(0);
        wxbGood.setLeixingId(0);
        wxbGood.setKfqq("0");
        IGoodsService goodsService = new GoodsServiceImpl();
        goodsService.insertGoodsAndGoodsSku(wxbGood);
        //-----------------------------------------------------------
        IGoodsSkuService goodsSkuService = new GoodsSkuServiceImpl();
        Random random = new Random();
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        StringBuilder str3=new StringBuilder();
        String s1 = null;
        String s2 = null;
        String s3 = null;
        for(int i=0;i<8;i++) {
            s1 = "" + str1.append(random.nextInt(10));
            s2 = "" + str2.append(random.nextInt(10));
            s3 = "" + str3.append(random.nextInt(10));
        }
        //添加商品-套餐1
        WxbGoodSku wxbGoodSku1 = new WxbGoodSku();
        wxbGoodSku1.setSkuId(s1);
        wxbGoodSku1.setSkuName("套餐名称01");
        wxbGoodSku1.setSkuCost("成本");
        wxbGoodSku1.setSkuPrice("价格");
        wxbGoodSku1.setSkuPmoney("分成");
        wxbGoodSku1.setGoodId(wxbGood.getGoodId());
        wxbGoodSku1.setOrderNo(000);
        wxbGoodSku1.setServiceMoney("客服提成");
        goodsSkuService.insertGoodsSku(wxbGoodSku1);
        //添加商品-套餐2
        WxbGoodSku wxbGoodSku2 = new WxbGoodSku();
        wxbGoodSku2.setSkuId(s2);
        wxbGoodSku2.setSkuName("套餐名称02");
        wxbGoodSku2.setSkuCost("成本");
        wxbGoodSku2.setSkuPrice("价格");
        wxbGoodSku2.setSkuPmoney("分成");
        wxbGoodSku2.setGoodId(wxbGood.getGoodId());
        wxbGoodSku2.setOrderNo(000);
        wxbGoodSku2.setServiceMoney("客服提成");
        goodsSkuService.insertGoodsSku(wxbGoodSku2);
        //添加商品-套餐3
        WxbGoodSku wxbGoodSku3 = new WxbGoodSku();
        wxbGoodSku3.setSkuId(s3);
        wxbGoodSku3.setSkuName("套餐名称03");
        wxbGoodSku3.setSkuCost("成本");
        wxbGoodSku3.setSkuPrice("价格");
        wxbGoodSku3.setSkuPmoney("分成");
        wxbGoodSku3.setGoodId(wxbGood.getGoodId());
        wxbGoodSku3.setOrderNo(000);
        wxbGoodSku3.setServiceMoney("客服提成");
        goodsSkuService.insertGoodsSku(wxbGoodSku3);
//        sqlSession.commit();
//        sqlSession.close();
    }
}
