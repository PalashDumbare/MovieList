package com.w.movies.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.Window
import android.widget.Toast
import com.w.movies.R
import dagger.android.support.DaggerAppCompatActivity


open class BaseActivity : DaggerAppCompatActivity() {


    private var loadingdialog : Dialog? = null

    open fun showLoading(){
        showLoadingDialog(this)
    }

    open fun hideLoading(){
cancelLoading()
    }

    fun showMessage(message : String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }


    open fun showLoadingDialog(context: Context) {

            loadingdialog = Dialog(context)
            loadingdialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            loadingdialog?.setContentView(R.layout.loadingdialog)
            loadingdialog?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            loadingdialog?.setCanceledOnTouchOutside(false)
            loadingdialog?.show()

    }

    open fun cancelLoading(){
        loadingdialog?.cancel()
    }

    override fun onPause() {
        super.onPause()
        cancelLoading()
    }

    fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
    }
    
}