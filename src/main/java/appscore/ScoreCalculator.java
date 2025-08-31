package appscore;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreCalculator {

    /**
     * 计算订单的分数统计
     * @param orderNo 订单号
     * @param appList APP列表
     * @return 包含订单号、总分和最高分的ScoreResult对象
     */

    // 阈值列表
    private static final double[] GT_THRESHOLDS = {1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9};
    private static final double[] LT_THRESHOLDS = {0.6, 0.7, 0.8, 0.9, 1.0};

    public static Map<String, Object> calculateScores(
            String orderNo,
            List<String> appList,
            Map<Integer, Map<String, Double>> scoreData) {

        if (orderNo == null || orderNo.trim().isEmpty()) {
            throw new IllegalArgumentException("订单号不能为空");
        }

        if (appList == null || appList.isEmpty()) {
            throw new IllegalArgumentException("APP列表不能为空");
        }

        // 返回结果
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("orderNo", orderNo);

        // 处理用户输入 appList
        List<String> cleanedApps = appList.stream()
                .map(app -> app.replaceAll("\\s+", "").toLowerCase())
                .collect(Collectors.toList());

        // 开始逐个天数key计算
        for (Integer key : scoreData.keySet()) {
            Map<String, Double> pkgScores = scoreData.get(key);

            // 获取该 key 下的用户 app 对应的分数
            List<Double> values = new ArrayList<>();
            for (String app : cleanedApps) {
                if (pkgScores.containsKey(app)) {
                    values.add(pkgScores.get(app));
                }
            }

            if (values.isEmpty()) {
                continue; // 如果没有匹配到，跳过该 key
            }

            // 计算 max/min/mean/std
            double max = values.stream().mapToDouble(v -> v).max().orElse(Double.NaN);
            double min = values.stream().mapToDouble(v -> v).min().orElse(Double.NaN);
            double mean = values.stream().mapToDouble(v -> v).average().orElse(Double.NaN);
            double std = calculateStd(values, mean);

            result.put("max_T+" + key, max);
            result.put("min_T+" + key, min);
            result.put("mean_T+" + key, mean);
            result.put("std_T+" + key, std);

            // 统计大于阈值的个数
            for (double th : GT_THRESHOLDS) {
                long count = values.stream().filter(v -> v > th).count();
                result.put(String.format("count_gt_%.2f_T+%d", th, key), count);
            }

            // 统计小于阈值的个数
            for (double th : LT_THRESHOLDS) {
                long count = values.stream().filter(v -> v < th).count();
                result.put(String.format("count_lt_%.2f_T+%d", th, key), count);
            }
        }

        return result;
    }

    private static double calculateStd(List<Double> values, double mean) {
        double variance = values.stream()
                .mapToDouble(v -> Math.pow(v - mean, 2))
                .average()
                .orElse(0.0);
        return Math.sqrt(variance);
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/main/resources/data.json");
        Map<Integer, Map<String, Double>> scoreData =
                mapper.readValue(file, new TypeReference<Map<Integer, Map<String, Double>>>() {});

        // 模拟用户输入
        String orderNo = "ORDER123456";
        List<String> appList = Arrays.asList(" com.Bancomer.mbanking ", "mx.com.tala", "unknown.app");

        // 计算结果
        Map<String, Object> result = calculateScores(orderNo, appList, scoreData);

        // 输出 JSON 格式结果
        String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        System.out.println(jsonResult);
    }
}