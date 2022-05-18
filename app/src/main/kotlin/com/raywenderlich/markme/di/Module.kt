package com.raywenderlich.markme.di

import android.arch.persistence.room.Room
import android.content.Context
import com.raywenderlich.markme.feature.FeatureContract
import com.raywenderlich.markme.feature.presenter.FeaturePresenter
import com.raywenderlich.markme.main.MainContract
import com.raywenderlich.markme.main.presenter.MainPresenter
import com.raywenderlich.markme.model.Student
import com.raywenderlich.markme.model.database.AppDatabase
import com.raywenderlich.markme.repository.AppRepository
import com.raywenderlich.markme.splash.SplashContract
import com.raywenderlich.markme.splash.presenter.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

var applicationModule = module {
    factory { (view: SplashContract.View) ->
        SplashPresenter(view = view);
    }
    factory { (view: MainContract.View) ->
        MainPresenter(view = view)
    }
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "app-database").build()
    }
    single {
        AppRepository
    }
    single {
        androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }
    factory { (view: FeatureContract.View<Student>) ->
        FeaturePresenter(view = view)
    }

}

