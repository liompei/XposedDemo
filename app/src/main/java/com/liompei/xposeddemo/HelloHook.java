package com.liompei.xposeddemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by Liompei
 * time : 2018/1/2 17:35
 * 1137694912@qq.com
 * https://github.com/liompei
 * remark:
 */

public class HelloHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
//        XposedBridge.log("===包名===" + lpparam.packageName);
//        Log.d("HelloHook", "===包名===" + lpparam.packageName);
        if (lpparam.packageName.equals("com.liompei.xposeddemo")) {
            XposedHelpers.findAndHookMethod("com.liompei.xposeddemo.MainActivity", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log.d("HelloHook", "beforeHookedMethod");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Log.d("HelloHook", "afterHookedMethod");
                    Class aClass = param.thisObject.getClass();
                    Field[] fields = aClass.getDeclaredFields();

                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        Log.d("HelloHook", "参数名: " + field.getName() + ",类型: " + field.getType());
                    }

                    Field field = aClass.getDeclaredField("tvTest");
                    field.setAccessible(true);
                    TextView textView = (TextView) field.get(param.thisObject);
                    textView.setText("成功修改参数");

                }
            });
        }
    }
}
