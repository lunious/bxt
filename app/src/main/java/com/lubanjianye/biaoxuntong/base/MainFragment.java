package com.lubanjianye.biaoxuntong.base;

import android.icu.lang.UScript;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.ui.bottomBar.BottomBar;
import com.lubanjianye.biaoxuntong.ui.bottomBar.BottomBarTab;
import com.lubanjianye.biaoxuntong.ui.main.collectioon.CollectionFragment;
import com.lubanjianye.biaoxuntong.ui.main.index.IndexFragment;
import com.lubanjianye.biaoxuntong.ui.main.query.QueryFragment;
import com.lubanjianye.biaoxuntong.ui.main.result.ResultFragment;
import com.lubanjianye.biaoxuntong.ui.main.user.UserFragment;
import com.lubanjianye.biaoxuntong.utils.ToastUtil;

import butterknife.BindView;

/**
 * Author: lunious
 * Date: 2018/7/15 11:47
 * Description:
 */
public class MainFragment extends BaseFragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    @BindView(R.id.main_tab_container)
    FrameLayout mainTabContainer;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    private BaseFragment[] mFragments = new BaseFragment[5];

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseFragment firstFragment = findChildFragment(IndexFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = new IndexFragment();
            mFragments[SECOND] = new QueryFragment();
            mFragments[THIRD] = new CollectionFragment();
            mFragments[FOUR] = new ResultFragment();
            mFragments[FIVE] = new UserFragment();

            loadMultipleRootFragment(R.id.main_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR],
                    mFragments[FIVE]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(QueryFragment.class);
            mFragments[THIRD] = findChildFragment(CollectionFragment.class);
            mFragments[FOUR] = findChildFragment(ResultFragment.class);
            mFragments[FIVE] = findChildFragment(UserFragment.class);
        }
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

        bottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.main_index_tab, getString(R.string.first)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.main_query_tab, getString(R.string.second)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.main_collection_tab, getString(R.string.third)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.main_result_tab, getString(R.string.four)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.main_user_tab, getString(R.string.five)));


        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    protected void initEnvent(Bundle savedInstanceState) {

    }

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 3000L;
    private long TOUCH_TIME = 0;

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtil.shortToast(getContext(), "再按一次退出程序");
        }
        return true;
    }

}
