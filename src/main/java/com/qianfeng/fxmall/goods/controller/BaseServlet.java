package com.qianfeng.fxmall.goods.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        // 通过反射获得方法名
        String m = req.getParameter("m");
        try {
            // 获得方法
            Method method = getClass().getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println("开始执行方法:" + m);
            // 调用方法
            method.invoke(this, req, resp);
            System.out.println("结束方法:" + m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
