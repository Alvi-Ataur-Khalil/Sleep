/*
 * Created by Alvi Khalil on 10/31/18 3:28 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 10/31/18 3:28 PM
 *
 */

package com.example.alvi.sleep.HelperClasses;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.alvi.sleep.R;


import java.io.File;


public class ImageLoaderGlide {

    public static void gluideLoader( String pathOfFile, ImageView imageView){
        Glide.with(App.getContext())
                .asBitmap()
                .load(Uri.fromFile(new File(pathOfFile)))
                .into(imageView);
    }

}
