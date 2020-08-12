package com.qzy.laobiao.common.manager;

import android.content.Context;

/**
 * 获取指定资源
 */
public class CPResourceUtil {
    public static int geMipmapId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "mipmap", paramContext.getPackageName());
    }

    public static int getId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString,"id", paramContext.getPackageName());
    } 

}