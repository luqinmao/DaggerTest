package com.lqm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lqm.list.ListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * user：lqm
 * desc：
 */

public class ReposListActivity extends Activity {


    @Bind(R.id.repos_rv_list)
    RecyclerView reposRvList;

    @Inject
    GitHubService gitHubService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_list);
        ButterKnife.bind(this);

        DemoApplication.component().inject(this);

        initView();

    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        reposRvList.setLayoutManager(manager);

        ListAdapter adapter = new ListAdapter();
        reposRvList.setAdapter(adapter);

        loadData(adapter);

    }

    private void loadData(final ListAdapter adapter) {

        gitHubService.getRepoData("SpikeKing")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<ListAdapter.Repo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<ListAdapter.Repo> repos) {
                        adapter.setRepos(repos);
                    }
                });
    }


}
