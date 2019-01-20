package jinyuanyuan.bw.com.yuekaosix.utils;

/*
 *Author:Ahri_Love
 *Date:2019/1/14
 */public class Contacts {

    public static final String BASE_URL = "http://www.zhaoapi.cn/";
    //1.一级分类接口
    public static final String FIRST_URL  = "product/getCatagory";

    //2.二级分类接口   请求参数：cid :一级分类中返回的cid
    public static final String SECOND_URL = "product/getProductCatagory";

    //3. 商品列表页面  请求参数：pscid:商品二级分类id 如pscid=40
    public static final String GOODS_URL = "product/getProducts";

    //4.加入购物车接口  请求参数：uid:用户id，默认71，建议使用个人uid  pid：商品id
    public static final String ADD_SHOP_CARD_URL = "product/addCart";

    //5.查询购物车数据接口  请求参数： uid：用户id
    public static final String SELECT_SHOP_URL = "product/getCarts";

    //引导页
    public static final String GETAD_URL ="ad/getAd";
 }
