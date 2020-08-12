package com.qzy.laobiao.common.net;

import android.content.Context;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Description:cookie管理
 */
class CookiesManager implements CookieJar {

    private Context mContext;
    private PersistentCookieStore cookieStore = null;

    public CookiesManager(Context context) {
        this.mContext = context;
        cookieStore = new PersistentCookieStore(mContext);
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

}