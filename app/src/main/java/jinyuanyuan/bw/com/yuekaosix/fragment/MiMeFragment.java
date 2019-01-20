package jinyuanyuan.bw.com.yuekaosix.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jinyuanyuan.bw.com.yuekaosix.Main2Activity;
import jinyuanyuan.bw.com.yuekaosix.Main4Activity;
import jinyuanyuan.bw.com.yuekaosix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiMeFragment extends Fragment {


    @BindView(R.id.btnss)
    Button btnss;
    Unbinder unbinder;
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_mi_me, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnss)
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.btnss:
                startActivity(new Intent(getActivity(),Main4Activity.class));
                break;
        }
    }
}
