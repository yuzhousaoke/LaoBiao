package com.qzy.laobiao.mine.model;


import com.qzy.laobiao.common.base.BaseModel;

public class UserInfoModel extends BaseModel {
    private UserInfoData body;

    public UserInfoData getBody() {
        return body;
    }

    public void setBody(UserInfoData body) {
        this.body = body;
    }

    public class UserInfoData{
        private AccountData account;
        private String browser;
        private String expireTime;
        private String ipaddr;
        private String loginLocation;

        public AccountData getAccount() {
            return account;
        }

        public void setAccount(AccountData account) {
            this.account = account;
        }

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getIpaddr() {
            return ipaddr;
        }

        public void setIpaddr(String ipaddr) {
            this.ipaddr = ipaddr;
        }

        public String getLoginLocation() {
            return loginLocation;
        }

        public void setLoginLocation(String loginLocation) {
            this.loginLocation = loginLocation;
        }

        public String getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime = loginTime;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        private String loginTime;
        private String os;
        private String platform;
        private String uuid;


        public class AccountData{
            private String accountName; //老表视频号
            private String area; //所在地区
            private String createTime;
            private String des; //描述
            private String id; //自增id
            private String identityAuth;//身份认证U普通用户G官方用户V认证用户S商家用户E政府机构
            private String identityName; //认证名称
            private String inviteCode; //邀请码
            private String logo; //头像
            private String mobile; //注册手机号

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIdentityAuth() {
                return identityAuth;
            }

            public void setIdentityAuth(String identityAuth) {
                this.identityAuth = identityAuth;
            }

            public String getIdentityName() {
                return identityName;
            }

            public void setIdentityName(String identityName) {
                this.identityName = identityName;
            }

            public String getInviteCode() {
                return inviteCode;
            }

            public void setInviteCode(String inviteCode) {
                this.inviteCode = inviteCode;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public UserStatus getRelationStatus() {
                return relationStatus;
            }

            public void setRelationStatus(UserStatus relationStatus) {
                this.relationStatus = relationStatus;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            private String nickName; //昵称
            private UserStatus relationStatus; //
            private String status; //0正常1冻结2删除

            private class UserStatus{
                private String fansStatus;
                private String followsStatus;

            }
        }
    }
}
