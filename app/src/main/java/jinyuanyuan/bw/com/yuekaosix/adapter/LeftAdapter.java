package jinyuanyuan.bw.com.yuekaosix.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.bean.LeftData;

/*
 *Author:Ahri_Love
 *Date:2019/1/15
 */public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private List<LeftData.DataBean> mLists;
    private Context context;

    public LeftAdapter(List<LeftData.DataBean> mLists, Context context) {
        this.mLists = mLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.titls.setText(mLists.get(i).getName() + "");
        viewHolder.titls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftHttpLisetener!=null){
                    leftHttpLisetener.setItemClick(v,i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titls;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titls = itemView.findViewById(R.id.left_title);
        }
    }


    public interface LeftHttpLisetener {
        void setItemClick(View view, int position);
    }

    private LeftHttpLisetener leftHttpLisetener;

    public void setLeftHttpLisetener(LeftHttpLisetener leftHttpLisetener) {
        this.leftHttpLisetener = leftHttpLisetener;
    }
}
