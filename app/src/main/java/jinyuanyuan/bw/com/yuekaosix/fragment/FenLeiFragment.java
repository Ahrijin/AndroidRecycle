package jinyuanyuan.bw.com.yuekaosix.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.adapter.LeftAdapter;
import jinyuanyuan.bw.com.yuekaosix.adapter.RightAdapter;
import jinyuanyuan.bw.com.yuekaosix.adapter.RightTitleAdapter;
import jinyuanyuan.bw.com.yuekaosix.bean.LeftData;
import jinyuanyuan.bw.com.yuekaosix.bean.RightData;
import jinyuanyuan.bw.com.yuekaosix.presenter.PresenterImpls;
import jinyuanyuan.bw.com.yuekaosix.utils.Contacts;
import jinyuanyuan.bw.com.yuekaosix.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenLeiFragment extends Fragment implements IView {


    @BindView(R.id.top_imgs1)
    ImageView topImgs1;
    @BindView(R.id.top_edit)
    EditText topEdit;
    @BindView(R.id.top_imgs2)
    ImageView topImgs2;
    @BindView(R.id.rv_sort_left)
    RecyclerView rvSortLeft;
    @BindView(R.id.rv_sort_right)
    RecyclerView rvSortRight;
    Unbinder unbinder;
    private View v;
    private PresenterImpls presenterImpls;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private List<LeftData.DataBean> leftmLists = new ArrayList<>();
    private List<RightData.DataBean> rightmLists = new ArrayList<>();
    private Map<String, Object> map = new HashMap<>();
    private Map<String, Object> maps = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fen_lei, container, false);
        unbinder = ButterKnife.bind(this, v);
        //左边的布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvSortLeft.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 =  new LinearLayoutManager(getActivity());
        rvSortRight.setLayoutManager(linearLayoutManager1);
        //适配器
        leftAdapter = new LeftAdapter(leftmLists, getActivity());
        rvSortLeft.setAdapter(leftAdapter);

        //请求数据
        presenterImpls = new PresenterImpls(this);
        presenterImpls.getRequest(Contacts.FIRST_URL,map,LeftData.class);

        listener();

        return v;
    }

    private void listener() {
        leftAdapter.setLeftHttpLisetener(new LeftAdapter.LeftHttpLisetener() {
            @Override
            public void setItemClick(View view, int position) {

                maps.put("cid",position);
                presenterImpls.getRequest(Contacts.SECOND_URL,maps,RightData.class );
                rightAdapter = new RightAdapter(rightmLists,getActivity());
                rvSortRight.setAdapter(rightAdapter);

            }
        });
    }

    @OnClick(R.id.top_imgs1)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.top_imgs1:

                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(Object daa) {
        if (daa instanceof LeftData){
            LeftData leftData = (LeftData) daa;
            leftmLists.addAll(leftData.getData());
            leftAdapter.notifyDataSetChanged();
        }

        if(daa instanceof RightData){
            rightmLists.clear();
            RightData rightData = (RightData) daa;
            rightmLists.addAll(rightData.getData());
            rightAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void Error(Object err) {

    }
}
