package com.qzy.laobiao.common.net;


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
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * artifact  接口
 */

interface NetService {

    // 登录
    @POST("/account/loginOrRegister")
    Observable<LoginModel> goLogin(@Body User user);

    // 注册
    @POST("/account/register")
    Observable<LoginModel> getRegister(@Body User user);

    // 获取验证码
    @POST("/auth/getVerifyCode")
    Observable<YzCodeModel> checkPhoneCode(@Body YzCode yzCode);

    // 图片上传
    @POST("/auth/uploadFile")
    Observable<LoginModel> getUploadImg(@Body UserIconModel userIconModel);

    // 创建唯一文件名
    @POST("/auth/createVodAuth")
    Observable<FileModel> getFileName(@Body CreateFlie createFlie);

    // 点赞
    @POST("/api/video/praiseVideo")
    Observable<FileModel> getGiveLike();

    //获取用户信息
//    @POST("/api/account/getAccountInfo")
//    Observable<UserInfoModel> getUserInfo();
    //获取用户信息
    @FormUrlEncoded
    @POST("/api/account/getAccountInfo")
    Observable<UserInfoModel> getMineInfo(@FieldMap Map<String, String> map) ;

    // 获取首页视频
    @POST("/api/video/findHomeVideo")
    Observable<UserInfoModel> getHomeVideo();

    // 获取好友视频
//    @POST("/api/video/findFriendsVideo")
//    Observable<VideoIdModel> getUploadVideo();

    // 上传自己视频
    @POST("/api/video/insertSelfVideo")
    Observable<VideoIdModel> getUploadVideo(@Body OldVideoBean oldVideoBean);


//    // 检查手机号是否存在
//    @FormUrlEncoded
//    @POST("/hykweb/f/app/checkPhone")
//    Observable<BaseModel> checkPhone(@FieldMap Map<String, String> map);
//
//    // 检查短信是否输入正确
//    @FormUrlEncoded
//    @POST("/hykweb/f/app/checkCode")
//    Observable<BaseModel> checkPhoneCode(@FieldMap Map<String, String> map);
//
//    // 检查短信是否输入正确
//    @FormUrlEncoded
//    @POST("/hykweb/f/app/getCode")
//    Observable<BaseModel> getRegisterCode(@FieldMap Map<String, String> map);
//
//
//    // 修改登录密码
//    @FormUrlEncoded
//    @POST("/hykweb/f/app/updatepwd")
//    Observable<BaseModel> getSetLoginPwd(@FieldMap Map<String, String> map);
//
//    // 首页充值消息
//    @FormUrlEncoded
//    @POST("/hykweb/index/loops")///hykweb/index/loop
//    Observable<HomeLoopModel> getHomeLoop(@FieldMap Map<String, String> map);
//
//    // 首页充值消息
//    @FormUrlEncoded
//    @POST("/hykweb/index/banner2")
//    Observable<HomeBannerModel> getHomeBanner(@FieldMap Map<String, String> map);
//
//    // 首页充值套餐
//    @FormUrlEncoded
//    @POST("/hykweb/index/goods")
//    Observable<HomeModel> getHomeRecharge(@FieldMap Map<String, String> map);
//
//    // 首页充值套餐
//    @FormUrlEncoded
//    @POST("/hykweb/index/goodsNew")
//    Observable<HomeModel> getHomeNewRecharge(@FieldMap Map<String, String> map);
//
//    // 首页按钮
//    @FormUrlEncoded
//    @POST("/hykweb/index/buttons")
//    Observable<HomeCardvMode> getHomeNewCardView(@FieldMap Map<String, String> map);
//
//    //充值套餐  即时充值
//    @FormUrlEncoded
//    @POST("/hykweb/details/goods")
//    Observable<HomeModel> getRechargeList(@FieldMap Map<String, String> map);
//
//    // 即时充值
//    @FormUrlEncoded
//    @POST("/hykweb/mine/recharge")
//    Observable<RechargeOrderModel> getRecharge(@FieldMap Map<String, String> map);
//
//    // 套餐充值
//    @FormUrlEncoded
//    @POST("/hykweb/mine/packageRecharge")
//    Observable<RechargeOrderModel> getRechargePackage(@FieldMap Map<String, String> map);
//
//    // 我的
//    @FormUrlEncoded
//    @POST("/hykweb/mine/oilCard")
//    Observable<MineModel> getMine(@FieldMap Map<String, String> map);
//
//    // 添加加油卡
//    @FormUrlEncoded
//    @POST("/hykweb/mine/addOilCard")
//    Observable<BaseModel> getAddOil(@FieldMap Map<String, String> map);
//
//    // 添加加油卡
//    @FormUrlEncoded
//    @POST("/hykweb/mine/delOilCard")
//    Observable<BaseModel> getDeleteOilCard(@FieldMap Map<String, String> map);
//
//    // 所有红包
//    @FormUrlEncoded
//    @POST("/hykweb/mine/allRedPackage")
//    Observable<CouponsListModel> getAllCouponsList(@FieldMap Map<String, String> map);
//
//    // 可用红包
//    @FormUrlEncoded
//    @POST("/hykweb/mine/redPackage")
//    Observable<CouponsListModel> getUseCoupons(@FieldMap Map<String, String> map);
//
//    // app版本
//    @FormUrlEncoded
//    @POST("/hykweb/app/version")
//    Observable<AppSettingModel> getAppVersion(@FieldMap Map<String, String> map);
//
//    // 个人中心
//    @FormUrlEncoded
//    @POST("/hykweb/mine/info")
//    Observable<MineInfoModel> getMineInfo(@FieldMap Map<String, String> map);
//
//    // 修改性别 生日
//    @FormUrlEncoded
//    @POST("/hykweb/mine/updateInfo")
//    Observable<BaseModel> getUpdateMineInfo(@FieldMap Map<String, String> map);
//
//    // 修改生日
//    @FormUrlEncoded
//    @POST("/hykweb/mine/updateBirthday")
//    Observable<BaseModel> getUpdateBirthdayMineInfo(@FieldMap Map<String, String> map);
//
//    //我的积分
//    @FormUrlEncoded
//    @POST("/hykweb/point/pointDetail")
//    Observable<MineIntegralModel> getIntegralUsage(@FieldMap Map<String, String> map);
//
//    // 加油计划
//    @FormUrlEncoded
//    @POST("/hykweb/mine/oilPlanNew")
//    Observable<OilPlanModel> getOilPlan(@FieldMap Map<String, String> map);
//
//    // 加油计划弹窗
//    @FormUrlEncoded
//    @POST("/hykweb/mine/oilManager")
//    Observable<DialogOilPlanTime> getOilPlanTime(@FieldMap Map<String, String> map);
//
//    // 全部订单
//    @FormUrlEncoded
//    @POST("/hykweb/mine/allOrder")
//    Observable<OrderListModel> getOrderList(@FieldMap Map<String, String> map);
//
//    // 油卡充值记录
//    @FormUrlEncoded
//    @POST("/hykweb/mine/allSuccessOrder")
//    Observable<OrderListModel> getOilOrderRecordList(@FieldMap Map<String, String> map);
//
//    // app版本
//    @FormUrlEncoded
//    @POST("/hykweb/order/seeOrder")
//    Observable<OrderDetailsModel> getOrderDetails(@FieldMap Map<String, String> map);
//
//    // 收货地址
//    @FormUrlEncoded
//    @POST("/hykweb/mine/seeAddress")
//    Observable<AddressListModel> getAddressList(@FieldMap Map<String, String> map);
//
//    // 添加收货地址
//    @FormUrlEncoded
//    @POST("/hykweb/mine/addAddress")
//    Observable<BaseModel> getAddressAdd(@FieldMap Map<String, String> map);
//
//    // 修改收货地址
//    @FormUrlEncoded
//    @POST("/hykweb/mine/updateAdd")
//    Observable<BaseModel> getAddressModify(@FieldMap Map<String, String> map);
//
//    // 删除收货地址
//    @FormUrlEncoded
//    @POST("/hykweb/mine/delAdd")
//    Observable<BaseModel> getAddressDelete(@FieldMap Map<String, String> map);
//
//    // 官方公告
//    @FormUrlEncoded
//    @POST("/hykweb/mine/notice")
//    Observable<NoticeModel> getNoticeList(@FieldMap Map<String, String> map);
//
//    // 消息中心
//    @FormUrlEncoded
//    @POST("/hykweb/mine/newestTitle")
//    Observable<MessageCenterModel> getNewNotice(@FieldMap Map<String, String> map);
//
//    // 邀请人
//    @FormUrlEncoded
//    @POST("/hykweb/mine/inviterUser")
//    Observable<InvitationListModel> getInvitationList(@FieldMap Map<String, String> map);
//
//    //活动--只返回有效活动
//    @FormUrlEncoded
//    @POST("/hykweb/find/wondefulImg")
//    Observable<ActivitiesCenterModel> getFindList(@FieldMap Map<String, String> map);
//
//    // 活动中心
//    @FormUrlEncoded
//    @POST("/hykweb/find/wondefulImgAll")
//    Observable<ActivitiesCenterModel> getActivitiesList(@FieldMap Map<String, String> map);
//
//    // 油价
//    @FormUrlEncoded
//    @POST("/hykweb/find/oilPrice")
//    Observable<OilPriceModel> getOilPrice(@FieldMap Map<String, String> map);
//
//    //新闻
//    @FormUrlEncoded
//    @POST("/hykweb/find/allNews")
//    Observable<NewsModel> getAllNews(@FieldMap Map<String, String> map);
//
//    //新闻
//    @FormUrlEncoded
//    @POST("/hykweb/find/getOneNews")
//    Observable<OneNewModel> getOneNews(@FieldMap Map<String, String> map);
//
//    // 连连支付
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/pay/createOrder")
//    Observable<LianLianPayModel> getRechargePay(@FieldMap Map<String, String> map);
//    // 余额支付
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/pay/createOrderYEPay")
//    Observable<LianLianPayModel> getRechargePay_ye(@FieldMap Map<String, String> map);
//
//    // 支付宝--油卡充值
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/pay/createOrderAliPay")
//    Observable<ZFBPayModel> getRechargeOilZFBPay(@FieldMap Map<String, String> map);
//
//    // 支付宝 --- 实物商品
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/payShop/createShopOrderAliPay")
//    Observable<ZFBPayModel> getRechargeZFBPay(@FieldMap Map<String, String> map);
//
//    // 微信 --- 油卡充值
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/pay/createOrderWxPay")
//    Observable<WXPayModel> getRechargeOilWXPay(@FieldMap Map<String, String> map);
//
//    // 微信 --- 实物商品
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/payShop/createShopOrderWxPay")
//    Observable<WXPayModel> getRechargeWXPay(@FieldMap Map<String, String> map);
//
//    // 积分---实物商品
//    @FormUrlEncoded
//    @POST("/hykweb/shop/downOrderPoint")
//    Observable<WXPayModel> getPointPay(@FieldMap Map<String, String> map);
//
//    // 意见反馈
//    @FormUrlEncoded
//    @POST("/hykweb/mine/opinion")
//    Observable<BaseModel> getSuggest(@FieldMap Map<String, String> map);
//
//    // 站内信标题
//    @FormUrlEncoded
//    @POST("/hykweb/msg/newTitle")
//    Observable<MessageNewModel> getNewMessage(@FieldMap Map<String, String> map);
//
//    // 站内信
//    @FormUrlEncoded
//    @POST("/hykweb/msg/getAll")
//    Observable<MessageListModel> getMessageList(@FieldMap Map<String, String> map);
//
//    // 站内信-全部标记已读
//    @FormUrlEncoded
//    @POST("/hykweb/msg/updateAll")
//    Observable<BaseModel> getUpdateMessage(@FieldMap Map<String, String> map);
//
//    // 站内信-单条已读
//    @FormUrlEncoded
//    @POST("/hykweb/msg/updateOne")
//    Observable<BaseModel> getUpdateOneMessage(@FieldMap Map<String, String> map);
//
//    // 余额充值
//    @FormUrlEncoded
//    @POST("/hykweb/balance/recharge")
//    Observable<BaseModel> getBalanceRecharge(@FieldMap Map<String, String> map);
//
//    // 余额充值
//    @FormUrlEncoded
//    @POST("/hykweb/balance/rechargeRecord")
//    Observable<BalanceRecordModel> getBalanceRechargeRecord(@FieldMap Map<String, String> map);
//
//    // 商城列表
//    @FormUrlEncoded
//    @POST("/hykweb/shop/allMallGoodsToAndroid")
//    Observable<MallModel> getMallList(@FieldMap Map<String, String> map);
//
//    // 商城banner
//    @FormUrlEncoded
//    @POST("/hykweb/shop/banner")
//    Observable<MallBannerModel> getMallBanner(@FieldMap Map<String, String> map);
//
//    // 商城详情
//    @FormUrlEncoded
//    @POST("/hykweb/shop/seeMallGoods")
//    Observable<MallDetailsModel> getMallDetails(@FieldMap Map<String, String> map);
//
//    // 商城--下单
//    @FormUrlEncoded
//    @POST("/hykweb/shop/downOrder")
//    Observable<MallOrderModel> getMallOrder(@FieldMap Map<String, String> map);
//
//    // 商城--油卡下单
//    @FormUrlEncoded
//    @POST("/hykweb/shop/downOrderOilCard")
//    Observable<MallOrderModel> getMallOilOrder(@FieldMap Map<String, String> map);
//
//    // 查看商城订单
//    @FormUrlEncoded
//    @POST("/hykweb/shop/seeOrder")
//    Observable<MallOrderCheckStandModel> getLookMallOrder(@FieldMap Map<String, String> map);
//
//    // 商城支付
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/payShop/createShopOrder")
//    Observable<LianLianPayModel> getPayMallOrder(@FieldMap Map<String, String> map);
//
//    // 商城所有订单
//    @FormUrlEncoded
//    @POST("/hykweb/shop/allOrder")
//    Observable<MallOrderListModel> getMallAllOrder(@FieldMap Map<String, String> map);
//
//    //获取一条收货地址
//    @FormUrlEncoded
//    @POST("/hykweb/mine/getOneAddress")
//    Observable<MallOneAddress> getMallOneAddress(@FieldMap Map<String, String> map);
//
//    //欢迎页图片
//    @FormUrlEncoded
//    @POST("/hykweb/index/openImg")
//    Observable<WelcomeModel> getWelcomeOpenImg(@FieldMap Map<String, String> map);
//
//    //首页广告弹窗
//    @FormUrlEncoded
//    @POST("/hykweb/index/appImg")
//    Observable<HomeAppPop> getHomeAppPopImg(@FieldMap Map<String, String> map);
//
//    //免费领取油卡
//    @FormUrlEncoded
//    @POST("/hykweb/f/web/oil/oilPage")
//    Observable<FreeReceiveOilModel> getFreeReceiveOil(@FieldMap Map<String, String> map);
//
//    // 首页商品
//    @FormUrlEncoded
//    @POST("/hykweb/shop/indexGoods")
//    Observable<HomeMallModel> getHomeMallList(@FieldMap Map<String, String> map);
//
//    // 商品类型
//    @FormUrlEncoded
//    @POST("/hykweb/shop/allCategory")
//    Observable<MallTypeModel> getMallTypeList(@FieldMap Map<String, String> map);
//
//    // 商品类型--列表
//    @FormUrlEncoded
//    @POST("/hykweb/shop/allGoodsByCategoryById")
//    Observable<HomeMallModel> getMallTypeData(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("/hykweb/shop/downOrderOilCard")
//    Observable<MallOrderModel> commit(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("/hykweb/icon/findAllIcon")
//    Observable<TopMenuIconModel> topMenuIcon(@FieldMap Map<String, String> map);

}
