package com.bawei.zhangjiafu37.utlis;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.zhangjiafu37.R;
import com.bawei.zhangjiafu37.entity.ListEntity;
import com.bawei.zhangjiafu37.view.fragment.Login_Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class MyRecy extends RecyclerView.Adapter<MyRecy.MyHoder>{
    Context context;
    List<ListEntity.resule> list;

    public MyRecy(Context context, List<ListEntity.resule> resules) {
        this.context=context;
        this.list=resules;
    }


    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.listlayout, null);
        MyHoder myHoder = new MyHoder(inflate);
        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        Glide.with(context).load(list.get(position).getMasterPic())
                .error(R.mipmap.ic_launcher_round)
                .apply(new RequestOptions().transform(new CircleCrop()))
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.image);
        holder.name.setText(list.get(position).getCommodityName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.success();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHoder extends RecyclerView.ViewHolder {
       TextView name;
       ImageView image;
       public MyHoder(@NonNull View itemView) {
           super(itemView);
          image =  itemView.findViewById(R.id.list_image);
           name = itemView.findViewById(R.id.list_text);
       }
   }
   CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack{
        void success();
   }
}
