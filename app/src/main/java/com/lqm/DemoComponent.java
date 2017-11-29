package com.lqm;

import com.lqm.modules.ApiModule;
import com.lqm.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * user：lqm
 * desc：组件, 注册Module, 添加主Module.
 */
@Singleton
@Component(modules = {MainModule.class, ApiModule.class})
public interface DemoComponent extends DemoGraph {

    class Initializer{
        private Initializer(){

        }

        //初始化组件
        public static DemoComponent init(DemoApplication application){
            return DaggerDemoComponent.builder()
                    .mainModule(new MainModule(application))
                    .build();
        }

    }


}
