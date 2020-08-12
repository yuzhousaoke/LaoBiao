package com.qzy.laobiao.common.manager;


/**
 * artifact  友盟分享管理类
 */
public class UMengShareManager {

    /**
     * @param activity Activity
     * @param title       标题
     * @param description 副标题
     * @param url         分享链接
     * @param platform    分享平台
     */
//    public static void shareWeb(final Activity activity, String url, String title, String description, String shareImg, SHARE_MEDIA platform) {
//        UMWeb web = new UMWeb(url);
//        web.setTitle(title);//标题
//
//        if(StringUtils.isEmpty(shareImg)){
//            web.setThumb(new UMImage(activity, R.mipmap.weixinfengxiang));  //缩略图
//        }else {
//            web.setThumb(new UMImage(activity, shareImg));  //缩略图
//        }
//        web.setDescription(description);//描述
//
//        ShareAction shareAction = new ShareAction(activity);
//        shareAction.setPlatform(platform);
//        shareAction.withMedia(web);
//
//        //分享回调
//        shareAction.setCallback(new UMShareListener() {
//            @Override
//            public void onStart(SHARE_MEDIA share_media) {
//            }
//
//            @Override
//            public void onResult(SHARE_MEDIA share_media) {
//                ToastManager.showToast(activity, "分享成功");
//            }
//
//            @Override
//            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
//                LogUtils.e("分享失败：" + throwable.getMessage());
//                ToastManager.showToast(activity, "分享失败");
//            }
//
//            @Override
//            public void onCancel(SHARE_MEDIA share_media) {
//                ToastManager.showToast(activity, "分享取消");
//            }
//        });
//        shareAction.share();
//    }

}
