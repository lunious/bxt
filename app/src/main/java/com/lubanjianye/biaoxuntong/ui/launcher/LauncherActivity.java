package com.lubanjianye.biaoxuntong.ui.launcher;

import android.os.Bundle;
import android.os.Handler;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.base.BaseActivity;

/**
 * Author: lunious
 * Date: 2018/7/14 10:51
 * Description:
 */
public class LauncherActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {
        //暂定休眠2秒跳转首页，日后根据业务修改
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/com/MainActivity").navigation(LauncherActivity.this);
                finish();
            }
        }, 2000);
    }

}
