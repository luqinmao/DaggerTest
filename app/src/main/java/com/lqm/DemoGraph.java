package com.lqm;

/**
 * user：lqm
 * desc：
 */

public interface DemoGraph {
    void inject(MainActivity mainActivity); // 注入MainActivity

    void inject(ReposListActivity reposListActivity); // 注入列表Activity
}
