package com.gu.cheng.imagecache.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gu.cheng.imagecache.R;
import com.gu.cheng.imagecache.base.ViewHolder;
import com.gu.cheng.imagecache.util.ImageLoader2;

import java.util.List;


/**
 * Created by gc on 2017/9/9.
 * 图片适配器
 */
public class ImageAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<String> mUrlList;
    private Context mContext;

    public ImageAdapter(Context context ,List<String> urlList) {
        this.mContext = context;
        this.mUrlList = urlList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.createViewHolder(parent.getContext(),parent, R.layout.item_image);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageView imageView = holder.getView(R.id.id_iv_image);
        String url = mUrlList.get(position);
        ImageLoader2.getInstance().loadImage2Cache(mContext,url,imageView);
    }

    @Override
    public int getItemCount() {
        return mUrlList == null? 0 : mUrlList.size();
    }
}
