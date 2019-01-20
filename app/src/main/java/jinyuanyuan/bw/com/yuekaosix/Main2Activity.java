package jinyuanyuan.bw.com.yuekaosix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import jinyuanyuan.bw.com.yuekaosix.adapter.MyAdapter;
import jinyuanyuan.bw.com.yuekaosix.bean.MyData;
import jinyuanyuan.bw.com.yuekaosix.presenter.PresenterImpls;
import jinyuanyuan.bw.com.yuekaosix.utils.Contacts;
import jinyuanyuan.bw.com.yuekaosix.view.IView;

public class Main2Activity extends AppCompatActivity implements IView {
    @BindView(R.id.recys)
    RecyclerView recys;
    private MyAdapter adapter;
    private PresenterImpls presenterImpls;
    private List<MyData.DataBean> homeList = new ArrayList<>();
    private Map<String, Object> map = new HashMap<>();
    private String pscid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        pscid = intent.getStringExtra("pscid");
        Toast.makeText(this, pscid+"hehe", Toast.LENGTH_SHORT).show();
        map.put("pscid", pscid);

        //管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recys.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(homeList, this);
        recys.setAdapter(adapter);

        presenterImpls = new PresenterImpls(this);
        presenterImpls.getRequest(Contacts.GOODS_URL, map, MyData.class);
    }

    @Override
    public void Success(Object daa) {
        MyData myData = (MyData) daa;
        Log.e("aaa", myData.toString());
        homeList.addAll(myData.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Error(Object err) {
        Log.e("errors", err.toString());
    }
}
