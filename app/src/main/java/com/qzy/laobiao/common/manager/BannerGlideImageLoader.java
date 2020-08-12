package com.qzy.laobiao.common.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.qzy.laobiao.GlideApp;
import com.qzy.laobiao.R;
import com.youth.banner.loader.ImageLoader;


/**
 * artifact  banner图片加载管理
 */
public class BannerGlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.no_banner)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
       GlideApp.with(context.getApplicationContext())
                .load(path)
                //.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //.error(R.mipmap.no_banner)
                .apply(options)
                .into(imageView);
    }

}
