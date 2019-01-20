package jinyuanyuan.bw.com.yuekaosix.model;

import java.util.Map;

import jinyuanyuan.bw.com.yuekaosix.callback.MyCallBack;

/*
 *Author:Ahri_Love
 *Date:2019/1/14
 */public interface Model {
     void get(String url, Map<String,Object> map, Class clazz, MyCallBack callBack);

    void post(String url, Map<String, Object> map, Class clazz, MyCallBack callBack);
}
