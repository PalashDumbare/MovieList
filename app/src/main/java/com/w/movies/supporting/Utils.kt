package com.w.movies.supporting

import android.graphics.drawable.Animatable
import android.view.ViewGroup
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo


class Utils {
    companion object{
        val TAG  = Utils.javaClass.simpleName




        fun loadImage(uri : String , imageView : SimpleDraweeView){

            imageView.setImageURI(uri)
//imageView.controller =
//             Fresco.newDraweeControllerBuilder()
//                    .setUri(uri)
//                    .setControllerListener(object : BaseControllerListener<ImageInfo>() {
//                        override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
//                        //    imageView.getLayoutParams().width = imageInfo!!.width
//                            imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT
//                            imageView.setAspectRatio((imageView.layoutParams.width / imageInfo!!.height).toFloat())
//                            super.onFinalImageSet(id, imageInfo, animatable)
//                        }
//
//                        override fun onIntermediateImageSet(id: String?, imageInfo: ImageInfo?) {
////                            imageView.getLayoutParams().width = imageInfo!!.width
//                            imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT
//                            imageView.setAspectRatio((imageView.layoutParams.width / imageInfo!!.height).toFloat())
//                            super.onIntermediateImageSet(id, imageInfo)
//                        }
//                    })
//                    .build()

        }
    }

}