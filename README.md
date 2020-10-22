# 一个超赞的Kotlin扩展库

![MIT](https://img.shields.io/badge/License-MIT-orange?style=flat-square)  ![Jcenter](https://img.shields.io/badge/Jcenter-x.y.z-brightgreen?style=flat-square)  ![Androidx](https://img.shields.io/badge/Androidx-Yes-blue?style=flat-square)  ![Api](https://img.shields.io/badge/Api-14+-blueviolet?style=flat-square) 

## 导入依赖

```groovy
implementation 'me.simple:nice-ktx:1.0.0'
```

## ActivityKTX

* startActivity()：跳转Activity

## BitmapKTX

* Bitmap.saveFile()：保存位图到本地文件
* Bitmap.base64()：获取位图的base64

## ContextKTX

* isConnected()： 网络是否连接
* Context.activity： 从Context获取Activity
* Context.screenWidth： 屏幕宽度
* Context.screenHeight： 屏幕高度
* openWeb() ：打开网页
* sendEmail() ：发送Email
* openMarket() ：打开应用商店，推荐使用我的另外一个开源库：[MarketHelper](https://github.com/simplepeng/MarketHelper)
* copyText() ：复制文本

## DateKTX

* Long.toDateString() : 毫秒转时间字符串
* String.toMillis() ：时间字符串转毫秒

## DensityKTX

* (Int/Long/Double/Float).dp ：dp 转 px
* (Int/Long/Double/Float).sp ：sp 转 px 

## EditTextKTX

* isEmpty() ： EditText的文本为空
* selectionEnd() ： 将光标移动至末尾
* setTextAndSelectionEnd() ：设置文字，并将将光标移动至末尾
* listenerTextChange() ：监听文本变化

## SecureKTX

* String?.md5 ：字符串转MD5
* File?.md5 ： 文件的MD5
* String.sha1 ： 字符串转sha1

## TextViewKTX

* clearText() ： 清空文本

## ToastKTX

* toast() ： 短吐司
* longToast() ：长吐司

## ViewKTX

* gone() ： 隐藏View
* visible() ： 显示View
* invisible() ：隐藏View，保留位置
* getActivity() ：从View的Context中获取Activity
* click() ：点击事件
* singleClick() ：防抖动单击事件

### 版本迭代

* v1.0.0：首次上传

## EventBusKTX

```groovy
implementation 'me.simple:eventbus-ktx:1.0.1'
```

* registerOnCreate() //在onCreate中注册事件，自动在onDestroy中注销事件
* registerOnStart() //在onStart中注册事件，自动在onStop中注销事件
* registerOnResume() //在onResume中注册事件，自动在onPause中注销事件
* safeRegister() //安全调用注册方法
* safeUnregister() //安全调用注销方法

### 版本迭代

* v1.0.2：增加安全调用方法

* v1.0.1：去除`BuildConfig.class`

* v1.0.0：首次上传


