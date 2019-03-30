package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.info.SystemConstatsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.service.IGoodsService;
import com.qianfeng.fxmall.service.IGoodsSkuService;
import com.qianfeng.fxmall.service.impl.GoodsServiceImpl;
import com.qianfeng.fxmall.service.impl.GoodsSkuServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
    public void insertGoodsAndGoodSku(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String good_name = req.getParameter("good_name");
//        System.out.println("商品名称"+good_name);
        String type_id = req.getParameter("type_id");//商品类型
//        System.out.println("商品类型id"+type_id);
        int order_no = Integer.parseInt(req.getParameter("order_no"));
        int sell_num = Integer.parseInt(req.getParameter("sell_num"));
        req.getParameter("");//图片
        req.getParameter("");//图片
        req.getParameter("");//图片
        String promote_desc = req.getParameter("promote_desc");
        req.getParameter("");//商品套餐
        String tags = req.getParameter("tags");//商品标签
//        System.out.println("商品标签id"+tags);
        String gcopy = req.getParameter("gcopy");//微信文案
//        System.out.println("微信文案"+gcopy);
//        req.getParameter("");//站内文案，无效
        String zcopy_id = req.getParameter("zcopy_id");//空间文案
//        System.out.println("空间文案"+zcopy_id);
        String copy_desc = req.getParameter("copy_desc");//跳转说明
        String forward_link = req.getParameter("forward_link");//跳转地址
        //jsp内图片空值
        String good_pic = req.getParameter("good_pic");//图片
        String good_pic1 = req.getParameter("good_pic1");//图片
        String good_pic2 = req.getParameter("good_pic2");//图片
        String pic ="image.jsp";
        String sku1 = req.getParameter("sku1");//套餐1
        System.out.println("套餐1---------------------"+ sku1);
        String cb1 = req.getParameter("cb1");
        String jg1 = req.getParameter("jg1");
        String fc1 = req.getParameter("fc1");
        String sku2 = req.getParameter("sku2");//套餐2
        System.out.println("套餐2---------------------"+ sku2);
        String cb2 = req.getParameter("cb2");
        String jg2 = req.getParameter("jg2");
        String fc2 = req.getParameter("fc2");
        String sku3 = req.getParameter("sku3");//套餐3
        String cb3 = req.getParameter("cb3");
        String jg3 = req.getParameter("jg3");
        String fc3 = req.getParameter("fc3");
        String sku4 = req.getParameter("sku4");//套餐4
        String cb4 = req.getParameter("cb4");
        String jg4 = req.getParameter("jg4");
        String fc4 = req.getParameter("fc4");

        String kffc1 = req.getParameter("kffc1");
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
        int iswxpay = Integer.parseInt(req.getParameter("iswxpay"));
        String customer_id = req.getParameter("customer_id");
        //默认值
        int defaultNum = 0;//isfdfk + leixing_id + state + toped + recomed + copy_ids
        String defaultStr = "0";//kfqq
        String defuultUrl = "www.abc";//website
        //新增商品
        String goodId = UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());//create_time+toped_time+recomed_time
        WxbGood wxbGood = new WxbGood(goodId,good_name,customer_id,pic,pic,pic,promote_desc,sku_title,
                sku_cost,sku_price,sku_pmoney,defaultStr,copy_desc,forward_link,order_no,type_id,tags,defaultNum,timestamp,
                defaultNum,defaultNum,timestamp,timestamp,spc_id,zcopy_id,sell_num,defuultUrl,iswxpay,defaultNum,defaultNum,defaultStr);
        System.out.println("--------------新增商品----------------------");
//        goodsService.insertGoodsAndGoodsSku(wxbGood);
        //新增套餐
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
//        String row = req.getParameter("k");
//        System.out.println("----------行----------"+ row);
        WxbGoodSku wxbGoodSku1 = new WxbGoodSku(s1,sku1,cb1,jg1,fc1,wxbGood.getGoodId(),order_no,service_money);
//        goodsSkuService.insertGoodsSku(wxbGoodSku1);
        WxbGoodSku wxbGoodSku2 = new WxbGoodSku(s2,sku2,cb2,jg2,fc2,wxbGood.getGoodId(),order_no,service_money);
//        goodsSkuService.insertGoodsSku(wxbGoodSku2);
        WxbGoodSku wxbGoodSku3 = new WxbGoodSku(s3,sku3,cb3,jg3,fc3,wxbGood.getGoodId(),order_no,service_money);
//        goodsSkuService.insertGoodsSku(wxbGoodSku3);
        req.getRequestDispatcher("goods.do?m=queryGoodsByPage").forward(req,resp);
    }
    /**
     *特殊表单
     */
    public void insertGoodsAndGoodSku2(HttpServletRequest req,HttpServletResponse resp){
        if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload upload = new ServletFileUpload();//创建文件上传对象
            upload.setFileSizeMax(10 * 1024 *1024);
            WxbGood wxbGood = new WxbGood();
            try {
                FileItemIterator itr = upload.getItemIterator(req);//获取表单迭代器
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {//判断是否是一般表单项
                        String value = Streams.asString(item.openStream(),"UTF-8");//读取表单的值
                        switch(item.getFieldName()){
                            case "good_name" :
                                wxbGood.setGoodName(value);
                                break;
                            case "type_id" :
                                wxbGood.setTypeId(value);
                                break;
                            case "order_no" :
                                wxbGood.setOrderNo(Integer.parseInt(value));
                                break;
                            case "sell_num" :
                                wxbGood.setSellNum(Integer.parseInt(value));
                                break;
                            case "promote_desc" :
                                wxbGood.setPromoteDesc(value);
                                break;
                            case "tags" :
                                wxbGood.setTags(value);
                                break;
                            case "copy_desc" :
                                wxbGood.setCopyDesc(value);
                                break;
                            case "forward_link" :
                                wxbGood.setForwardLink(value);
                                break;
                            case "spc_id" :
                                wxbGood.setSpcId(value);
                                break;
                            case "zcopy_id" :
                                wxbGood.setZonId(value);
                                break;
                        }
                    }else{
                        //获得文件名、进行处理
                        String filename = item.getName();
//                        System.out.println("--------------------------------------"+filename);
                        if (filename != null && filename.length() > 0) {
                            String filename2 = UUID.randomUUID().toString()+ (filename.substring(filename.lastIndexOf(".")));
                            //保存新的文件名、用于写入数据库
                            wxbGood.setGoodPic(filename2);
                            filename = SystemConstatsUtils.UPLOAD_PATH + filename2;
                            //创建文件输出流
                            FileOutputStream out = new FileOutputStream(filename);
                            //读取上传文件流、写入文件
                            Streams.copy(item.openStream(), out, true);
                        }
                    }
                }
                String goodId = UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                wxbGood.setGoodId(goodId);
                wxbGood.setCustomerId("商户ID");
//                wxbGood.setGoodPic("E:\\java_advanced\\workspace\\MerchantSystem");
                wxbGood.setGoodPic1("E:\\java_advanced\\workspace\\MerchantSystem");
                wxbGood.setGoodPic2("E:\\java_advanced\\workspace\\MerchantSystem");
//                wxbGood.setPromoteDesc("推广说明");
                wxbGood.setSkuTitle("sku描述");
                wxbGood.setSkuCost("成本");
                wxbGood.setSkuPrice("价格");
                wxbGood.setSkuPmoney("分成");
                wxbGood.setCopyIds("文案ID");
                wxbGood.setCopyDesc("文案说明");
//                wxbGood.setForwardLink("跳转链接");
//                wxbGood.setOrderNo(001);
//                wxbGood.setTypeId("商品分类");
//                wxbGood.setTags("标签信息");
                wxbGood.setState(012);
                wxbGood.setCreateTime(timestamp);
                wxbGood.setToped(01);
                wxbGood.setRecomed(10);
                wxbGood.setTopedTime(timestamp);
                wxbGood.setRecomedTime(timestamp);
//                wxbGood.setSpcId("站内文案ID");
//                wxbGood.setZonId("空间文案ID");
                wxbGood.setSellNum(0);
                wxbGood.setWebsite("产品网址");
                wxbGood.setIswxpay(0);
                wxbGood.setIsfdfk(0);
                wxbGood.setLeixingId(0);
                wxbGood.setKfqq("0");
                goodsService.insertGoodsAndGoodsSku(wxbGood);
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
