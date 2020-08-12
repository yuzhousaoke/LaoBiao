package com.qzy.laobiao.common.net;

import android.content.Context;


import com.qzy.laobiao.common.base.BaseModel;
import com.qzy.laobiao.home.bean.OldVideoBean;
import com.qzy.laobiao.home.model.VideoIdModel;
import com.qzy.laobiao.login.bean.CreateFlie;
import com.qzy.laobiao.login.bean.User;
import com.qzy.laobiao.login.bean.YzCode;
import com.qzy.laobiao.login.model.FileModel;
import com.qzy.laobiao.login.model.LoginModel;
import com.qzy.laobiao.login.model.UserIconModel;
import com.qzy.laobiao.login.model.UserInfoModel;
import com.qzy.laobiao.login.model.YzCodeModel;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * artifact  NetWorks
 */

public class NetWorks extends RetrofitUtils {

    private static NetWorks instance;
    private NetService service;

    /**
     * 构造
     */
    private NetWorks() {
        service = getRetrofit().create(NetService.class);
    }

    /**
     * 单例
     */
    public static NetWorks getInstance() {
        if (instance == null) {
            synchronized (NetWorks.class) {
                if (instance == null) {
                    instance = new NetWorks();
                }
            }
        }
        return instance;
    }

    /**
     * 通用订阅
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    private <T extends BaseModel> void setSubscribe(Context context, Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .flatMap(new RxHttpResult<>(context))
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }


    //登录
    public void goLogin(Context context, User user, Observer<LoginModel> observer) {
        setSubscribe(context, service.goLogin(user), observer);
    }
//
//    //检查手机号是否存在
//    public void checkPhone(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.checkPhone(map), observer);
//    }

    //检查短信是否输入正确
    public void checkPhoneCode(Context context, YzCode yzCode, Observer<YzCodeModel> observer) {
        setSubscribe(context, service.checkPhoneCode(yzCode), observer);
    }

    //意见反馈--上传图片
    public void getUploadImg(Context context, UserIconModel userIconModel, Observer<LoginModel> observer) {
        setSubscribe(context, service.getUploadImg(userIconModel), observer);
    }
    //创建唯一文件名
    public void getFile(Context context, CreateFlie createFlie, Observer<FileModel> observer) {
        setSubscribe(context, service.getFileName(createFlie),observer);
    }

    //获取用户信息
    public void getMineInfo(Context context, Map<String, String> map,Observer<UserInfoModel> observer) {
        setSubscribe(context, service.getMineInfo(map),observer);
    }

    //上传用户视频信息
    public void getUploadVideo(Context context, OldVideoBean oldVideoBean, Observer<VideoIdModel> observer) {
        setSubscribe(context, service.getUploadVideo(oldVideoBean),observer);
    }



       //发送注册短信
//    public void getRegisterCode(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getRegisterCode(map), observer);
//    }

    //注册
    public void getRegister(Context context, User user, Observer<LoginModel> observer) {
        setSubscribe(context, service.getRegister(user), observer);
    }
//
//    //修改登录密码
//    public void getSetLoginPwd(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getSetLoginPwd(map), observer);
//    }
//
//    //首页最新充值消息
//    public void getHomeLoop(Context context, Map<String, String> map, Observer<HomeLoopModel> observer) {
//        setSubscribe(context, service.getHomeLoop(map), observer);
//    }
//
//    //首页最新banner
//    public void getHomeBanner(Context context, Map<String, String> map, Observer<HomeBannerModel> observer) {
//        setSubscribe(context, service.getHomeBanner(map), observer);
//    }
//
//    //首页按钮
//    public void getHomeNewCardView(Context context, Map<String, String> map, Observer<HomeCardvMode> observer) {
//        setSubscribe(context ,service.getHomeNewCardView(map), observer);
//    }
//
//
//    //首页最新充值套餐
//    public void getHomeRecharge(Context context, Map<String, String> map, Observer<HomeModel> observer) {
//        setSubscribe(context, service.getHomeRecharge(map), observer);
//    }
//
//    //首页最新充值套餐
//    public void getHomeNewRecharge(Context context, Map<String, String> map, Observer<HomeModel> observer) {
//        setSubscribe(context, service.getHomeNewRecharge(map), observer);
//    }
//
//
//
//    //获取充值列表
//    public void getRechargeList(Context context, Map<String, String> map, Observer<HomeModel> observer) {
//        setSubscribe(context, service.getRechargeList(map), observer);
//    }
//
//    //即时充值
//    public void getRecharge(Context context, Map<String, String> map, Observer<RechargeOrderModel> observer) {
//        setSubscribe(context, service.getRecharge(map), observer);
//    }
//
//    //套餐充值
//    public void getRechargePackage(Context context, Map<String, String> map, Observer<RechargeOrderModel> observer) {
//        setSubscribe(context, service.getRechargePackage(map), observer);
//    }
//
//    //我的
//    public void getMine(Context context, Map<String, String> map, Observer<MineModel> observer) {
//        setSubscribe(context, service.getMine(map), observer);
//    }
//
//    //添加加油卡
//    public void getAddOil(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getAddOil(map), observer);
//    }
//
//    //删除加油卡
//    public void getDeleteOilCard(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getDeleteOilCard(map), observer);
//    }
//
//    //我的优惠券
//    public void getAllCouponsList(Context context, Map<String, String> map, Observer<CouponsListModel> observer) {
//        setSubscribe(context, service.getAllCouponsList(map), observer);
//    }
//
//    //选择优惠券
//    public void getUseCoupons(Context context, Map<String, String> map, Observer<CouponsListModel> observer) {
//        setSubscribe(context, service.getUseCoupons(map), observer);
//    }
//
//    //APP版本
//    public void getAppVersion(Context context, Map<String, String> map, Observer<AppSettingModel> observer) {
//        setSubscribe(context, service.getAppVersion(map), observer);
//    }
//
//    //个人中心
//    public void getMineInfo(Context context, Map<String, String> map, Observer<MineInfoModel> observer) {
//        setSubscribe(context, service.getMineInfo(map), observer);
//    }
//
//    //个人中心 ---修改生日 性别
//    public void getUpdateMineInfo(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getUpdateMineInfo(map), observer);
//    }
//
//    //个人中心 ---修改性别
//    public void getUpdateBirthdayMineInfo(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getUpdateBirthdayMineInfo(map), observer);
//    }
//
//    //我的积分
//    public void getIntegralUsage(Context context, Map<String, String> map, MyObserver<MineIntegralModel> observer) {
//        setSubscribe(context, service.getIntegralUsage(map), observer);
//    }
//
//    //全部加油计划
//    public void getOilPlan(Context context, Map<String, String> map, Observer<OilPlanModel> observer) {
//        setSubscribe(context, service.getOilPlan(map), observer);
//    }
//
//    //加油计划弹窗
//    public void getOilPlanTime(Context context, Map<String, String> map, Observer<DialogOilPlanTime> observer) {
//        setSubscribe(context, service.getOilPlanTime(map), observer);
//    }
//
//    //全部订单
//    public void getOrderList(Context context, Map<String, String> map, Observer<OrderListModel> observer) {
//        setSubscribe(context, service.getOrderList(map), observer);
//    }
//
//    //油卡充值记录
//    public void getOilOrderRecordList(Context context, Map<String, String> map, Observer<OrderListModel> observer) {
//        setSubscribe(context, service.getOilOrderRecordList(map), observer);
//    }
//
//    //订单详情
//    public void getOrderDetails(Context context, Map<String, String> map, Observer<OrderDetailsModel> observer) {
//        setSubscribe(context, service.getOrderDetails(map), observer);
//    }
//
//    //收货地址
//    public void getAddressList(Context context, Map<String, String> map, Observer<AddressListModel> observer) {
//        setSubscribe(context, service.getAddressList(map), observer);
//    }
//
//    //添加收货地址
//    public void getAddressAdd(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getAddressAdd(map), observer);
//    }
//
//    //修改收货地址
//    public void getAddressModify(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getAddressModify(map), observer);
//    }
//
//    //删除收货地址
//    public void getAddressDelete(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getAddressDelete(map), observer);
//    }
//
//    //官方公告
//    public void getNoticeList(Context context, Map<String, String> map, Observer<NoticeModel> observer) {
//        setSubscribe(context, service.getNoticeList(map), observer);
//    }
//
//    //消息中心
//    public void getNewNotice(Context context, Map<String, String> map, Observer<MessageCenterModel> observer) {
//        setSubscribe(context, service.getNewNotice(map), observer);
//    }
//
//    //邀请人
//    public void getInvitationList(Context context, Map<String, String> map, Observer<InvitationListModel> observer) {
//        setSubscribe(context, service.getInvitationList(map), observer);
//    }
//
//    //活动
//    public void getFindList(Context context, Map<String, String> map, MyObserver<ActivitiesCenterModel> observer) {
//        setSubscribe(context, service.getFindList(map), observer);
//    }
//
//    //活动中心
//    public void getActivitiesList(Context context, Map<String, String> map, Observer<ActivitiesCenterModel> observer) {
//        setSubscribe(context, service.getActivitiesList(map), observer);
//    }
//
//    //油价
//    public void getOilPrice(Context context, Map<String, String> map, Observer<OilPriceModel> observer) {
//        setSubscribe(context, service.getOilPrice(map), observer);
//    }
//
//    //新闻
//    public void getAllNews(Context context, Map<String, String> map, Observer<NewsModel> observer) {
//        setSubscribe(context, service.getAllNews(map), observer);
//    }
//
//    //新闻详情
//    public void getOneNews(Context context, Map<String, String> map, Observer<OneNewModel> observer) {
//        setSubscribe(context, service.getOneNews(map), observer);
//    }
//
//    //连连支付
//    public void getRechargePay(Context context, Map<String, String> map, Observer<LianLianPayModel> observer) {
//        setSubscribe(context, service.getRechargePay(map), observer);
//    }
//    //余额支付
//    public void getRechargePay_ye(Context context, Map<String, String> map, Observer<LianLianPayModel> observer) {
//        setSubscribe(context, service.getRechargePay_ye(map), observer);
//    }
//
//    // 支付宝--油卡充值
//    public void getRechargeOilZFBPay(Context context, Map<String, String> map, Observer<ZFBPayModel> observer) {
//        setSubscribe(context, service.getRechargeOilZFBPay(map), observer);
//    }
//
//    //支付宝
//    public void getRechargeZFBPay(Context context, Map<String, String> map, Observer<ZFBPayModel> observer) {
//        setSubscribe(context, service.getRechargeZFBPay(map), observer);
//    }
//
//    //微信支付 -- 油卡充值
//    public void getRechargeOilWXPay(Context context, Map<String, String> map, Observer<WXPayModel> observer) {
//        setSubscribe(context, service.getRechargeOilWXPay(map), observer);
//    }
//
//    //微信支付
//    public void getRechargeWXPay(Context context, Map<String, String> map, Observer<WXPayModel> observer) {
//        setSubscribe(context, service.getRechargeWXPay(map), observer);
//    }
//
//    //微信支付
//    public void getPointPay(Context context, Map<String, String> map, Observer<WXPayModel> observer) {
//        setSubscribe(context, service.getPointPay(map), observer);
//    }
//

//
//    //意见反馈
//    public void getSuggest(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getSuggest(map), observer);
//    }
//
//    //站内信
//    public void getNewMessage(Context context, Map<String, String> map, Observer<MessageNewModel> observer) {
//        setSubscribe(context, service.getNewMessage(map), observer);
//    }
//
//    //站内信
//    public void getMessageList(Context context, Map<String, String> map, Observer<MessageListModel> observer) {
//        setSubscribe(context, service.getMessageList(map), observer);
//    }
//
//    // 站内信-全部标记已读
//    public void getUpdateMessage(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getUpdateMessage(map), observer);
//    }
//
//    // 站内信-单条已读
//    public void getUpdateOneMessage(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getUpdateOneMessage(map), observer);
//    }
//
//    // 余额充值
//    public void getBalanceRecharge(Context context, Map<String, String> map, Observer<BaseModel> observer) {
//        setSubscribe(context, service.getBalanceRecharge(map), observer);
//    }
//
//    // 余额充值记录
//    public void getBalanceRechargeRecord(Context context, Map<String, String> map, Observer<BalanceRecordModel> observer) {
//        setSubscribe(context, service.getBalanceRechargeRecord(map), observer);
//    }
//
//    // 商品
//    public void getMallList(Context context, Map<String, String> map, Observer<MallModel> observer) {
//        setSubscribe(context, service.getMallList(map), observer);
//    }
//
//    // 商城banner
//    public void getMallBanner(Context context, Map<String, String> map, Observer<MallBannerModel> observer) {
//        setSubscribe(context, service.getMallBanner(map), observer);
//    }
//
//    // 商品详情
//    public void getMallDetails(Context context, Map<String, String> map, Observer<MallDetailsModel> observer) {
//        setSubscribe(context, service.getMallDetails(map), observer);
//    }
//
//    // 商品-- 下单
//    public void getMallOrder(Context context, Map<String, String> map, Observer<MallOrderModel> observer) {
//        setSubscribe(context, service.getMallOrder(map), observer);
//    }
//
//    // 商品-- 下单
//    public void getMallOilOrder(Context context, Map<String, String> map, Observer<MallOrderModel> observer) {
//        setSubscribe(context, service.getMallOilOrder(map), observer);
//    }
//
//    // 查看商品订单
//    public void getLookMallOrder(Context context, Map<String, String> map, Observer<MallOrderCheckStandModel> observer) {
//        setSubscribe(context, service.getLookMallOrder(map), observer);
//    }
//
//    // 商品支付
//    public void getPayMallOrder(Context context, Map<String, String> map, Observer<LianLianPayModel> observer) {
//        setSubscribe(context, service.getPayMallOrder(map), observer);
//    }
//
//    //商品所有订单
//    public void getMallAllOrder(Context context, Map<String, String> map, Observer<MallOrderListModel> observer) {
//        setSubscribe(context, service.getMallAllOrder(map), observer);
//    }
//
//    //商品详情 --- 获取一条收货地址
//    public void getMallOneAddress(Context context, Map<String, String> map, Observer<MallOneAddress> observer) {
//        setSubscribe(context, service.getMallOneAddress(map), observer);
//    }
//
//    //欢迎页图片
//    public void getWelcomeOpenImg(Context context, Map<String, String> map, Observer<WelcomeModel> observer) {
//        setSubscribe(context, service.getWelcomeOpenImg(map), observer);
//    }
//
//    //首页广告弹窗
//    public void getHomeAppPopImg(Context context, Map<String, String> map, Observer<HomeAppPop> observer) {
//        setSubscribe(context, service.getHomeAppPopImg(map), observer);
//    }
//
//    //免费领取油卡
//    public void getFreeReceiveOil(Context context, Map<String, String> map, Observer<FreeReceiveOilModel> observer) {
//        setSubscribe(context, service.getFreeReceiveOil(map), observer);
//    }
//
//    //首页商品
//    public void getHomeMallList(Context context, Map<String, String> map, Observer<HomeMallModel> observer) {
//        setSubscribe(context, service.getHomeMallList(map), observer);
//    }
//
//    //商品类型
//    public void getMallTypeList(Context context, Map<String, String> map, Observer<MallTypeModel> observer) {
//        setSubscribe(context, service.getMallTypeList(map), observer);
//    }
//
//    //商品类型
//    public void getMallTypeData(Context context, Map<String, String> map, Observer<HomeMallModel> observer) {
//        setSubscribe(context, service.getMallTypeData(map), observer);
//    }
//
//    //提交领取油卡
//    public void commit(Context context, Map<String, String> map, Observer<MallOrderModel> observer) {
//        setSubscribe(context, service.commit(map), observer);
//    }
//
//    //提交领取油卡
//    public void getTopMenuIcon(Context context, Map<String, String> map, Observer<TopMenuIconModel> observer) {
//        setSubscribe(context, service.topMenuIcon(map), observer);
//    }
}
