package com.lqm;

import android.app.Application;

/**
 * user：lqm
 * desc：
 */

public class DemoApplication extends Application {


    private static DemoApplication sInstance;
    private static DemoComponent sDemoGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        buildComponentAndInject();
    }

    public static DemoGraph component() {
        return sDemoGraph;
    }

    public static void buildComponentAndInject(){
        sDemoGraph = DemoComponent.Initializer.init(sInstance);
    }


}
