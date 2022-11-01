# 核酸信息采集系统

## 一. 准备：

### 1.工具选型

后端工具：idea 2022.2.3  
前端工具： VSCode 1.72.2  
数据库：MySql 8.0
Maven：3.6.3  
git: 2.35.1

### 2.框架选型

后端框架：SpringBoot 2.3.7  
后端持久框架：Mybatis
前端框架：Vue 3  
前端UI框架：Vant UI

## 二. 设计：

### 功能设计：

#### 采集人员APP：

登录，注册，选择采集点，开箱(转运箱码)，选择检测方式，添加试管(试管码)，添加用户(客户端APP用户二维码)，封箱。

#### 用户APP：

登录，注册，展示信息码

#### 转运人员APP(可选):

#### 检测机构(可选)：

#### 城市运营端(可选)：

### 数据库设计：

采集人员表： ID，姓名，身份证，手机号，地区。  
被采集人员表：ID，姓名，身份证，手机号。  
转运箱表：ID，转运箱码，日期。  
试管表：ID，试管码，转运箱码，日期，状态。  
转运箱试管关联表：ID，转运箱号，试管号。  
试管被采集人员关联表：ID，试管号，人员ID。

核酸结果表(可选)

## 三.实现

### 1.后端项目结构

### 2.前端项目结构