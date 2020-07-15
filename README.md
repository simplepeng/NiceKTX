# 一个超赞的Kotlin扩展库

## 原生的KTX

### ActivityKtx

|      方法名/字段名       |     注释     |
| :----------------------: | :----------: |
| Activity.startActivity() | 跳转Activity |

### BitmapKtx

|   方法名/字段名   |        注释        |
| :---------------: | :----------------: |
| Bitmap.saveFile() | 保存位图到本地文件 |
|  Bitmap.base64()  |  获取位图的base64  |

### ContextKtx

|    方法名/字段名     |         注释          |
| :------------------: | :-------------------: |
| Context.isConnected  |     网络是否连接      |
|   Context.activity   | 从Context获取Activity |
| Context.screenWidth  |       屏幕宽度        |
| Context.screenHeight |       屏幕高度        |
|                      |                       |

### DateKtx

|   方法名/字段名   |       注释       |
| :---------------: | :--------------: |
| Long.toDateString | 毫秒转时间字符串 |
|  String.toMillis  | 时间字符串转毫秒 |
|                   |                  |

### DensityKtx

|       方法名/字段名        |   注释   |
| :------------------------: | :------: |
| (Int/Long/Double/Float).dp | px to dp |
| (Int/Long/Double/Float).sp | px to sp |

### TextViewKtx

|    方法名/字段名     |   注释   |
| :------------------: | :------: |
| TextView.clearText() | 清空文本 |
|                      |          |

### ToastKtx

|    方法名/字段名    |  注释  |
| :-----------------: | :----: |
|   Context.toast()   | 短吐司 |
| Context.longToast() | 长吐司 |

### ViewKtx

|   方法名/字段名    |             注释              |
| :----------------: | :---------------------------: |
|    View.gone()     |           隐藏View            |
|   View.visible()   |           显示View            |
|  View.invisible()  |      隐藏View，保留位置       |
| View.getActivity() | 从View的Context中获取Activity |
|    View.click()    |           点击事件            |
| View.singleClick() |        防抖动点击事件         |

## 外部库的KTX

