package jinyuanyuan.bw.com.yuekaosix.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.adapter.MyAdapter;
import jinyuanyuan.bw.com.yuekaosix.bean.MyData;
import jinyuanyuan.bw.com.yuekaosix.presenter.PresenterImpls;
import jinyuanyuan.bw.com.yuekaosix.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IView {


    @BindView(R.id.recy)
    RecyclerView recy;
    Unbinder unbinder;
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(Object daa) {

    }

    @Override
    public void Error(Object err) {

    }
}
