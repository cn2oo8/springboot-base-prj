# molicode 基础工程

本工程主要用于作为一个脚手架工程，将常用的工具和一些业务常量配置到系统中。通过molicode工具生成的代码到工程中，应该免配置或者少量配置之后是可以直接运行的。


## 可适配的模板引擎
示例模板：
git地址：
[https://gitee.com/molicode_repo/autocode-template-example](https://gitee.com/molicode_repo/autocode-template-example)

分支：d_20190731_iviewslot

请选择其中的：autocode-template-selfsdk	

其主要特性和molicode工具的底层架构是基本一致的。


## 技术栈
后台： springoot + mybatis + MySQL + SpringMVC 

前台： vue + iview admin + nodejs + webpack

## molicode替换表达式

如下：

新建一个usercenter的项目， maven的artifact前缀为：usercenter-***

包路径以： com.shareyi.user.center 开始；

### 替换表达式（用于文本内容替换）

```
com.shareyi.basespringboot=com.shareyi.user.center
baseproject-springboot=usercenter
```

### 目录转换表达式（用于包路径转换）

```
com/shareyi/basespringboot=com/shareyi/user/center
```

## 工程说明

```
1. baseproject-springboot-common 常用工具类，常量等；
2. baseproject-springboot-domain domain类等；
3. baseproject-springboot-dao 数据库访问层等；
4. baseproject-springboot-manager 数据库访问代理等；
5. baseproject-springboot-sdk 对外服务SDK层；
6. baseproject-springboot-service 业务服务层；
7. baseproject-springboot-web web对外服务层；
8. ui-starter ui视图层，编译后的代码推送到web层，以此对外服务，也可单独做前后台分离部署；
```


### ui-starter说明
本层为UI视图层，基于iview-admin 工程剥离出来的工程，主要使用方案请参考：
https://github.com/iview/iview-admin 相关说明；


一般使用方案为：

```bash

#从工程目录进入ui工作目录
cd ui-starter

#安装nodejs相关依赖
npm install

#执行开发
npm run dev

# 执行编译发布
npm run build
# 编译后会推送到 web层的:  src/main/resources/static 目录下；
```


