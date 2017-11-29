package com.lqm.modules;

import android.app.Application;
import android.content.res.Resources;

import com.lqm.DemoApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * user：lqm
 * desc：主要模块, 提供Application和resources.
 */

@Module
public class MainModule {
    private final DemoApplication mApp;


    public MainModule (DemoApplication application){
        mApp = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication(){
        return mApp;
    }

    @Provides
    @Singleton
    public Resources provideResources(){
        return mApp.getResources();
    }

}
