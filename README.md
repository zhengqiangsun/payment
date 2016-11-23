#### 统一支付客户端（支付宝、微信支付）
- 支付宝-即时到账交易接口
- 支付宝-即时到账退款接口
- 微信-统一下单接口
- 微信-申请退款接口

##### 使用示例


```
1.支付宝-即时到账交易接口
AlipayClient client = new DefaultAlipayClient(partner, privateKey, notifyUrl);//新建支付宝交易客户端 参数（合作者身份ID、私钥、回调接口地址）
AlipayTradeDirectPayRequest directPayReq = new AlipayTradeDirectPayRequest();//创建即时到账请求对象
JSONObject content = new JSONObject();//注意，参数要使用字符串类型
content.put("out_trade_no", "商户网站唯一订单号");
content.put("subject", "主题");
content.put("payment_type", "1");//支付类型，默认1
content.put("total_fee", "交易金额");
content.put("seller_email", "卖家支付宝账号");
directPayReq.setBizContent(content.toJSONString());//设置内容
String directPayFormHtml = client.specialExecute(directPayReq);//返回支付html内容，写入前端页面即可完成跳转

2.支付宝-即时到账有密退款接口
AlipayClient client = new DefaultAlipayClient(partner, privateKey, notifyUrl);//新建支付宝交易客户端 参数（合作者身份ID、私钥、回调接口地址）
AlipayTradePwdRefundRequest refundReq = new AlipayTradePwdRefundRequest();
JSONObject content = new JSONObject();
content.put("seller_user_id", "同合作者身份ID");
content.put("refund_date","退款请求时间");
content.put("batch_no","退款批次号");
content.put("batch_num", "总笔数");
content.put("detail_data", "单笔数据集");// 例如:"2016112221001004340232382403"+"^"+"0.01"+"^"+"退款" ，多笔使用#分割
refundReq.setBizContent(content.toJSONString());
String formHtml = client.specialExecute(refundReq);//返回支付html内容，写入前端页面即可完成跳转

```


```
1.微信支付-统一下单
String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单地址
WxPayClient client = new DefaultWxPayClient(url, appId, mchId, privateKey);//构造函数 公众账号ID、商户号、私钥
WxPayTradeCreateRequest creq = new WxPayTradeCreateRequest();
JSONObject bizContent = new JSONObject();
bizContent.put("body", "商品描述");
bizContent.put("out_trade_no", "商户订单号");
bizContent.put("total_fee", "商品总价,分为单位");
bizContent.put("spbill_create_ip", "用户请求ip");
bizContent.put("trade_type", "NATIVE");//Native 扫码支付，详情参看微信API
bizContent.put("notify_url", "支付成功后回调地址");

creq.setBizContent(bizContent.toJSONString());
WxPayTradeCreateResponse crsp = orderClient.execute(creq);//统一支付回调结果对象

2.微信支付-退款（需要证书）
WxPayClient client  = new DefaultWxPayClient(url, appId, mchId, privateKey);//同上
WxPayTradeRefundRequest request = new WxPayTradeRefundRequest();//退款请求对象
JSONObject bizContent = new JSONObject();//退款请求
bizContent.put("transaction_id", "微信支付流水号");
bizContent.put("out_refund_no", "商户退款单号");
bizContent.put("total_fee", "总金额");
bizContent.put("refund_fee", "退款总金额");
bizContent.put("op_user_id", "操作员ID");
request.setBizContent(bizContent.toJSONString());//设置退款
WxPayTradeRefundResponse rsp = client.execute(request,"证书地址","证书密码");//请求,通常java使用p12的证书，密码默认为商户id

```

