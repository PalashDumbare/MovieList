package com.w.movies

import android.os.Build
import androidx.room.Room
import com.facebook.drawee.backends.pipeline.Fresco
import com.w.movies.data.local.db.Moviedb
import com.w.movies.di.AppComponent
import com.w.movies.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class ApplicationStartUp : DaggerApplication() {
    protected var applicationComponent: AppComponent? = null


    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);

        db = Room.databaseBuilder(this,Moviedb::class.java,"movies.db").build()

    }

    companion object{
        var db : Moviedb? = null
    }





     override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        applicationComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        applicationComponent?.inject(this)
        return applicationComponent
    }

}