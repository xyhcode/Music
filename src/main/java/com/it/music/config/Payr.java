package com.it.music.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

public class Payr {
    public static void main(String[] args)  {
        /** 支付宝网关 **/
        String URL = "https://openapi.alipaydev.com/gateway.do";

        /** 应用id**/
        String APP_ID = "2021000117669996";

        /** 应用私钥**/
        String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDEhRyvHmoRQFQTTQK+O9FwT/O4o6ircsvjc0Tg6+IIUGKLZWw4KnlcZxkR+BUPhifNWl8Rm/jTtlyD+Na1SVNaDTaEbC4nzkJjfBtiq5JVRqNb6THhMolF0pivcTehskEzIfBHmzBbDOlpiLHiwbc79MhSmooj4PsbE2HhOdf3tyxaF5maPycfHJvpqw/WtiXkRAybtc0Jf2QjA+seSRLrbE/ClkOHvTZsMsPcxfpqvOvuQt/OMQixE/KeBEu4yhwe3wpzRZ7FOAcCbtaMFPTsHz2c9JHWcx/fXxxLtWh5dxMaiIMhWS8QGUT1LOxxTcdiR0tQNNei3hXOL1v5YhyhAgMBAAECggEBAIQ0rLReuKp8ZVNKtrK12VM+Zk7rwtf8dY/Bhy/tYHWJZpIynBg48sYoEaSWCc0UyogK6PQWwtHi1+BssjzpZGqrguaZRH/A8catwlqh4+L8j3+QpN7EObdAUzmL6AoeumAkz9nMXD6UtB4sOMe83IE4Tt/LWW2DuEphwrJbUKAza5Wv0CazWYRaA4LAx+/R9IfD/UH+sVWw+/61e2A6pG6T3JG+Slp1mNGkOmsd/qk2aJ90LyGnNSh+1uixTYLXpqKGjhn9Gp7Od04LPnCB/73sX2xPP6QYcmNTYYQIyyY0j8VkGeugaeoF1KLx25unaK04IP1pNRrOYYxjHNrsDMECgYEA4gYy4Kn2ItfJTgq1iMzZ0RmCCgV7IbcPx5z+NDAYcd6Vvo6FNR8DY2fJ8EQUf2asD1NRngjzUK9gs5buFPpa/UuRoNOE4hABZYLioLt9adCTyUBfwH1Vmc77cwp7gXIlQNYR4f3RpWtXAc7d+Gm+xRFOcxUZx2TtxoDGdvnbRZkCgYEA3pU1LuM5QD/NkLjHsvdugZiayZjEUg03MS0HtKfulTWk4u/k4V64v5xYo0prjJFKJKh6dC1WQIeA9E0ywdGeGnO+qF78l5f4wEH9j4gRKGMS1d18cszF8r0V7+Y4WGM+NRTnUyR60YTZH80lz7mGnGvZ5qOquSslcUKAXNw35EkCgYAysMU0UancAp0pHYm9FoQ7OwdJDBWjaBTn5bO1LJwu3Yaj5/7D/SKbZqmJcxtNv08TWNJTKRq4m7yKSm020zcY25vbf9Srhn9prsL43VOxKZAbcI6I8xMBncQS9uTgESN9uQTltDESclJfG2/4yG56b/kyIidX6rDQ9gyMnlio8QKBgQCkKcgf3NbM3EHxC1e+V1/ZlYQUS+f/3F9olZ2pUHJW+kmyVtyonAQGznlRdgH8muvkPZ6TMRz8WvRxOr7E1KWXPObRp70E0cFVi1ZIFkMRVoD92219/inA7lTPqyzDg+7Nl61FVRKAlUrOea/5lQwDMkh0IyI3j+r9rd6eno1agQKBgQCZNgohdF0mIJVAQaQs8n/yA7UC813fMsBJWMHKCnFnj1vumzIxnjMBjScW8+N60OvlPVHF6+zlaxk6Sc2w+pZaaLr2Di3lUhjMnq2e+zASSWahkoOsIXdELTpdZcND5b2j/Ks7whdwRUM+uxrIpAfnYh1Z13IyCHUUXknDAJSvMg==";

        /** 支付宝公钥**/
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwuK1cC7mMdbfhQ8bpyuNLhXspyhHX1r0fNwO917i//RRpyps/4PixQnrUTYPCdayCsXU75p1gVRNwzwdWQNL1343X2XRUYrgaO1fs3IulFxt1CLNzy8r/0uct9Dk3EYgHOazhCYqA6wmY4N0bOsDhcC3SWIGCU+ONlKkNnt4AWl6L0zHjaoVuiqZFlhacxdZ+VadSueKCYuYDdPb0XzUP/d6clt751womVJCH8hgQmY1EnxQUEJx1/mFyyHx1XCcjuykE9TH71SciF24l5PvkRCoKTRGLrnDrZaMxUQvR1sYajrKZcguWwmJufVc7fqx50gI9BliDTF8VB8PtjFdgwIDAQAB";

        /** 初始化 **/
        AlipayClient alipayClient = new DefaultAlipayClient(URL,APP_ID,APP_PRIVATE_KEY,"json","UTF-8",ALIPAY_PUBLIC_KEY,"RSA2");

        /** 实例化具体API对应的request类，类名称和接口名称对应,当前调用接口名称：alipay.trade.precreate（统一收单线下交易预创建（扫码支付）） **/
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        /** 设置业务参数  **/
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();

        /** 商户订单号，商户自定义，需保证在商户端不重复，如：20200612000001 **/
        model.setOutTradeNo("20200612000001");

        /** 销售产品码，固定值：FACE_TO_FACE_PAYMENT **/
        model.setProductCode("FACE_TO_FACE_PAYMENT");

        /**订单标题 **/
        model.setSubject("测试");

        /** 订单金额，精确到小数点后两位 **/
        model.setTotalAmount("0.01");

        /** 订单描述 **/
        model.setBody("没有");

        /** 将业务参数传至request中 **/
        request.setBizModel(model);

        /** 异步通知地址，以http或者https开头的，商户外网可以post访问的异步地址，用于接收支付宝返回的支付结果，如果未收到该通知可参考该文档进行确认：https://opensupport.alipay.com/support/helpcenter/193/201602475759 **/
        request.setNotifyUrl("");

        AlipayTradePrecreateResponse response = null;
        try {
            /** 通过alipayClient调用API，获得对应的response类  **/
            response = alipayClient.execute(request);

        } catch (AlipayApiException e) {

            e.printStackTrace();
        }
        System.out.println(response.getBody());
        //返回结果中有二维码链接 将二维码链接使用hutools生成二维码图片
    }
}
