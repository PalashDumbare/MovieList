package com.w.movies.supporting

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.w.movies.interfaces.ImageSetListener


class Utils {
    companion object{
        val TAG  = Utils.javaClass.simpleName




        fun loadImage(ctx : Context,uri : String , imageView : ImageView,listner : ImageSetListener? = null){
            imageView.background = null
            Glide.with(ctx).load(uri).into(imageView)
        }
    }

}