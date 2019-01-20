package jinyuanyuan.bw.com.yuekaosix.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jinyuanyuan.bw.com.yuekaosix.Main2Activity;
import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.bean.RightData;

/*
 *Author:Ahri_Love
 *Date:2019/1/17
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private List<RightData.DataBean> rightList;
    private Context context;

    public RightAdapter(List<RightData.DataBean> rightList, Context context) {
        this.rightList = rightList;
        this.context = context;
    }

    @NonNull
    @Override
    public RightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(rightList.get(i).getName());
        viewHolder.recy.setLayoutManager(new GridLayoutManager(context, 3));
        viewHolder.recy.setAdapter(new RightChildAdapter(rightList.get(i).getList(), context));
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RecyclerView recy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.right_title);
            recy = itemView.findViewById(R.id.child_recy);
        }
    }
}
