

## 📄 沙丘APP特征部署文档

- 版本：v1.0
- 时间：2025年9月2日

### 1. Jar 包信息

* **名称**：`app-score-1.0-shaded.jar`
* **版本**：`1.0`
* **说明**：提供APP特征计算功能，对输入的订单号及pkg_name列表进行特征计算并输出结果。

---

### 2. 集成方式

1. 将 `app-score-1.0-shaded.jar` 添加到项目依赖。

2. 运行环境：

    * JDK 1.8+
    * 无其他第三方依赖（已打包在 jar 内）

---

### 3. 核心接口说明

#### `public static String calculate(String orderNo, List<String> appList)`

* **功能说明**
  对输入的订单号和应用列表进行计算，返回特征指标。

* **参数说明**

| 参数名       | 类型             | 必填 | 说明                           |
| --------- | -------------- | -- |------------------------------|
| `orderNo` | `String`       | 是  | 订单号，唯一标识一次计算请求               |
| `appList` | `List<String>` | 是  | 应用包**pkg_name**名列表（大小写、空格不敏感） |

* **返回值**

返回 `Map<String, Object>`，包含以下字段：

| 字段名                    | 类型     | 说明     |
|------------------------| ------ |--------|
| `orderNo`              | String | 输入的订单号 |
| `max/min/mean/std_T+N` | Double | 统计型特征  |
| `count_gt/lt_x_T+N`    | Long   | 计数类特征  |

字段数目： 1 (订单号) + 285 (特征数量) 

---

### 4. 使用示例

#### 调用示例代码

```java
import java.util.Arrays;
import appscore.ScoreResult;

public class ManualTest {
    public static void main(String[] args) {
        System.out.println("=== 开始测试 app-score-1.0-shaded.jar ===");

        System.out.println(ScoreResult.calculate("2025062212Q5D8K0D6",
                Arrays.asList(
                        "cash.meprestamo.tala.credito.oxxo.efectivo.okreditopeso.cashcash.prestamo",
                        "com.bancomer.mbanking",
                        "com.citibanamex.banamexmobile",
                        "com.globalhitss.claro.pay",
                        "com.google.android.apps.walletnfcrel",
                        "com.mercadopago.wallet",
                        "com.mexicash.app",
                        "com.nu.production",
                        "com.pagopopmobile",
                        "mx.com.procesar.aforemovil.citi",
                        "mx.openbank.modelbank"
                )));
    }
}
```

代码执行结果

```
java.exe "-javaagent:D:\software\IntelliJ IDEA 2025.2\lib\idea_rt.jar=54457" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath G:\idea\TestAPPScore\out\production\TestAPPScore;G:\idea\TestAPPScore\lib\app-score-1.0-shaded.jar main.java.sq.ManualTest
=== 开始测试 app-score-1.0-shaded.jar ===
{"orderNo":"2025062212Q5D8K0D6","max_T+0":1.0607166528470495,"min_T+0":0.9359791627042967,"mean_T+0":0.9978730121105578,"std_T+0":0.05012902621558484,"count_gt_1.00_T+0":5,"count_gt_1.10_T+0":0,"count_gt_1.20_T+0":0,"count_gt_1.30_T+0":0,"count_gt_1.40_T+0":0,"count_gt_1.50_T+0":0,"count_gt_1.60_T+0":0,"count_gt_1.70_T+0":0,"count_gt_1.80_T+0":0,"count_gt_1.90_T+0":0,"count_lt_0.60_T+0":0,"count_lt_0.70_T+0":0,"count_lt_0.80_T+0":0,"count_lt_0.90_T+0":0,"count_lt_1.00_T+0":5,"max_T+1":1.0992887632908808,"min_T+1":0.9201971038545115,"mean_T+1":1.0084032558047642,"std_T+1":0.06984369485828477,"count_gt_1.00_T+1":5,"count_gt_1.10_T+1":0,"count_gt_1.20_T+1":0,"count_gt_1.30_T+1":0,"count_gt_1.40_T+1":0,"count_gt_1.50_T+1":0,"count_gt_1.60_T+1":0,"count_gt_1.70_T+1":0,"count_gt_1.80_T+1":0,"count_gt_1.90_T+1":0,"count_lt_0.60_T+1":0,"count_lt_0.70_T+1":0,"count_lt_0.80_T+1":0,"count_lt_0.90_T+1":0,"count_lt_1.00_T+1":5,"max_T+2":1.111692930141743,"min_T+2":0.9166239739758542,"mean_T+2":1.011147502756774,"std_T+2":0.07488999931809778,"count_gt_1.00_T+2":5,"count_gt_1.10_T+2":2,"count_gt_1.20_T+2":0,"count_gt_1.30_T+2":0,"count_gt_1.40_T+2":0,"count_gt_1.50_T+2":0,"count_gt_1.60_T+2":0,"count_gt_1.70_T+2":0,"count_gt_1.80_T+2":0,"count_gt_1.90_T+2":0,"count_lt_0.60_T+2":0,"count_lt_0.70_T+2":0,"count_lt_0.80_T+2":0,"count_lt_0.90_T+2":0,"count_lt_1.00_T+2":5,"max_T+3":1.1171604858307964,"min_T+3":0.9137404600743101,"mean_T+3":1.0133057992252483,"std_T+3":0.07680147486079814,"count_gt_1.00_T+3":5,"count_gt_1.10_T+3":2,"count_gt_1.20_T+3":0,"count_gt_1.30_T+3":0,"count_gt_1.40_T+3":0,"count_gt_1.50_T+3":0,"count_gt_1.60_T+3":0,"count_gt_1.70_T+3":0,"count_gt_1.80_T+3":0,"count_gt_1.90_T+3":0,"count_lt_0.60_T+3":0,"count_lt_0.70_T+3":0,"count_lt_0.80_T+3":0,"count_lt_0.90_T+3":0,"count_lt_1.00_T+3":5,"max_T+4":1.11929201612924,"min_T+4":0.9114779167625061,"mean_T+4":1.0135217038840132,"std_T+4":0.0779234701985177,"count_gt_1.00_T+4":5,"count_gt_1.10_T+4":2,"count_gt_1.20_T+4":0,"count_gt_1.30_T+4":0,"count_gt_1.40_T+4":0,"count_gt_1.50_T+4":0,"count_gt_1.60_T+4":0,"count_gt_1.70_T+4":0,"count_gt_1.80_T+4":0,"count_gt_1.90_T+4":0,"count_lt_0.60_T+4":0,"count_lt_0.70_T+4":0,"count_lt_0.80_T+4":0,"count_lt_0.90_T+4":0,"count_lt_1.00_T+4":5,"max_T+5":1.123114792786734,"min_T+5":0.9093086147670476,"mean_T+5":1.0142032702492572,"std_T+5":0.07940447217623788,"count_gt_1.00_T+5":5,"count_gt_1.10_T+5":2,"count_gt_1.20_T+5":0,"count_gt_1.30_T+5":0,"count_gt_1.40_T+5":0,"count_gt_1.50_T+5":0,"count_gt_1.60_T+5":0,"count_gt_1.70_T+5":0,"count_gt_1.80_T+5":0,"count_gt_1.90_T+5":0,"count_lt_0.60_T+5":0,"count_lt_0.70_T+5":0,"count_lt_0.80_T+5":0,"count_lt_0.90_T+5":0,"count_lt_1.00_T+5":5,"max_T+6":1.1240882658535403,"min_T+6":0.9068522830442387,"mean_T+6":1.0142854566132093,"std_T+6":0.08030531367887159,"count_gt_1.00_T+6":4,"count_gt_1.10_T+6":2,"count_gt_1.20_T+6":0,"count_gt_1.30_T+6":0,"count_gt_1.40_T+6":0,"count_gt_1.50_T+6":0,"count_gt_1.60_T+6":0,"count_gt_1.70_T+6":0,"count_gt_1.80_T+6":0,"count_gt_1.90_T+6":0,"count_lt_0.60_T+6":0,"count_lt_0.70_T+6":0,"count_lt_0.80_T+6":0,"count_lt_0.90_T+6":0,"count_lt_1.00_T+6":6,"max_T+7":1.1239751518395507,"min_T+7":0.9060081085177845,"mean_T+7":1.01446691386539,"std_T+7":0.08084704554286425,"count_gt_1.00_T+7":4,"count_gt_1.10_T+7":2,"count_gt_1.20_T+7":0,"count_gt_1.30_T+7":0,"count_gt_1.40_T+7":0,"count_gt_1.50_T+7":0,"count_gt_1.60_T+7":0,"count_gt_1.70_T+7":0,"count_gt_1.80_T+7":0,"count_gt_1.90_T+7":0,"count_lt_0.60_T+7":0,"count_lt_0.70_T+7":0,"count_lt_0.80_T+7":0,"count_lt_0.90_T+7":0,"count_lt_1.00_T+7":6,"max_T+8":1.1247020041162479,"min_T+8":0.9059605265391729,"mean_T+8":1.0148630942680779,"std_T+8":0.08116822562776392,"count_gt_1.00_T+8":4,"count_gt_1.10_T+8":2,"count_gt_1.20_T+8":0,"count_gt_1.30_T+8":0,"count_gt_1.40_T+8":0,"count_gt_1.50_T+8":0,"count_gt_1.60_T+8":0,"count_gt_1.70_T+8":0,"count_gt_1.80_T+8":0,"count_gt_1.90_T+8":0,"count_lt_0.60_T+8":0,"count_lt_0.70_T+8":0,"count_lt_0.80_T+8":0,"count_lt_0.90_T+8":0,"count_lt_1.00_T+8":6,"max_T+9":1.1243725352429228,"min_T+9":0.906219285659412,"mean_T+9":1.0151830911445077,"std_T+9":0.081376818233593,"count_gt_1.00_T+9":4,"count_gt_1.10_T+9":2,"count_gt_1.20_T+9":0,"count_gt_1.30_T+9":0,"count_gt_1.40_T+9":0,"count_gt_1.50_T+9":0,"count_gt_1.60_T+9":0,"count_gt_1.70_T+9":0,"count_gt_1.80_T+9":0,"count_gt_1.90_T+9":0,"count_lt_0.60_T+9":0,"count_lt_0.70_T+9":0,"count_lt_0.80_T+9":0,"count_lt_0.90_T+9":0,"count_lt_1.00_T+9":6,"max_T+10":1.1244950323296576,"min_T+10":0.9061630059731366,"mean_T+10":1.0153230665131248,"std_T+10":0.08157893710174621,"count_gt_1.00_T+10":4,"count_gt_1.10_T+10":2,"count_gt_1.20_T+10":0,"count_gt_1.30_T+10":0,"count_gt_1.40_T+10":0,"count_gt_1.50_T+10":0,"count_gt_1.60_T+10":0,"count_gt_1.70_T+10":0,"count_gt_1.80_T+10":0,"count_gt_1.90_T+10":0,"count_lt_0.60_T+10":0,"count_lt_0.70_T+10":0,"count_lt_0.80_T+10":0,"count_lt_0.90_T+10":0,"count_lt_1.00_T+10":6,"max_T+15":1.1230347597733599,"min_T+15":0.904860001273133,"mean_T+15":1.0146200327134098,"std_T+15":0.08159636076154264,"count_gt_1.00_T+15":4,"count_gt_1.10_T+15":2,"count_gt_1.20_T+15":0,"count_gt_1.30_T+15":0,"count_gt_1.40_T+15":0,"count_gt_1.50_T+15":0,"count_gt_1.60_T+15":0,"count_gt_1.70_T+15":0,"count_gt_1.80_T+15":0,"count_gt_1.90_T+15":0,"count_lt_0.60_T+15":0,"count_lt_0.70_T+15":0,"count_lt_0.80_T+15":0,"count_lt_0.90_T+15":0,"count_lt_1.00_T+15":6,"max_T+20":1.122796205993898,"min_T+20":0.9051112476815566,"mean_T+20":1.0147308183950403,"std_T+20":0.08161572026750243,"count_gt_1.00_T+20":4,"count_gt_1.10_T+20":2,"count_gt_1.20_T+20":0,"count_gt_1.30_T+20":0,"count_gt_1.40_T+20":0,"count_gt_1.50_T+20":0,"count_gt_1.60_T+20":0,"count_gt_1.70_T+20":0,"count_gt_1.80_T+20":0,"count_gt_1.90_T+20":0,"count_lt_0.60_T+20":0,"count_lt_0.70_T+20":0,"count_lt_0.80_T+20":0,"count_lt_0.90_T+20":0,"count_lt_1.00_T+20":6,"max_T+25":1.1227176117096729,"min_T+25":0.9045758142946784,"mean_T+25":1.0144214826884175,"std_T+25":0.08174880146874082,"count_gt_1.00_T+25":4,"count_gt_1.10_T+25":2,"count_gt_1.20_T+25":0,"count_gt_1.30_T+25":0,"count_gt_1.40_T+25":0,"count_gt_1.50_T+25":0,"count_gt_1.60_T+25":0,"count_gt_1.70_T+25":0,"count_gt_1.80_T+25":0,"count_gt_1.90_T+25":0,"count_lt_0.60_T+25":0,"count_lt_0.70_T+25":0,"count_lt_0.80_T+25":0,"count_lt_0.90_T+25":0,"count_lt_1.00_T+25":6,"max_T+30":1.123204734252411,"min_T+30":0.9042909505793527,"mean_T+30":1.0143776389405295,"std_T+30":0.0818778129021691,"count_gt_1.00_T+30":4,"count_gt_1.10_T+30":2,"count_gt_1.20_T+30":0,"count_gt_1.30_T+30":0,"count_gt_1.40_T+30":0,"count_gt_1.50_T+30":0,"count_gt_1.60_T+30":0,"count_gt_1.70_T+30":0,"count_gt_1.80_T+30":0,"count_gt_1.90_T+30":0,"count_lt_0.60_T+30":0,"count_lt_0.70_T+30":0,"count_lt_0.80_T+30":0,"count_lt_0.90_T+30":0,"count_lt_1.00_T+30":6}
```

---

### 5. 错误和异常说明

| 输入场景          | 类型 | 输出                                                                  |
|-------------------|----|---------------------------------------------------------------------|
| pkg_name列表不为空但未纳入特征计算口径 | 特殊 | {"orderNo":"2025062212Q5D8K0D6"}                                                      |
| 订单号为空字符串      | 报错 | Exception in thread "main" java.lang.RuntimeException: 计算失败: 订单号不能为空 |
| pkg_name列表为空     | 报错 | Exception in thread "main" java.lang.RuntimeException: 计算失败: APP列表不能为空 |

