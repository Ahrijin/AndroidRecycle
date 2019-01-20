package jinyuanyuan.bw.com.yuekaosix.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.bean.RightData;

/*
 *Author:Ahri_Love
 *Date:2019/1/17
 */public class RightTitleAdapter extends RecyclerView.Adapter<RightTitleAdapter.ViewHolder> {
    private List<RightData.DataBean> rightList;
    private Context context;

    public RightTitleAdapter(List<RightData.DataBean> rightList, Context context) {
        this.rightList = rightList;
        this.context = context;
    }

    @NonNull
    @Override
    public RightTitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_title, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(rightList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.right_titles);
        }
    }
}
