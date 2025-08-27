# 环境配置

## Java配置
利用IDEA创建项目自动下载openjdk，需要额外配置`JAVA_HOME`环境变量。
- 1 找到Java安装路径：打开IDEA，File → Project Structure → SDK Location，这里会显示JDK的安装路径
`C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54`
- 2 右键"此电脑" → 属性 → 高级系统设置 → 环境变量，在"系统变量"中点击"新建"：
  - 变量名：JAVA_HOME
  - 变量值：你的JDK安装路径，比如：C:\Program Files\Java\jdk1.8.0_291，改成你在IDEA中看到的路径
- 3 编辑Path变量：在Path中添加 %JAVA_HOME%\bin

验证配置：

```
(base) C:\Users\AFAN>echo %JAVA_HOME%
C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54

(base) C:\Users\AFAN>java -version
openjdk version "24.0.2" 2025-07-15
OpenJDK Runtime Environment (build 24.0.2+12-54)
OpenJDK 64-Bit Server VM (build 24.0.2+12-54, mixed mode, sharing)
```

## maven安装
1. 下载Maven
   访问官网下载：https://maven.apache.org/download.cgi
   下载 apache-maven-3.9.6-bin.zip（选择最新版本）

2. 解压到指定目录
   比如解压到：C:\Program Files\apache-maven-3.9.6

3. 配置环境变量
   右键"此电脑" → 属性 → 高级系统设置 → 环境变量。
   
   在"系统变量"中新建：
   - 变量名：M2_HOME 
   - 变量值：C:\Program Files\apache-maven-3.9.6
     
   编辑"Path"变量，添加：%M2_HOME%\bin

4. 验证安装
   打开命令提示符（cmd），输入：
```shell
(base) C:\Users\AFAN>mvn --version
Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
Maven home: D:\software\apache-maven-3.9.11-bin\apache-maven-3.9.11
Java version: 24.0.2, vendor: Oracle Corporation, runtime: C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54
Default locale: zh_CN, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```