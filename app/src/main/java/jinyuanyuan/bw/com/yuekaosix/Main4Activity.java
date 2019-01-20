package jinyuanyuan.bw.com.yuekaosix;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jinyuanyuan.bw.com.yuekaosix.bean.ImageBean;
import jinyuanyuan.bw.com.yuekaosix.presenter.PresenterImpls;
import jinyuanyuan.bw.com.yuekaosix.utils.Contacts;
import jinyuanyuan.bw.com.yuekaosix.view.IView;

public class Main4Activity extends AppCompatActivity implements IView {
    private ViewPager view_page;
    private String url = "http://www.zhaoapi.cn/ad/getAd";
    private ViewPage adapter;
    private List<View> pic = new ArrayList<>();
    private List<String> imgArray = new ArrayList<>();
    private Button start;
    Map<String ,Object> map =  new HashMap<>();
    PresenterImpls presenterImpls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();//查找控件
        adapter = new ViewPage();
        presenterImpls = new PresenterImpls(this);
        presenterImpls.getRequest(Contacts.GETAD_URL,map,ImageBean.class);
    }
    private void initView() {
        view_page = (ViewPager) findViewById(R.id.view_page);

        LayoutInflater inflater = LayoutInflater.from(this);
        View one = inflater.inflate(R.layout.one, null);
        View two = inflater.inflate(R.layout.two, null);
        View three = inflater.inflate(R.layout.three, null);
        View four = inflater.inflate(R.layout.four, null);
        //在第四个视图查找控件
        start = four.findViewById(R.id.start_shopping);
        pic.add(one);
        pic.add(two);
        pic.add(three);
        pic.add(four);

    }

    @Override
    public void Success(Object daa) {
        ImageBean imageBean = (ImageBean) daa;
        for (int i = 0; i < imageBean.getData().size(); i++) {
            imgArray.add(imageBean.getData().get(i).getIcon());
        }
        view_page.setAdapter(adapter);
    }

    @Override
    public void Error(Object err) {

    }

    class ViewPage extends PagerAdapter {

        @Override
        public int getCount() {
            return pic.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(pic.get(position));
            View view = pic.get(position);
            ImageView img = view.findViewById(R.id.img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(Main4Activity.this).load(imgArray.get(position)).into(img);
            return pic.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}
