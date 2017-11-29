package com.lqm.modules;

import com.lqm.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * user：lqm
 * desc：
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    protected GitHubService provideGitHubService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加rx适配器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GitHubService.class);
    }
}
