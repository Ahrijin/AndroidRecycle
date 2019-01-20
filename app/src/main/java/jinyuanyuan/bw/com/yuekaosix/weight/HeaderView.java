package jinyuanyuan.bw.com.yuekaosix.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import jinyuanyuan.bw.com.yuekaosix.R;

/*
 *Author:Ahri_Love
 *Date:2019/1/15
 */public class HeaderView extends LinearLayout {

    private final TextView quxiao;
    private final EditText search;

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.head_view, this);
        search = findViewById(R.id.search_edit);
        quxiao = findViewById(R.id.quxiao);

    }

    //返回搜索的内容
    public String  getSearchContent(){
        return search.getText().toString().trim();
    }

    //
    public TextView getQuxiao(){
        return quxiao;
    }
}
