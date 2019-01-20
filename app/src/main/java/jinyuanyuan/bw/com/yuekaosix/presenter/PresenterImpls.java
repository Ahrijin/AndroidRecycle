package jinyuanyuan.bw.com.yuekaosix.presenter;

import com.google.gson.Gson;

import java.util.Map;

import jinyuanyuan.bw.com.yuekaosix.callback.MyCallBack;
import jinyuanyuan.bw.com.yuekaosix.model.ModelImpls;
import jinyuanyuan.bw.com.yuekaosix.view.IView;

/*
 *Author:Ahri_Love
 *Date:2019/1/14
 */public class PresenterImpls implements Presenter {
     private IView iView;
     private ModelImpls modelImpls;

    public PresenterImpls(IView iView) {
        this.iView = iView;
        modelImpls = new ModelImpls();
    }

    @Override
    public void getRequest(String url, Map<String, Object> map, Class clazz) {
        modelImpls.get(url, map, clazz, new MyCallBack() {
            @Override
            public void setSuceess(Object suceess) {
                iView.Success(suceess);
            }

            @Override
            public void setError(Object error) {
                iView.Error(error);
            }
        });
    }

    @Override
    public void postRequest(String url, Map<String, Object> map, Class clazz) {
        modelImpls.post(url, map, clazz, new MyCallBack() {
            @Override
            public void setSuceess(Object suceess) {
                iView.Success(suceess);
            }

            @Override
            public void setError(Object error) {
                iView.Error(error);
            }
        });
    }

    public void destory(){
        if(iView!=null){
            iView = null;
        }
        if (modelImpls!=null){
            modelImpls = null;
        }
    }
}
