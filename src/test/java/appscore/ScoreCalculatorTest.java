//package appscore;  // 包名与主代码一致
//import java.util.Arrays;
//import java.util.List;
//
//public class ScoreCalculatorTest {
//    public static void main(String[] args) {
//        // 创建计算器实例
//        ScoreCalculator calculator = new ScoreCalculator();
//        // 准备测试数据
//        String orderNo = "ORDER123456";
//        List<String> appList = Arrays.asList("com.example.app1", "com.example.app2", "com.example.app3");
//
//        try {
//            // 调用计算方法
//            ScoreResult result = calculator.calculateScores(orderNo, appList);
//
//            // 输出结果
//            System.out.println("订单号: " + result.getOrderNo());
//            System.out.println("总分: " + result.getTotalScore());
//            System.out.println("最高分: " + result.getMaxScore());
//
//        } catch (IllegalArgumentException e) {
//            System.out.println("输入参数错误: " + e.getMessage());
//        }
//    }
//}