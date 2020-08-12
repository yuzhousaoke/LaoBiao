package com.qzy.laobiao.common;

import android.os.Environment;

import com.qzy.laobiao.common.base.BaseApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * artifact  通用配置文件
 */
public class UrlConfig {

    /**
     * 统一的文件保存路径
     *
     * @return
     */
    public static String getFileRootPath() {
        return Environment.getExternalStorageDirectory().getPath() + "/artifactcache";
    }

    /**
     * @Title getCommonMap
     * @Description 公用请求参数map
     */
    public static Map<String, String> getCommonMap() {
        Map<String, String> maps = new HashMap<>();
//        maps.put("version", BaseApplication.getInstance().AppVersion);
//        maps.put("deviceType", "android");    //设备类型
//        maps.put("platformType", PLATFORM_TYPE);//区分不同分身
//        maps.put("packageType", "2");//区分包
        return maps;
    }

    /**
     * 标识是否为第一次进入程序
     */
    public static final String FLAG_FIRST = "first_enter";


    /**
     * 用户信息
     */
    public static final String USERID = "userid"; //用户id
    public static final String ACCOUNT = "account";//账号

    /**
     * umeng pushSecret
     */
    public static final String UMENG_SECRET = "dbd7d03fa367cf2ca9cbbf29be472dab";

    /**
     * umeng微信分享key  qq分享key
     */
    public static final String PLATFORM_TYPE = "2";//
    /**
     * 分身包2
     */
//    public static final String UMENG_SHARE_WX_ID = "wx24d65d80e976a92b";
    public static final String UMENG_SHARE_WX_ID = "wxd11c62285aba8dab";
    public static final String UMENG_SHARE_WX_KEY = "15b9ac1e04c8b6e79f83f9916dd4ead1";


//    public static final String UMENG_SHARE_QQ_ID = "1108791791";
    public static final String UMENG_SHARE_QQ_ID = "1110056522";
    public static final String UMENG_SHARE_QQ_KEY = "2Obcwl8uNIgctjvq";

    /**
     * 微信申请的平台appId
     */
    public static final String WEIXIN_APP_ID = UMENG_SHARE_WX_ID;

    /**
     * 网络请求统一码（与服务器商定）
     */
    public static final int RESULT_OK = 200; //网络请求成功
    public static final int RESULT_201 = 201; //网络请求错误
    public static final int RESULT_202 = 202; //网络请求错误

    public static final int RESULT_401 = 401; //网络请求错误
    public static final int RESULT_402 = 402; //网络请求错误
    public static final int RESULT_403 = 403; //网络请求错误

    public static final int SESSION_TIME_OUT = 300;  //登录超时或未登录

    /**
     * 版本更新
     **/
    //service是否正在运行
    public static boolean isRunning = false;
    //dialog是否处于显示状态
    public static boolean isShow = false;

    //是否商城微信支付
    public static boolean isMallWxPay = false;

    //是否为套餐充值
    public static boolean isRechargePacket = false;

    //注册协议
    public static final String REGISTER_AGREEMENT = ServiceConfig.getRootUrl() + "/hykweb/index/zcxy.html";
    //领取油卡规则
    public static final String GET_THE_RULES = ServiceConfig.getRootUrl() + "/hykweb/mobile/help/get_the_rules.html";
    // 积分规则
    public static final String INTEGRAL_RULE = ServiceConfig.getRootUrl() + "/hykweb/index/integralRule.html";
    //帮助中心页面
    public static final String INDEX_HELP = ServiceConfig.getRootUrl() + "/hykweb/index/help.html";
    //邀请好友
    public static final String INVITE_FRIENDS = ServiceConfig.getRootUrl() + "/hykweb/index/inviteFriends.html";
    //安全保障
    public static final String SAFETY_SECURITY = ServiceConfig.getRootUrl() + "/hykweb/index/safetyAndSecurity.html";
    //官方公告
    public static final String NOTICELIST = ServiceConfig.getRootUrl() + "/hykweb/mobile/index.html#/noticeList";
    //帮助中心
    public static final String HELPCENTER = ServiceConfig.getRootUrl() + "/hykweb/mobile/help/helpCenter_h5.html";
    //平台介绍
    public static final String INTRODUCE = ServiceConfig.getRootUrl() + "/hykweb/mobile/activity/introduce/index.html";
    //新手专享
    public static final String NEWNOVICE = ServiceConfig.getRootUrl() + "/hykweb/mobile/activity/novice/index.html";
    //意见反馈
    public static final String SUGGEST = ServiceConfig.getRootUrl() + "/hykweb/mobile/help/helpCenter_h5_Feedback.html";
    //物流信息
    public static final String COURIER_INFO = ServiceConfig.getRootUrl() + "/hykweb/mobile/service/express.html";
    //加油计划
    public static final String ADD_OIL_PLAN = ServiceConfig.getRootUrl() + "/hykweb/mobile/activity/payment_calender/index.html";
    //公告详情
    public static final String NOTICE_ID = ServiceConfig.getRootUrl() + "/hykweb/mobile/index.html#/page?id=";
    //资讯详情
    //public static final String CONSULT_ID = ServiceConfig.getRootUrl() + "/hykweb/mobile/index.html#/detail?id=";
    public static final String CONSULT_ID = ServiceConfig.getRootUrl() + "/hykweb/mobile/index.html#/detail?id=";
    //行业资讯
    public static final String CONSULT_LIST = ServiceConfig.getRootUrl() + "/hykweb/mobile/index.html#/notice";
    //邀请好友
    public static final String INVITSTION_FRIEND = ServiceConfig.getRootUrl() + "/hykweb/mobile/activity/share/share.html";

    //隐私
//    /hyk-web/mobile/index.html#/privacyPolicy

    /************************app下载链接*********************************/
    public static final String APK_CHANNEL = ServiceConfig.getRootUrl() + "/hykweb/apk/aftifact_";

}
