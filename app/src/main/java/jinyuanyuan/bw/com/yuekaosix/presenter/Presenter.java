package jinyuanyuan.bw.com.yuekaosix.presenter;

import java.util.Map;

/*
 *Author:Ahri_Love
 *Date:2019/1/14
 */public interface Presenter {
     void getRequest(String url, Map<String,Object> map, Class clazz);
     void postRequest(String url, Map<String,Object> map, Class clazz);
}
