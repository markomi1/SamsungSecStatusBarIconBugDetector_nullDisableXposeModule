package com.marko.samsungbarspamdisablerxposedmodule;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class XposedClass implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.android.systemui")) {
            Log.d("XposedModule","Android SystemUI loaded");

            findAndHookMethod("com.android.systemui.statusbar.SecStatusBarIconBugDetector", lpparam.classLoader, "debugTest", new XC_MethodReplacement(){
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return false;
                }
            });
        }
    }
}
