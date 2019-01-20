package jinyuanyuan.bw.com.yuekaosix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jinyuanyuan.bw.com.yuekaosix.fragment.FenLeiFragment;
import jinyuanyuan.bw.com.yuekaosix.fragment.HomeFragment;
import jinyuanyuan.bw.com.yuekaosix.fragment.MiMeFragment;
import jinyuanyuan.bw.com.yuekaosix.fragment.MyFragment;
import jinyuanyuan.bw.com.yuekaosix.fragment.ShopCartFragment;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
    }


    @OnClick({R.id.home, R.id.fenl, R.id.memi, R.id.card, R.id.my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                manager.beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                break;
            case R.id.fenl:
                manager.beginTransaction().replace(R.id.frame_layout, new FenLeiFragment()).commit();
                break;
            case R.id.memi:
                manager.beginTransaction().replace(R.id.frame_layout, new MiMeFragment()).commit();
                break;
            case R.id.card:
                manager.beginTransaction().replace(R.id.frame_layout, new ShopCartFragment()).commit();
                break;
            case R.id.my:
                manager.beginTransaction().replace(R.id.frame_layout, new MyFragment()).commit();
                break;
        }
    }
}
