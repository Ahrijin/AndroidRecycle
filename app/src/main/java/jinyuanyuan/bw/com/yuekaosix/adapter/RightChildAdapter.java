package jinyuanyuan.bw.com.yuekaosix.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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
 *Date:2019/1/20
 */public class RightChildAdapter extends RecyclerView.Adapter<RightChildAdapter.ViewHolder> {
    private List<RightData.DataBean.ListBean> rightList;
    private Context context;

    public RightChildAdapter(List<RightData.DataBean.ListBean> rightList, Context context) {
        this.rightList = rightList;
        this.context = context;
    }

    @NonNull
    @Override
    public RightChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_child_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightChildAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(rightList.get(i).getIcon()).into(viewHolder.imgs);
        viewHolder.title.setText(rightList.get(i).getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("pscid", rightList.get(i).getPscid() + "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgs;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.right_imgs);
            title = itemView.findViewById(R.id.child_title);
        }
    }
}
