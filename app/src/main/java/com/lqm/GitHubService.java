package com.lqm;

import com.lqm.list.ListAdapter;

import java.util.ArrayList;
import rx.Observable;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * user：lqm
 * desc：
 */

public interface GitHubService {
    String ENDPOINT = "https://api.github.com";

    //获取库，获取的是数组
    @GET("/users/{user}/repos")
    Observable<ArrayList<ListAdapter.Repo>> getRepoData(@Path("user") String user);

}
