package com.yc.canteen.controller;

//@Controller
public class PayController {

    private final String APP_ID = "2021000117694661";
    private final String APP_PRIVATE_KEY = "生成的应用私钥";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmi137E/OwlOb1UJoBuePLzpHgItEozGnQHPK3Y0mEWJLrpgDiE7es/lVfkTGaoUHMJaq0Bo6oZO0ad8beS6IBqstZeKcMQ9RsoDrKdwpP/LsPToN71jYoxPoiomj0jjwvbDnA+K47x9qLOcXM3LAfehdlK0tLNHmf4geoMsGL7YuWUuKujTf4q8pHeigkMc5NwlZkEuBF3Tf/k6zShBLRqnS3Zhf6ykZhtgUhUWSan4X0GBsiBt81DYOpsmS0rcE/XKUFfE8OxB2MfxKuW6Nckw1XDTFpwyWtUZ7R2NkvsISzdiMf7eVC5V+s8zqaNbbIvPvb7Pcukwv8dbGYGYseQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://公网地址/returnUrl";
    
}
