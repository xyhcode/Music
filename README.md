# Music

#### 介绍
springboot模仿千千音乐

#### 软件架构
sprongboot mybatis layui jquery ajax mysql

#### 来源
[千千音乐官网](https://music.taihe.com/)

#### 项目截图
前台首页
![输入图片说明](https://images.gitee.com/uploads/images/2021/1129/164723_ac490a04_7956133.png "屏幕截图.png")
后台首页
![输入图片说明](https://images.gitee.com/uploads/images/2021/1129/164845_813bfa88_7956133.png "屏幕截图.png")

#### 使用说明
1. 下载数据库 导入数据库
2. 更改 application.properties 配置下的数据库 url、密码、驱动（此项目驱动较高 若使用8.0一下数据库 请更改驱动）
3. 项目有支付功能（当面付） 需要修改沙箱配置 PayTools.java 更改参考[支付包开放平台](https://open.alipay.com/)
4. 项目使用短信验证 UserServiceimpl.java  参考[网建短信通](https://www.smschinese.com.cn/Login.shtml) 当然可以使用其他平台短信验证
5. 图片音频资源放到腾讯云存储（COS） 修改腾讯云储存秘钥 CosFileupload.java  参考[腾讯云储存](https://cloud.tencent.com/product/cos?fromSource=gwzcw.2045291.2045291.2045291&utm_medium=cpc&utm_id=gwzcw.2045291.2045291.2045291)
6. 注册时使用图形滑块验证 需要修改滑块的地址（src/main/resources/static/login/js/jquery.js） 大概99行的位置 ，可以放到云存储下面 位置就设置云存储的访问链接即可
