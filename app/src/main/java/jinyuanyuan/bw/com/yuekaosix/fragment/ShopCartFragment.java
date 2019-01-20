package jinyuanyuan.bw.com.yuekaosix.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jinyuanyuan.bw.com.yuekaosix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCartFragment extends Fragment {


    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_shop_cart, container, false);
        return v;
    }

}
