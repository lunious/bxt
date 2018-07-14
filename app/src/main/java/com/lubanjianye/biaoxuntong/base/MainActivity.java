package com.lubanjianye.biaoxuntong.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.ui.bottomBar.BottomBar;
import com.lubanjianye.biaoxuntong.ui.bottomBar.BottomBarTab;
import com.lubanjianye.biaoxuntong.ui.main.collectioon.CollectionFragment;
import com.lubanjianye.biaoxuntong.ui.main.index.IndexFragment;
import com.lubanjianye.biaoxuntong.ui.main.query.QueryFragment;
import com.lubanjianye.biaoxuntong.ui.main.result.ResultFragment;
import com.lubanjianye.biaoxuntong.ui.main.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = "/com/MainActivity")
public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.vp_main)
    NoScrollViewPager vpMain;


    private MainFragmentPagerAdapter mPagerAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        bottomBar
                .addItem(new BottomBarTab(this, R.mipmap.main_index_tab, getString(R.string.first)))
                .addItem(new BottomBarTab(this, R.mipmap.main_query_tab, getString(R.string.second)))
                .addItem(new BottomBarTab(this, R.mipmap.main_collection_tab, getString(R.string.third)))
                .addItem(new BottomBarTab(this, R.mipmap.main_result_tab, getString(R.string.four)))
                .addItem(new BottomBarTab(this, R.mipmap.main_user_tab, getString(R.string.five)));

        mPagerAdapter = new MainFragmentPagerAdapter(getFragments(), getSupportFragmentManager());
        vpMain.setOffscreenPageLimit(1);//设置默认预加载个数 默认是1
        vpMain.setNoScroll(true);
        vpMain.setAdapter(mPagerAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new IndexFragment());
        fragments.add(new QueryFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new ResultFragment());
        fragments.add(new UserFragment());
        return fragments;
    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {

        vpMain.setCurrentItem(0);//默认显示第一页

        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                vpMain.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

}
