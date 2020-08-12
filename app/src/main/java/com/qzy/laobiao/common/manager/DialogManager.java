package com.qzy.laobiao.common.manager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.qzy.laobiao.common.base.BaseApplication;
import com.qzy.laobiao.widget.CommonAlertDialog;

/**
 * artifact  弹框管理类
 */
public class DialogManager {

    private static String cancel = "取消";
    private static final String confirm = "确定";

    /**
     * 是否退出登录
     */
    public static void logoutDialog(final Context context) {

        final CommonAlertDialog dialog = new CommonAlertDialog(context);
        dialog.builder();
        dialog.setMsg("退出后下次将需要重新登录，确定退出？");
        dialog.setPositiveButton(confirm, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseApplication.getInstance().exitLogin(context);
                dialog.dismiss();
            }
        }).setNegativeButton(cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        }).show();

    }


    /**
     * 弹出提示框
     *
     * @param context
     * @param msg
     * @param listener
     */
    public static void showHintDialog(final Activity context, String msg, final IOnClickListener listener) {

        final CommonAlertDialog dialog = new CommonAlertDialog(context);
        dialog.builder();
        dialog.setMsg(msg);
        dialog.setPositiveButton(confirm, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onConfirm();
                }
                dialog.dismiss();

            }
        }).setNegativeButton(cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCancel();
                }
                dialog.dismiss();
            }
        }).show();
    }


    /**
     * 弹出提示框
     *
     * @param context
     * @param msg
     * @param listener
     */
    public static void showHintDialog(final Activity context, String msg, String cancel, String sure, final IOnClickListener listener) {
        final CommonAlertDialog dialog = new CommonAlertDialog(context);
        dialog.builder();
        dialog.setMsg(msg);
        dialog.setPositiveButton(sure, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onConfirm();
                }
                dialog.dismiss();

            }
        }).setNegativeButton(cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCancel();
                }
                dialog.dismiss();
            }
        }).show();
    }


    public interface IOnClickListener {
        void onConfirm();

        void onCancel();
    }

    public interface ISureOnClickListener {
        void onConfirm();
    }

    /**
     * 弹出提示框
     * 只包含确定按钮
     *
     * @param context
     * @param msg
     * @param listener
     */
    public static void showSureHintDialog(final Activity context, String msg, final ISureOnClickListener listener) {
        final CommonAlertDialog dialog = new CommonAlertDialog(context);
        dialog.builder();
        dialog.setMsg(msg);
        dialog.hideCancleBtn();
        dialog.setPositiveButton(confirm, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onConfirm();
                }
                dialog.dismiss();
            }
        }).show();
    }



//    /**
//     * 拨打客服
//     */
//    public static Dialog getServiceCallDialog(Context context, final View.OnClickListener l) {
//        final Dialog dialog = new Dialog(context, R.style.AlertDialogStyle);
//        View view = View.inflate(context, R.layout.dialog_call_alert, null);
//
//        view.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        view.findViewById(R.id.sure_btn).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                        if (l != null) {
//                            l.onClick(v);
//                        }
//                    }
//                });
//
//        dialog.setContentView(view);
//        // 触摸对话框以外 dismiss对话框
//        dialog.setCanceledOnTouchOutside(false);
//
//        Window window = dialog.getWindow();
//        WindowManager.LayoutParams lp = Objects.requireNonNull(window).getAttributes();
//        lp.width = (int) (getScreenWidth(context) * 0.85);
//        window.setGravity(Gravity.CENTER_VERTICAL); // 此处可以设置dialog显示的位置
//        return dialog;
//    }




    /**
     * 分享
     */
//    public static Dialog getShareDialog(Context context, final View.OnClickListener l, final View.OnClickListener n, final View.OnClickListener p) {
//
//        final Dialog dialog = new Dialog(context, R.style.AlertDialogStyle);
//
//        View view = View.inflate(context, R.layout.dialog_umeng_share, null);
//        dialog.setContentView(view);
//        // 触摸对话框以外 dismiss对话框
//        dialog.setCanceledOnTouchOutside(true);
//
//        //取消
//        view.findViewById(R.id.cancel_tv).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//
//        //微信
//        view.findViewById(R.id.wechat_ll).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (l != null) {
//                            l.onClick(v);
//                        }
//                        dialog.dismiss();
//
//                    }
//                });
//        //朋友圈
//        view.findViewById(R.id.wxcircle_ll).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (n != null) {
//                            n.onClick(v);
//                        }
//                        dialog.dismiss();
//                    }
//                });
//
//        //qq
//        view.findViewById(R.id.qq_ll).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (p != null) {
//                            p.onClick(v);
//                        }
//                        dialog.dismiss();
//                    }
//                });
//
//        Window window = dialog.getWindow();
//        WindowManager.LayoutParams lp = Objects.requireNonNull(window).getAttributes();
//        lp.width = getScreenWidth(context);
//        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
//        return dialog;
//    }





    /**
     * 获取屏幕宽度
     */
    private static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
