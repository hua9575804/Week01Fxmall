package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.service.IGoodsService;
import com.qianfeng.fxmall.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {

    private IGoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
