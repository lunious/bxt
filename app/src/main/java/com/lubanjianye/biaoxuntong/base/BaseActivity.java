package com.lubanjianye.biaoxuntong.base;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.lubanjianye.biaoxuntong.app.App.APP_NAME;
import static com.lubanjianye.biaoxuntong.app.App.isDebug;

/**
 * Author: lunious
 * Date: 2018/7/14 10:48
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

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

    /**
     * 控制是否显示调试信息
     */
    public void TLog(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    /**
     * 隐藏软件盘
     */
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }


    /**
     * 显示软键盘
     */
    public void showInputMethod(){
        if (getCurrentFocus() != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),0);
        }
    }

    /**
     * 防止快速点击
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

}
