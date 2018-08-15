package app.challange.code.r6h2lle11p.presentation.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module

@Module
interface BaseActivityBindingModule<in T : AppCompatActivity> {

    @Binds
    fun bindActivity(activity: T): AppCompatActivity

}
