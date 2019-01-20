package jinyuanyuan.bw.com.yuekaosix.model;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

import jinyuanyuan.bw.com.yuekaosix.callback.MyCallBack;
import jinyuanyuan.bw.com.yuekaosix.utils.RetrofitUtils;

/*
 *Author:Ahri_Love
 *Date:2019/1/14
 */public class ModelImpls implements Model {
    @Override
    public void get(String url, Map<String, Object> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void setSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object o = gson.fromJson(jsonStr, clazz);
                callBack.setSuceess(o);
                Log.e("model",o.toString());
            }

            @Override
            public void setError(String error) {
                callBack.setError(error);
            }
        });
    }

    @Override
    public void post(String url, Map<String, Object> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().post(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void setSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object o = gson.fromJson(jsonStr, clazz);
                callBack.setSuceess(o);
            }

            @Override
            public void setError(String error) {
                callBack.setError(error);
            }
        });
    }
}
