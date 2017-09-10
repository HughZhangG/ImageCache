package com.gu.cheng.imagecache.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.LruCache;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gu.cheng.imagecache.R;

/**
 * Created by gc on 2017/9/9.
 * Net
 */
public class ImageLoader2 {

    private static final String CACHE_PATH =
            Environment.getDownloadCacheDirectory() + "/images";

    private static ImageLoader2 mInstance;
    /**
     * 图片缓存核心对象
     */
    private LruCache<String,Bitmap> mLruCache;
    private RequestOptions options;

    private ImageLoader2(){
        init();
    }

    public static ImageLoader2 getInstance(){
        if (mInstance == null) {
            synchronized (ImageLoader2.class){
                if (mInstance == null) {
                    mInstance = new ImageLoader2();
                }
            }
        }
        return mInstance;
    }


    /**
     *
     */
    private void init() {
        /**
         * 应用最大内存
         */
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        int cacheMemory = (int) (maxMemory / 8);
//        mLruCache = new LruCache<String, Bitmap>(cacheMemory){
//            @Override
//            protected int sizeOf(String key, Bitmap value) {
//                //每一行占用字节数 *　高度
//                return value.getRowBytes() * value.getHeight();
//            }
//        };

        options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)  //设置磁盘缓存策略
                .error(R.drawable.defualt)
                .priority(Priority.HIGH);
    }


    /**
     * 加载图片并
     * @param context
     */
    public void loadImage2Cache(Context context, final String path, final ImageView iv){


//        Bitmap bitmapFromLocal = LocalCacheUtils.getBitmapFromLocal(path);
//
//        if (bitmapFromLocal != null){
//            iv.setImageBitmap(bitmapFromLocal);
//            return;
//        }


//        if (!NetUtil.isNetworkAvailable(context)){
//            Glide.with(context).load(R.drawable.defualt).into(iv);
//            return;
//        }

        Glide.with(context)
                .asBitmap()
                .load(path)
                .apply(options)
                .into(iv);
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
////                        LocalCacheUtils.setBitmapToLocal(path,bitmap);
//
//                        iv.setImageBitmap(bitmap);
//                    }
//                });


    }
}
