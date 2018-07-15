package com.lubanjianye.biaoxuntong.base;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;


/**
 * Author: lunious
 * Date: 2018/7/14 10:48
 * Description:
 */
public abstract class BaseActivity extends SwipeBackActivity {

    private Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initData(savedInstanceState);
        initEvent(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        //垃圾回收
        System.gc();
        System.runFinalization();
        unbinder.unbind();
        super.onDestroy();

    }

    /**
     * 布局
     */
    protected abstract int getLayoutId();

    /**
     * 数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 事件
     */
    protected abstract void initEvent(Bundle savedInstanceState);




}
