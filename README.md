# 一个超赞的Kotlin扩展库

![MIT](https://img.shields.io/badge/License-MIT-orange?style=flat-square) [![](https://jitpack.io/v/simplepeng/NiceKTX.svg)](https://jitpack.io/#simplepeng/NiceKTX)  ![Androidx](https://img.shields.io/badge/Androidx-Yes-blue?style=flat-square)  ![Api](https://img.shields.io/badge/Api-14+-blueviolet?style=flat-square) 

## 导入依赖

```groovy
maven { url 'https://jitpack.io' }
```

```groovy
//版本号
def nice_ktx = "v1.0.3"
//常用的扩展函数
implementation "com.github.simplepeng.NiceKTX:nice_ktx:$nice_ktx"
//EventBus的扩展
implementation "com.github.simplepeng.NiceKTX:eventbus_ktx:$nice_ktx"
//协程的扩展
implementation "com.github.simplepeng.NiceKTX:coroutine_ktx:$nice_ktx"
```

### ActivityKT

```kotlin
startActivity() //跳转Activity
```

### AnyKT

```kotlin
isNull()        //是否为空
isNotNull()     //是否不为空
```

### BitmapKT

```kotlin
saveFile()                  //保存位图到本地文件
base64()                    //获取位图的base64
String.toBimtp()            //base64转Bitmap
scale(sx,sy)                //按比例缩放Bitmap
scale(newWidth,newHeight)   //按大小缩放Bitmap
addWatermark()              //添加水印
```

### CanvasKT

```kotlin
drawTextOnTop()         //画文字-以顶部为基准线
drawTextOnBottom()      //画文字-以底部为基准线
drawTextOnCenter()      //画文字-以中心点为基准
```

### CharSequenceKT

```kotlin
isNotNullAndEmpty() //判断字符串不是null也不是empty
```

### ContextKT

```kotlin
isConnected()           //网络是否连接
Context.activity        //从Context获取Activity
Context.screenWidth     //屏幕宽度
Context.screenHeight    //屏幕高度
openWeb()               //打开网页
sendEmail()             //发送Email
openMarket()            //打开应用商店，推荐使用我的另外一个开源库：[MarketHelper](https://github.com/simplepeng/MarketHelper)
copyText()              //复制文本
```

### DateKT

```kotlin
Long.toDateString()     //毫秒转时间字符串
String.toMillis()       //时间字符串转毫秒
```

### DefaultKT

```kotlin
Boolean?.orDefault()        //布尔值的默认值填充
String?.orDefault()         //字符串的默认值填充
T?.orDefault()              //默认值填充
```

### DensityKT

```kotlin
(Int/Long/Double/Float).dp              //dp 转 px
(Int/Long/Double/Float).sp              //sp 转 px 
(Context/Fragment/Dialog/View/Resources).dp2px()      //
(Context/Fragment/Dialog/View/Resources).px2dp()      //
```

### EditTextKT

```kotlin
isEmpty()                   //EditText的文本为空
selectionEnd()              //将光标移动至末尾
setTextAndSelectionEnd()    //设置文字，并将将光标移动至末尾
listenerTextChange()        //监听文本变化
```

### SecureKT

```kotlin
String?.md5     //字符串转MD5
File?.md5       //文件的MD5
String.sha1     //字符串转sha1
```

### TextViewKT

```kotlin
clearText()                 //清空文本
setTextColor("#000000")     //设置文字颜色
```

### ToastKT

```kotlin
toast()     //短吐司
longToast() //长吐司
```

### ViewKT

```kotlin
gone()          //隐藏View
visible()       //显示View
invisible()     //隐藏View，保留位置
getActivity()   //从View的Context中获取Activity
click()         //点击事件
singleClick()   //防抖动单击事件
```

### UriKT

```kotlin
Int.toUri()                 //将res-raw目录下的资源转换成Uri
Context.rawIdToUri()        //将res-raw目录下的资源转换成Uri
```

### WebViewKT

```kotlin
loadAsset()     //加载asset目录下的html文件
callJsMethod()  //调用js的方法
```

### EventBusKT

```kotlin
registerOnCreate()  //在onCreate中注册事件，自动在onDestroy中注销事件
registerOnStart()   //在onStart中注册事件，自动在onStop中注销事件
registerOnResume()  //在onResume中注册事件，自动在onPause中注销事件
safeRegister()      //安全调用注册方法
safeUnregister()    //安全调用注销方法
```

### RecyclerViewKT

```kotlin
linear()
grid()
staggered()
```

 ### ViewPagerKT

```kotlin
//同时支持ViewPage2
nextPage()  //下一页
prePage()   //上一页
```

## 版本迭代

* v1.0.3：更新gradle版本，适配java11
* v1.0.2：增加`EventBus`安全调用方法，上传至`jitpack`
* v1.0.1：去除`BuildConfig.class`
* v1.0.0：首次上传

