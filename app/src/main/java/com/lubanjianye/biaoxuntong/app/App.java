package com.lubanjianye.biaoxuntong.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lubanjianye.biaoxuntong.database.DatabaseManager;

/**
 * Author: lunious
 * Date: 2018/7/14 10:46
 * Description:
 */
public class App extends Application {

    //开发者模式开关
    public static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
        initGreenDao();
    }

    /**
     * 初始化路由框架Arouter
     */
    private void initArouter() {
        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    /**
     * 初始化greenDao
     */
    private void initGreenDao() {
        DatabaseManager.getInstance().init(this);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
