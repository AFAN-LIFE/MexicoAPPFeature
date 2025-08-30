# 📘 `app-score` SDK 使用说明书

## 1. 简介

`app-score` 是一个用于 **计算 APP 分数** 的 SDK，由乙方提供。
甲方只需要依赖本 SDK，即可调用接口完成分数计算，无需关心内部实现逻辑。

> ⚠️ SDK 已加密保护，甲方无法直接查看源码，仅可通过对外 API 使用。

---

## 2. 准备工作

### 2.1 文件

乙方提供给甲方以下文件：

* `app-score-1.0-encrypted.jar`

### 2.2 运行环境

* JDK 1.8+
* Maven / 或者直接使用 Java 命令运行

### 2.3 启动参数

运行时必须添加 **解密参数**：

```bash
-Dxjar.password=YourStrongPassword123!@#
```

（密码由乙方提供，不可修改）

---

## 3. 引入方式

### 3.1 Maven 项目

在甲方项目 `pom.xml` 中加入：

```xml
<dependency>
    <groupId>com.sqadapter</groupId>
    <artifactId>app-score</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/app-score-1.0-encrypted.jar</systemPath>
</dependency>
```

> ⚠️ 请将 `app-score-1.0-encrypted.jar` 放到项目 `lib/` 目录下。

---

## 4. API 使用说明

### 4.1 获取 APP 分数

类：`appscore.DigitalDictionary`

```java
int score = DigitalDictionary.getScore("com.example.app1");
```

### 4.2 设置 APP 分数

```java
DigitalDictionary.setScore("com.example.app5", 88);
```

### 4.3 获取分数计算结果

类：`appscore.ScoreCalculator`

```java
import appscore.ScoreCalculator;
import appscore.ScoreResult;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ScoreCalculator calculator = new ScoreCalculator();
        List<String> apps = Arrays.asList("com.example.app1", "com.example.app2", "com.unknown.app");

        ScoreResult result = calculator.calculateScores("ORDER123", apps);

        System.out.println(result);
    }
}
```

输出示例：

```
ScoreResult{orderNo='ORDER123', totalScore=177, maxScore=92}
```

---

## 5. 运行方式

编译运行：

```bash
javac -cp app-score-1.0-encrypted.jar Demo.java
java -cp app-score-1.0-encrypted.jar:. -Dxjar.password=YourStrongPassword123!@# Demo
```
