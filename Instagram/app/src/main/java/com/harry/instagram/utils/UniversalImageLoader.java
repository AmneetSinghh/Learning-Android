package com.harry.instagram.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.harry.instagram.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageLoader {
    private static final int defaultImage= R.drawable.ic_android;
    private Context mContext;
    public UniversalImageLoader(Context context){
        mContext = context;
    }
    public ImageLoaderConfiguration getConfig()
    {
        DisplayImageOptions defaultoptoins= new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config= new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultoptoins)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024*1024).build();
        return config;

    }


    /*
    This method can be used to set images taht are static. it can't be used if the images are being changed in
    the Fragment/Activity - Or if they are being setin a list or a grid.
     */


    public static void setImage(String imgurl, ImageView image, final ProgressBar mprogressbar,String append)
    {
        ImageLoader imageLoader= ImageLoader.getInstance();
        imageLoader.displayImage(append + imgurl, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(mprogressbar!=null){
                    mprogressbar.setVisibility(view.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(mprogressbar!=null){
                    mprogressbar.setVisibility(view.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(mprogressbar!=null){
                    mprogressbar.setVisibility(view.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(mprogressbar!=null){
                    mprogressbar.setVisibility(view.GONE);
                }
            }
        });

    }


}
