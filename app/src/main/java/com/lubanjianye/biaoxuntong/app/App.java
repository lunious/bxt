package com.lubanjianye.biaoxuntong.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: lunious
 * Date: 2018/7/14 10:46
 * Description:
 */
public class App extends Application {

    //开发者模式开关
    public static boolean isDebug = true;
    public static String APP_NAME;
    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
    }

    /**
     * 初始化路由框架Arouter
     */
    private void initArouter() {
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
