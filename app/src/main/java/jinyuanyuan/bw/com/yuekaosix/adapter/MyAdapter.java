package jinyuanyuan.bw.com.yuekaosix.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URI;
import java.util.List;

import jinyuanyuan.bw.com.yuekaosix.Main2Activity;
import jinyuanyuan.bw.com.yuekaosix.Main3Activity;
import jinyuanyuan.bw.com.yuekaosix.MainActivity;
import jinyuanyuan.bw.com.yuekaosix.R;
import jinyuanyuan.bw.com.yuekaosix.bean.MyData;

/*
 *Author:Ahri_Love
 *Date:2019/1/17
 */public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyData.DataBean> homeList;
    private Context context;

    public MyAdapter(List<MyData.DataBean> homeList, Context context) {
        this.homeList = homeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder,final int i) {
        String images = homeList.get(i).getImages();
        String replace = images.replace("https", "http");
        String[] splits = replace.split("\\|");
        Uri uri = Uri.parse(splits[0]);
        viewHolder.imgs.setImageURI(uri);//Freso图片加载，需要相应的控件进行加载
        //Glide.with(context).load(splits[0]).into(viewHolder.imgs);
        viewHolder.price.setText("￥"+homeList.get(i).getPrice());
        viewHolder.titls.setText(homeList.get(i).getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detailUrl = homeList.get(i).getDetailUrl();
                Intent intent = new Intent(context,Main3Activity.class);
                intent.putExtra("url",detailUrl+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgs;
        private TextView titls;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           imgs = itemView.findViewById(R.id.list_imgs);
           titls = itemView.findViewById(R.id.list_title);
           price = itemView.findViewById(R.id.list_price);
        }
    }
}
