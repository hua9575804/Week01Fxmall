package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.service.IGoodsService;
import com.qianfeng.fxmall.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GoodsServlet extends BaseServlet {

    private IGoodsService goodsService = new GoodsServiceImpl();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pageStr = req.getParameter("page");
//        try {
//            pageStr = pageStr == null ? "1" : pageStr;
//            List<WxbGood> wxbGoods = goodsService.queryGoodsByPage(Integer.parseInt(pageStr));
//            req.setAttribute("goodsList",wxbGoods);
////            for (WxbGood wxbGood:wxbGoods) {
////                System.out.println("数据库---------------" + wxbGood);
////            }
//            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//            //不能处理跳转到错误提示页面
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    /**
     * 分页查询
     * @param req
     * @param resp
     */
    public void queryGoodsByPage(HttpServletRequest req, HttpServletResponse resp){
                String pageStr = req.getParameter("page");
        try {
            pageStr = pageStr == null ? "1" : pageStr;
            List<WxbGood> wxbGoods = goodsService.queryGoodsByPage(Integer.parseInt(pageStr));
            req.setAttribute("goodsList",wxbGoods);
//            for (WxbGood wxbGood:wxbGoods) {
//                System.out.println("数据库---------------" + wxbGood);
//            }
            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            //不能处理跳转到错误提示页面
        }
    }

    /**
     * 增加商品
     * @param req
     * @param resp
     */
    public void insertGoodsAndGoodSku(HttpServletRequest req,HttpServletResponse resp){
        String good_name = req.getParameter("good_name");
        System.out.println("商品名称"+good_name);
        String type_id = req.getParameter("type_id");//商品类型
        System.out.println("商品类型id"+type_id);
        String order_no = req.getParameter("order_no");
        String sell_num = req.getParameter("sell_num");
        req.getParameter("");//图片
        req.getParameter("");//图片
        req.getParameter("");//图片
        String promote_desc = req.getParameter("promote_desc");
        req.getParameter("");//商品套餐
        String tags = req.getParameter("tags");//商品标签
        System.out.println("商品标签id"+tags);
        String gcopy = req.getParameter("gcopy");//微信文案
        System.out.println("微信文案"+gcopy);
//        req.getParameter("");//站内文案
        String zcopy_id = req.getParameter("zcopy_id");//空间文案
        System.out.println("空间文案"+zcopy_id);
        String copy_desc = req.getParameter("copy_desc");//跳转说明
        String forward_link = req.getParameter("forward_link");//跳转地址
        //jsp内图片空值
        String good_pic = req.getParameter("good_pic");//图片
        String good_pic1 = req.getParameter("good_pic1");//图片
        String good_pic2 = req.getParameter("good_pic2");//图片
        String sku1 = req.getParameter("sku1");//套餐
        String cb1 = req.getParameter("cb1");
        String jg1 = req.getParameter("jg1");
        String fc1 = req.getParameter("fc1");
        String kffc1 = req.getParameter("kffc1");
        System.out.println("------------------"+sku1);
        System.out.println("------------------"+kffc1);
        //hidden影藏值
        String sku_str = req.getParameter("sku_str");
        String ctype = req.getParameter("ctype");
        String sku_title = req.getParameter("sku_title");
        String sku_cost = req.getParameter("sku_cost");
        String sku_pmoney = req.getParameter("sku_pmoney");
        String service_money = req.getParameter("service_money");
        String sku_price = req.getParameter("sku_price");
//        String good_id = req.getParameter("good_id");//UUID生成
        String copy_id = req.getParameter("copy_id");
        String spc_id = req.getParameter("spc_id");
        String zon_id = req.getParameter("zon_id");
        String optype = req.getParameter("optype");
        String iswxpay = req.getParameter("iswxpay");
        String customer_id = req.getParameter("customer_id");
        //默认值

//        //新增商品
//        String goodId = UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
//        Date date = new Date();
//        Timestamp timestamp = new Timestamp(date.getTime());//create_time+toped_time+recomed_time
//        WxbGood wxbGood = new WxbGood(goodId,good_name,customer_id,good_pic,good_pic1,good_pic2,promote_desc,sku_title,
//                sku_cost,sku_price,sku_pmoney,copy_ids,copy_desc,forward_link,order_no,type_id,tags,state,timestamp,
//                toped,recomed,timestamp,timestamp,spc_id,zon_id,sell_num,website,iswxpay,isfdfk,leixing_id,kfqq);
//        //新增套餐
//        WxbGoodSku wxbGoodSku = new WxbGoodSku(sku_id,sku1,sku_cost,sku_price,sku_pmoney,wxbGood.getGoodId(),order_no,service_money);
    }
}
