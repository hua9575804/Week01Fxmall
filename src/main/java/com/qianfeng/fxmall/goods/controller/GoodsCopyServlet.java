package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.bean.WxbGoodCopy;
import com.qianfeng.fxmall.service.IGoodsCopyService;
import com.qianfeng.fxmall.service.impl.GoodsCopyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsCopyServlet extends HttpServlet {

    private IGoodsCopyService goodsCopyService = new GoodsCopyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        try {
            pageStr = pageStr == null ? "1" : pageStr;
            List<WxbGoodCopy> wxbGoodCopies  = goodsCopyService.queryWxbGoodsCopyByPage(Integer.parseInt(pageStr));
            req.setAttribute("goodsCopyList",wxbGoodCopies);
            req.getRequestDispatcher("goodsCopy_list.jsp").forward(req,resp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
