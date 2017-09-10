package com.gu.cheng.imagecache.glide;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by gc on 2017/9/10.
 * 磁盘缓存
 */
public class DiskCacheModule implements GlideModule {

    /**
     * @param context
     * @param glideBuilder
     *
     * 设置缓存路径
     *
     */
    @Override
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        int cacheMemory = (int) (maxMemory / 8);
        glideBuilder.setDiskCache(new InternalCacheDiskCacheFactory(context, "images", 100 * 1024 * 1024));
        //builder.setDiskCache(
        //        new ExternalCacheDiskCacheFactory(context, "glide_cache", 100 * 1024 * 1024));
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {

    }
}
